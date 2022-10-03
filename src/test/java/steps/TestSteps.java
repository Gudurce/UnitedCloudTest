package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import pages.PageChooseProfile;
import pages.PageCreateProfile;
import pages.PageLogin;
import pages.PageProfileDetails;

import java.util.List;

public class TestSteps extends UIInteractionSteps {

    //region Pages constructors
    PageChooseProfile pageChooseProfile = new PageChooseProfile();
    PageCreateProfile pageCreateProfile = new PageCreateProfile();
    PageLogin pageLogin = new PageLogin();
    PageProfileDetails pageProfileDetails = new PageProfileDetails();
    //endregion

    //region Methods for Login page
    @Title("Open Login page")
    @Step
    public TestSteps init() {
        pageLogin.open();
        return this;
    }

    @Title("Fast login")
    @Step
    public TestSteps fastInit(String username, String password) {
        init().enterUsernameAndPassword(username, password).clickOnLoginButton();
        return this;
    }

    @Title("Enter username and password")
    @Step
    public TestSteps enterUsernameAndPassword(String username, String password){
        pageLogin.enterUserNameAndPassword(username, password);
        return this;
    }

    @Title("Click on login button")
    @Step
    public TestSteps clickOnLoginButton(){
        pageLogin.clickOnLoginButton();

        return this;
    }

    public boolean isLoginPageActive() {
        return pageLogin.isPageActive("login");
    }
    //endregion

    //region Methods for Choose Profile page
    @Title("Select profile")
    @Step
    public TestSteps selectProfile(String profileName) {
        pageChooseProfile.selectProfile(profileName);
        return this;
    }

    @Title("Profile exists")
    @Step
    public Boolean profileExists(String profileName) {
        return pageChooseProfile.IsProfileExists(profileName);
    }

    @Title("Open new profile page")
    @Step
    public TestSteps openCreateProfileFromChoosePage() {
        pageChooseProfile.clickNewProfileButton();
        return this;
    }

    public int getProfilesCount() {
        return pageChooseProfile.getProfilesCount();
    }

    public List<String> getProfileNames() {
        return pageChooseProfile.getProfileNames();
    }

    public boolean isCreateButtonExists() {
        return pageChooseProfile.isCreateButtonVisible();
    }

    public int getProfileInstancesCount(String profileName) {
        return pageChooseProfile.getProfileInstancesCount(profileName);
    }

    public boolean isChooseProfilePageActive(String url) {
        return pageChooseProfile.isPageActive(url);
    }
    //endregion

    //region Methods for Create Profile page
    @Title("Enter new profile information")
    @Step
    public TestSteps enterNewProfileInformation(String profileName, PageCreateProfile.Age age, Integer yearOfBirth) {
        pageCreateProfile.enterNewProfileInformation(profileName, age, yearOfBirth);
        return this;
    }

    @Title("Create a new profile")
    @Step
    public TestSteps createNewProfile() {
        pageCreateProfile.clickCreateProfileButton();
        return this;
    }

    @Title("Back to Home Page")
    @Step
    public TestSteps backToHomePage() {
        pageCreateProfile.clickHomeButton();
        return this;
    }

    public boolean isMaximumProfilesErrorVisible() {
        return pageCreateProfile.isMaxProfilesErrorVisible();
    }

    public boolean isCreateProfilePageActive(String url) {
        return pageCreateProfile.isPageActive(url);
    }

    //endregion

    //region Methods for Profile Details page
    @Title("Retrieve profile name")
    @Step
    public String getProfileName() {
        return pageProfileDetails.getProfileName();
    }

    @Title("Get profile type")
    @Step
    public String getProfileType() {
        return pageProfileDetails.getProfileType();
    }

    @Title("Delete profile")
    @Step
    public TestSteps deleteProfile() {
        pageProfileDetails.clickDeleteProfileButton();
        return this;
    }

    @Title("Create profile from Details Page")
    @Step
    public TestSteps createProfileFromDetailsPage() {
        pageProfileDetails.clickCreateProfileButton();
        return this;
    }

    @Title("Choose profile from Profile Details page")
    @Step
    public TestSteps clickChooseProfileFromProfileDetailsPage() {
        pageProfileDetails.clickChooseProfileButton();
        return this;
    }

    @Title("Logout")
    @Step
    public TestSteps logout() {
        pageProfileDetails.clickLogoutButton();
        return this;
    }
    //endregion
}
