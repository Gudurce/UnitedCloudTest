package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import testcases.bases.BaseCreateProfile;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;

@UseTestDataFrom("src/test/resources/testdata/createToManyAccounts")
@RunWith(SerenityParameterizedRunner.class)
public class TestCreateToManyProfiles extends BaseCreateProfile {
    private int maxNumberOfProfiles = 5;

    @Title("Try to create a profile with to many profiles already created")
    @TestsRequirement("Create profile")
    @Test
    public void testCreateMaxProfiles() {
        for (int i = testSteps.getProfilesCount(); i <= maxNumberOfProfiles; i++) {
            createProfileFromChoosePage();
            testSteps.clickChooseProfileFromProfileDetailsPage();
        }

        Assert.assertFalse("\"Create profile\" button is visible and enabled", testSteps.isCreateButtonExists());
        testSteps.selectProfile("Family");

        createProfileFromDetailsPage();
        Assert.assertTrue("Error message: \"Maximum number of profiles reached for this user.\" is not shown", testSteps.isMaximumProfilesErrorVisible());

        testSteps.backToHomePage().clickChooseProfileFromProfileDetailsPage();
        deleteProfile();
    }
}