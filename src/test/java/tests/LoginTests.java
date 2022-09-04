package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    private final static String ERROR_MESSAGE_TEXT = "Email/Login or Password is incorrect. Please try again.";
    private final static String INCORRECT_EMAIL = "abcd";
    private final static String INCORRECT_PASSWORD = "abcde";

    @Test
    public void loginTests() {
        loginPage.waitForPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        Assert.assertTrue(dashboardPage.isAddProjectButtonDisplayed());

    }

    @Test(dataProvider = "negativeLoginTests")
    public void negativeLoginTests(String email, String password, String errorMessage) {
        loginPage.waitForPageLoaded();
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
