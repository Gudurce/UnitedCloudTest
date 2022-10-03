package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import testcases.bases.BaseCreateProfile;

@UseTestDataFrom("src/test/resources/testdata/1.csv")
//@UseTestDataFrom("src/test/resources/testdata/createProfile.csv")
@RunWith(SerenityParameterizedRunner.class)
public class TestCreateProfile extends BaseCreateProfile {

    @Title("Create new profile")
    @TestsRequirement("Create profile")
    @Test
    public void testCreateProfile() {
        deleteProfile();
        createProfileFromChoosePage();

        if (Boolean.parseBoolean(passed)) {
            Assert.assertTrue("Profile " + profileName + " not created", testSteps.getProfileName().equals(profileName));
            testSteps.deleteProfile();
        } else {
            boolean isProfileCreated = !testSteps.isCreateProfilePageActive(url);
            if (isProfileCreated) {
                testSteps.deleteProfile();
            }
            Assert.assertFalse("Profile " + profileName + " created and it should not be", isProfileCreated);
        }
    }
}
