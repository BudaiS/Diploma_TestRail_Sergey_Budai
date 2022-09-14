package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constans.Constant.LoginTestsConstants.*;

public class LoginTests extends BaseTests {

    @Test
    public void loginTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        Assert.assertTrue(dashboardPage.isAddProjectButtonDisplayed());

    }

    @Test(dataProvider = "negativeLoginTests")
    public void negativeLoginTests(String email, String password, String errorMessage) {
        loginPage.waitForLoginPageLoaded();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Checking for an error message");
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage,
                "Checking the correctness of the error text");

    }

    @DataProvider
    public Object[][] negativeLoginTests() {
        return new Object[][]{
                {INCORRECT_EMAIL, PASSWORD, ERROR_MESSAGE_TEXT},
                {EMAIL, INCORRECT_PASSWORD, ERROR_MESSAGE_TEXT},
                {INCORRECT_EMAIL, INCORRECT_PASSWORD, ERROR_MESSAGE_TEXT},
        };

    }


}
