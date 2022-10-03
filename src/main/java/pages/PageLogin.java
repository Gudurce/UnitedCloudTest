package pages;

public class PageLogin extends PageBase {

    //region Locators
    private final String PATH_INPUTFIELD_PASSWORD = "//input[@id='password']";
    private final String PATH_INPUTFIELD_USERNAME = "//input[@id='username']";
    private final String PATH_BUTTON_LOGIN = "//button[@type='submit']";
    private final String PATH_ERRORMESSAGE_LOGIN = "//span[contains(@class='form__error')]";

    //endregion

    //region Actions
    public PageLogin enterUserNameAndPassword(String username, String password) {
        type(PATH_INPUTFIELD_USERNAME, username);
        type(PATH_INPUTFIELD_PASSWORD, password);
        return this;
    }

    public PageLogin clickOnLoginButton() {
        click(PATH_BUTTON_LOGIN);
        return this;
    }

    public PageLogin enterUsername(String username) {
        type(PATH_INPUTFIELD_USERNAME, username);
        return this;
    }

    public PageLogin enterPassword(String password) {
        type(PATH_INPUTFIELD_PASSWORD, password);
        return this;
    }
    public boolean errorMessageVisible () {
        return isVisible(PATH_ERRORMESSAGE_LOGIN);
    }
    //endregion
}


