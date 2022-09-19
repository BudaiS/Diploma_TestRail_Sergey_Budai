package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constans.Constant.TimeoutVariable.EXPLICIT_WAIT;

@Log4j2

public abstract class HomePage extends BasePage {
    private final static String HEADER_MENU_ITEM = "//ul[@class='header-menu']//descendant::a[text()='%s']";
    private final static String CONFIRM_DELETE_INPUT = "//strong[text()='%s']";
    private final static By CONFIRM_DELETE_OK_BUTTON = By.xpath("//div[@id='deleteDialog']//following-sibling::a[contains(@class,'button-ok')]");
    private final static By CONFIRM_DELETE = By.xpath("//strong[contains(text(),'Yes, delete this')]");
    private final static By ACCESS_MESSAGE = By.cssSelector(".message.message-success");
    private final static By EDIT_BUTTON_LOCATOR = By.xpath("//a[contains(@class,'button-edit')]");
    private final static By DELETE_OVERALL_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'button-delete')]");
    private final static By ADD_OVERALL_IN_ADD_PAGE_BUTTON = By.id("accept");
    private final static String ADD_OVERALL_IN_ENTITY_PAGE_BUTTON_LOCATOR = "//span[text()='%s']";
    protected Actions actions = new Actions(driver);
    protected WebDriverWait wait;


    public HomePage(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);

    }

    @Step("open {headerName}")
    public void openHeaderByName(String headerName) {
        log.debug(String.format("Click %s header", headerName));
        driver.findElement(By.xpath
                (String.format(HEADER_MENU_ITEM, headerName))).click();

    }

    @Step("click confirm delete OK button")
    public void clickConfirmDeleteOkButton() {
        waitForElementClickable(CONFIRM_DELETE_OK_BUTTON);
        log.info("click confirm delete ok button");
        driver.findElement(CONFIRM_DELETE_OK_BUTTON).click();
    }

    @Step("click confirm delete input")
    public void clickConfirmDeleteInput(String confirmationText) {
        waitForElementClickable(CONFIRM_DELETE);
        log.info(String.format("Click confirm delete input on text %s", confirmationText));
        driver.findElement(By.xpath
                (String.format(CONFIRM_DELETE_INPUT, confirmationText))).click();

    }

    @Step("check message is displayed")
    public boolean isAccessMessageDisplayed() {
        log.info("return message is displayed");
        return driver.findElement(ACCESS_MESSAGE).isDisplayed();
    }

    @Step("check message text")
    public String getAccessMessageText() {
        log.info("return message text");
        return driver.findElement(ACCESS_MESSAGE).getText();
    }

    @Step("click edit button")
    public void clickEditButton() {
        waitForElementClickable(EDIT_BUTTON_LOCATOR);
        log.info("click edit button");
        driver.findElement(EDIT_BUTTON_LOCATOR).click();
    }

    @Step("click delete button")
    public void clickOverallDeleteButton() {
        WebElement button = driver.findElement(DELETE_OVERALL_BUTTON_LOCATOR);
        log.debug(String.format("scroll to %s", button));
        scrollIntoView(button);
        log.info("click button");
        button.click();
    }

    @Step("click add button")
    public void clickOverallAddInAddPageButton() {
        WebElement button = driver.findElement(ADD_OVERALL_IN_ADD_PAGE_BUTTON);
        log.debug(String.format("scroll to %s", button));
        scrollIntoView(button);
        log.info("click add button");
        button.click();
    }

    @Step("click add button")
    public void clickOverallAddInEntityPageButton(String entityName) {
        log.info(String.format("Click %s", entityName));
        driver.findElement(By.xpath
                (String.format(ADD_OVERALL_IN_ENTITY_PAGE_BUTTON_LOCATOR, entityName))).click();

    }

    public void waitForTextToBe(String text) {
        wait.until(ExpectedConditions.textToBe(ACCESS_MESSAGE, text));
    }


}



