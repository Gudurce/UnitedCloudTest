package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import testcases.bases.BaseCreateProfile;

@UseTestDataFrom("src/test/resources/testdata/navigate.csv")
@RunWith(SerenityParameterizedRunner.class)
public class TestNavigation extends BaseCreateProfile {
    @Title("Navigate from \"Create new profile\" previously opened from \"Details\" page to \"Home\" page")
    @Test
    public void navigateHomePageFromDetailsPage() {
        testSteps.selectProfile("Family").createProfileFromDetailsPage();
        testSteps.backToHomePage();
        Assert.assertFalse("Navigation to Home failed", testSteps.isChooseProfilePageActive("choose-profile"));
    }

    @Title("Navigate from \"Create new profile\" previously opened from \"Choose profile\" page to \"Home\" page")
    @Test
    public void navigateHomePageFromChooseProfilePage() {
        testSteps.openCreateProfileFromChoosePage();
        testSteps.backToHomePage();
        Assert.assertTrue("Navigation to Home failed", testSteps.isChooseProfilePageActive("choose-profile"));
    }

    @Title("Log out")
    @Test
    public void logout() {
        testSteps.selectProfile("Family").logout();
        Assert.assertTrue("Logout failed", testSteps.isLoginPageActive());
    }
}
