package pages;

public class PageProfileDetails extends PageBase {

    //region Locators
    private final String PATH_LABEL_PROFILE_NAME = "//h2[@class='card__profile-name']";
    private final String PATH_LABEL_PROFILE_TYPE = "//span[@class='card__profile-type']";
    private final String PATH_BUTTON_LOGOUT = "//button[text()='Logout']";
    private final String PATH_BUTTON_DELETE_PROFILE = "//button[contains(text(),'Delete profile')]";
    private final String PATH_BUTTON_CREATE_PROFILE = "//button[contains(text(),'Create profile')]";
    private final String PATH_BUTTON_CHOOSE_PROFILE = "//button[contains(text(),'Choose profile')]";
    //endregion

    //region Actions
    public PageProfileDetails clickDeleteProfileButton() {
        click(PATH_BUTTON_DELETE_PROFILE);
        return this;
    }

    public PageProfileDetails clickLogoutButton() {
        click(PATH_BUTTON_LOGOUT);
        return this;
    }

    public PageProfileDetails clickChooseProfileButton() {
        click(PATH_BUTTON_CHOOSE_PROFILE);
        return this;
    }

    public PageProfileDetails clickCreateProfileButton() {
        click(PATH_BUTTON_CREATE_PROFILE);
        return this;
    }

    public String getProfileName() {
        return getText(PATH_LABEL_PROFILE_NAME);
    }

    public String getProfileType() {
        return getText(PATH_LABEL_PROFILE_TYPE);
    }
    //endregion
}
