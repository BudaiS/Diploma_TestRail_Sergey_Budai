package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private final static String CONFIRM_DELETE_INPUT = "//strong[text()='%s']";
    private final static By CONFIRM_DELETE_OK_BUTTON = By.xpath("//div[@id='deleteDialog']//following-sibling::a[contains(@class,'button-ok')]");
    private final static By CONFIRM_DELETE = By.xpath("//strong[contains(text(),'Yes, delete this')]");
    protected By IMAGE = By.xpath("//img[contains(@id,'pendo-image-badge')]");
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public abstract void waitForPageLoaded();

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }

    public void waitForElementDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickConfirmDeleteOkButton() {
        waitForElementClickable(CONFIRM_DELETE_OK_BUTTON);
        driver.findElement(CONFIRM_DELETE_OK_BUTTON).click();
    }

    public void clickConfirmDeleteInput(String confirmationText) {
        waitForElementClickable(CONFIRM_DELETE);
        driver.findElement(By.xpath
                (String.format(CONFIRM_DELETE_INPUT, confirmationText))).click();

    }


}
