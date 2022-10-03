package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageCreateProfile extends PageBase {

    //region Locators
    private final String PATH_INPUTFIELD_PROFILE_NAME = "//input[@id='profile-name']";
    private final String PATH_AGE_SELECTION_BASE = "//*[@id='%s']/..";
    private final String PATH_INPUTFIELD_BIRTHYEAR = "//input[@id='year']";
    private final String PATH_AVATAR_LIST = "//*[@class='avatar']/input";
    private final String PATH_CONTAINER_WITH_AVATARS = "//div[@class='avatars']";
    private final String PATH_AVATAR = "//*[@id='%s']/..";
    private final String PATH_BUTTON_CREATE_PROFILE = "//button[@type='submit']";
    private final String PATH_BUTTON_HOME = "//button[contains(text(),'Home')]";
    private final String PATH_ERRORMESSAGE_MAXIMUM_PROFILES = "//[@class='form__error']";

    //endregion

    //region Actions
    public PageCreateProfile clickHomeButton() {

        click(PATH_BUTTON_HOME);
        return this;
    }

    public PageCreateProfile clickCreateProfileButton() {
        click(PATH_BUTTON_CREATE_PROFILE);
        return this;
    }

    public PageCreateProfile enterNewProfileInformation(String profileName, Age age, Integer yearOfBirth) {
        type(PATH_INPUTFIELD_PROFILE_NAME,profileName);

        click(String.format(PATH_AGE_SELECTION_BASE, age.toString()));
        if (age.equals(Age.AGE_18_PLUS)) {
            if (yearOfBirth != null) {
                type(PATH_INPUTFIELD_BIRTHYEAR, yearOfBirth.toString());
            }
        }
        //waitForRenderedElementsToBePresent(getDriver().findElement(By.xpath(PATH_CONTAINER_WITH_AVATARS)));
        waitForRenderedElementsToBePresent(By.xpath(PATH_CONTAINER_WITH_AVATARS));
        scroolToElementAndClick(String.format(PATH_AVATAR, randomAvatarID()));

//        Integer randomAvatar = randomAvatarID();
//        waitForRenderedElementsToBePresent(String.format(pathAvatar, randomAvatar));
//        scroolToElementAndClick(String.format(pathAvatar, randomAvatar));

        return this;
    }

    public boolean isMaxProfilesErrorVisible() {
        return isVisible(PATH_ERRORMESSAGE_MAXIMUM_PROFILES);
    }
    //endregion

    //region Private methods
    private Integer randomAvatarID() {
        List<String> avatarIDs = getAvatarIDs();
        Random random = new Random(System.currentTimeMillis());
        return Integer.parseInt(avatarIDs.get(random.nextInt(avatarIDs.size())));
    }

    private List<String> getAvatarIDs() {
        List<String> avatarIDs = new ArrayList<>();

        for (WebElement avatar : getElements(PATH_AVATAR_LIST)) {
            avatarIDs.add(avatar.getAttribute("id"));
        }
        return avatarIDs;
    }
    //endregion

    //region Misc
    public enum Age {
        AGE_0_6,
        AGE_7_11,
        AGE_12_14,
        AGE_15_17,
        AGE_18_PLUS
    };
    //endregion
}
