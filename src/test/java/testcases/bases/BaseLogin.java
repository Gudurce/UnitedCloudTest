package testcases.bases;

import net.thucydides.core.annotations.Steps;
import steps.TestSteps;

public class BaseLogin {
    @Steps
    protected TestSteps testSteps;

    protected String username;
    protected String password;

    protected String isLoggedIn;
    protected String url;

    protected void doLogin(String username, String password){
        testSteps.
                init().
                enterUsernameAndPassword(username,password).
                clickOnLoginButton();
    }
}
