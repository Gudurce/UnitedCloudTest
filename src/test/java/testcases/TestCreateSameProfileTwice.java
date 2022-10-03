package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import testcases.bases.BaseCreateProfile;

@UseTestDataFrom("src/test/resources/testdata/createSameProfileTwice.csv")
@RunWith(SerenityParameterizedRunner.class)
public class TestCreateSameProfileTwice extends BaseCreateProfile {
    @Title("Create the same profile twice")
    @TestsRequirement("Create profile")
    @Test
    public void createSameProfileTwice() {
        createProfileFromChoosePage();
        Assert.assertTrue("Profile \"" + profileName + "\" is not created", testSteps.getProfileName().equals(profileName));

        createProfileFromDetailsPage();
        Assert.assertTrue("Profile \"" + profileName + "\" is not created", testSteps.getProfileName().equals(profileName));

        testSteps.clickChooseProfileFromProfileDetailsPage();
        boolean accountCreatedTwice = testSteps.getProfileInstancesCount(profileName) >= 2;
        deleteProfile();

        Assert.assertFalse("Profile \"" + profileName +"\" is created more than once!", accountCreatedTwice);
    }
}
