package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.core.annotations.Title;
import testcases.bases.BaseLogin;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;

@UseTestDataFrom("src/test/resources/testdata/loginCredentials.csv")
@RunWith(SerenityParameterizedRunner.class)
public class TestLogin extends BaseLogin {

    @Title("Login")
    @Test
    public void login() {
        doLogin(username, password);

        if (Boolean.parseBoolean(isLoggedIn)) {
            Assert.assertTrue("Login failed: " + username + "/" + password, testSteps.isChooseProfilePageActive(url));
        } else {
            Assert.assertTrue("Invalid login failed: " + username + "/" + password, testSteps.isLoginPageActive());
        }
    }
}
