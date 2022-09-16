package pages.milestones;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

@Log4j2
public class MilestonesPage extends HomePage {

    private final static By EXPAND_BUTTON_LOCATOR = By.cssSelector("a.expand div");
    private final static By ENTITY_MILESTONES_INPUT_LOCATOR = By.xpath("//tr[@class='odd hoverSensitive']//following-sibling::input");
    private final static By DELETE_SELECTED_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'button-delete')]");
    private final static By CONFIRM_DELETE_INPUT_LOCATOR = By.cssSelector("input#confirm-check");
    private final static By CONFIRM_DELETE_BUTTON_LOCATOR = By.xpath("//a[contains(@class,'button-black')]");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Step("click expand button")
    public void clickExpandButton() {
        waitForElementClickable(EXPAND_BUTTON_LOCATOR);
        log.info("click expand button");
        driver.findElement(EXPAND_BUTTON_LOCATOR).click();
    }

    @Step("click entity milestone checkbox")
    public void clickEntityMilestonesCheckbox() {
        waitForElementClickable(ENTITY_MILESTONES_INPUT_LOCATOR);
        log.info("click entity milestone checkbox");
        driver.findElement(ENTITY_MILESTONES_INPUT_LOCATOR).click();
    }

    @Step("click delete selected button")
    public void clickDeleteSelectedButton() {
        waitForElementClickable(DELETE_SELECTED_BUTTON_LOCATOR);
        log.info("click delete selected button");
        driver.findElement(DELETE_SELECTED_BUTTON_LOCATOR).click();
    }

    @Step("click confirm delete checkbox")
    public void clickConfirmDeleteCheckbox() {
        waitForElementClickable(CONFIRM_DELETE_INPUT_LOCATOR);
        log.info("click confirm delete checkbox");
        driver.findElement(CONFIRM_DELETE_INPUT_LOCATOR).click();
    }

    @Step("click confirm delete button")
    public void clickConfirmDeleteButton() {
        waitForElementClickable(CONFIRM_DELETE_BUTTON_LOCATOR);
        log.info("click confirm delete button");
        driver.findElement(CONFIRM_DELETE_BUTTON_LOCATOR).click();
    }
}
