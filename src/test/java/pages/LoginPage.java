package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;
import utils.PropertyReader;

@Log4j2
public class LoginPage extends BasePage {
    private final static By LOGIN_BUTTON = By.cssSelector(".single-sign-on");
    private final static By EMAIL_INPUT = By.cssSelector("input#name");
    private final static By PASSWORD_INPUT = By.cssSelector("input#password");
    private final static By ERROR_MESSAGE = By.cssSelector(".error-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("wait for login page loaded")
    public void waitForLoginPageLoaded() {
        log.info("wait for page loaded");
        waitForElementClickable(LOGIN_BUTTON);

    }

    public void open() {
        driver.get(PropertyReader.getProperty("test_rail.login_url"));
    }

    @Step("setting password")
    public void setPassword(String password) {
        log.info("fill password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("setting email")
    public void setEmail(String email) {
        log.info("fill email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("click login button")
    public void clickLoginButton() {
        log.info("click login button");
        driver.findElement(LOGIN_BUTTON).click();

    }

    @Step("check is error message displayed")
    public boolean isErrorMessageDisplayed() {
        waitForElementDisplayed(ERROR_MESSAGE);
        log.info("is error message displayed");
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Step("check error message text")
    public String getErrorMessageText() {
        log.info("get error message text");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Attachment(value = "screenshot", type = "image/png")
    @Step("setting email, password and clicking login button")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        AllureUtils.attachScreenshot(driver);
        clickLoginButton();

    }
}
