package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageChooseProfile extends PageBase {

    //region Locators
    private final String PATH_BUTTON_NEW_PROFILE = "//button[contains(text(),'Create new profile')]";
    private final String PATH_PROFILES_LIST = "//*[@class='profiles__profile']";
    private final String PATH_SINGLE_PROFILE_NAME = "//*[@class='profiles__profile-name']";
    private final String PROFILE_NAME_EXTENSION = "[contains(text(),'%s')]";
    //endregion

    //region Actions
    public PageChooseProfile clickNewProfileButton() {
        click(PATH_BUTTON_NEW_PROFILE);
        return this;
    }

    public PageChooseProfile selectProfile(String profileName) {
        click(String.format(PATH_SINGLE_PROFILE_NAME + PROFILE_NAME_EXTENSION, profileName));
        return this;
    }

    public List<String> getProfileNames() {
        List<String> profileNames = new ArrayList<>();

        for (WebElement profile : getDriver().findElements(By.xpath(PATH_PROFILES_LIST))) {
            profileNames.add(profile.getText());
        }

        return profileNames;
    }

    public boolean isCreateButtonVisible() {
        return isVisible(PATH_BUTTON_NEW_PROFILE);
    }

    public int getProfilesCount() {
        return getElements(PATH_PROFILES_LIST).size();
    }

    public int getProfileInstancesCount(String profileName) {
        int count = 0;

        for (String name: getProfileNames()) {
            if (profileName.equals(name)) { count++; }
        }
        return count;
    }

    public Boolean IsProfileExists(String profileName) {
        return getProfileNames().contains(profileName);
    }
    //endregion
}
