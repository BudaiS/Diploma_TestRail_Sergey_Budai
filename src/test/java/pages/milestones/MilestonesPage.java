package pages.milestones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class MilestonesPage extends HomePage {

    private final static By EXPAND_BUTTON_LOCATOR = By.cssSelector("a.expand div");
    private final static By ENTITY_MILESTONES_INPUT_LOCATOR = By.xpath("//tr[@class='odd hoverSensitive']//following-sibling::input");
    private final static By DELETE_SELECTED_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'button-delete')]");
    private final static By CONFIRM_DELETE_INPUT_LOCATOR = By.cssSelector("input#confirm-check");
    private final static By CONFIRM_DELETE_BUTTON_LOCATOR = By.xpath("//a[contains(@class,'button-black')]");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    public void clickExpandButton() {
        waitForElementClickable(EXPAND_BUTTON_LOCATOR);
        driver.findElement(EXPAND_BUTTON_LOCATOR).click();
    }

    public void clickEntityMilestonesInput() {
        waitForElementClickable(ENTITY_MILESTONES_INPUT_LOCATOR);
        driver.findElement(ENTITY_MILESTONES_INPUT_LOCATOR).click();
    }

    public void clickDeleteSelectedButton() {
        waitForElementClickable(DELETE_SELECTED_BUTTON_LOCATOR);
        driver.findElement(DELETE_SELECTED_BUTTON_LOCATOR).click();
    }

    public void clickConfirmDeleteInput() {
        waitForElementClickable(CONFIRM_DELETE_INPUT_LOCATOR);
        driver.findElement(CONFIRM_DELETE_INPUT_LOCATOR).click();
    }

    public void clickConfirmDeleteButton() {
        waitForElementClickable(CONFIRM_DELETE_BUTTON_LOCATOR);
        driver.findElement(CONFIRM_DELETE_BUTTON_LOCATOR).click();
    }
}
