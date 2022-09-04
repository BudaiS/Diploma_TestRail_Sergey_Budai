package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final static String URL = "https://budai.testrail.io";
    private final static By LOGIN_BUTTON = By.cssSelector(".single-sign-on");
    private final static By EMAIL_INPUT = By.cssSelector("input#name");
    private final static By PASSWORD_INPUT = By.cssSelector("input#password");
    private final static By ERROR_MESSAGE = By.cssSelector(".error-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(LOGIN_BUTTON);

    }

    public void open() {
        driver.get(URL);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void setEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();

    }

    public boolean isErrorMessageDisplayed() {
        waitForElementDisplayed(ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
