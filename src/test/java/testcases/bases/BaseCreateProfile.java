package testcases.bases;

import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import steps.TestSteps;
import pages.PageCreateProfile;

public class BaseCreateProfile {
    @Steps
    public TestSteps testSteps;
    private String fastInitUsername = "branislav.guduric";
    private String fastInitPassword = "Lozinka123";

    protected String profileName;
    protected String age;
    protected String yearOfBirth;
    protected String passed;
    protected String url;

    @Before
    public void initialiseTest() {
        fastInit();
    }

    private void fastInit() {
        testSteps.fastInit(fastInitUsername, fastInitPassword);
    }

    protected void createProfileFromChoosePage() {
        PageCreateProfile.Age ageValue = (age == null || age.isEmpty()) ? null : PageCreateProfile.Age.valueOf("AGE_" + age.replace('-', '_'));
        Integer birthYearInt = !(yearOfBirth == null || yearOfBirth.isEmpty()) ? Integer.parseInt(yearOfBirth) : null;

        testSteps.openCreateProfileFromChoosePage().
                enterNewProfileInformation(profileName, ageValue, birthYearInt).
                createNewProfile();
    }

    protected void createProfileFromDetailsPage() {
        PageCreateProfile.Age ageValue = (age == null || age.isEmpty()) ? null : PageCreateProfile.Age.valueOf("AGE_" + age.replace('-', '_'));
        Integer birthYearInt = !(yearOfBirth == null || yearOfBirth.isEmpty()) ? Integer.parseInt(yearOfBirth) : null;

        testSteps.createProfileFromDetailsPage().
                enterNewProfileInformation(profileName, ageValue, birthYearInt).
                createNewProfile();
    }

    protected void deleteProfile() {
        while (testSteps.profileExists(profileName)) {
            testSteps.selectProfile(profileName).deleteProfile();
        }
    }
}
