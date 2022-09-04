package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestCasesPage extends HomePage {
    private final static By DELETE_SECTION_BUTTON = By.xpath("//span[text()='SectionDelete']//following-sibling::a//following-sibling::div[contains(@class,'icon-small-delete')]");
    private final static By ADD_SECTION_BUTTON = By.id("addSection");
    private final static By SECTION_NAME_INPUT = By.id("editSectionName");
    private final static By DESCRIPTION_INPUT = By.id("editSectionDescription_display");
    private final static By COMPLETE_ADD_SECTION_BUTTON = By.id("editSectionSubmit");
    private final static By GROUPS_SECTION_LOCATOR = By.cssSelector("div#groups");
    private final static By DISPLAY_DELETED_TEST_CASES = By.xpath("//span[text()='Display Deleted Test Cases']");
    private final static By EDIT_SECTION_BUTTON = By.xpath("//span[text()='SectionDelete']//following-sibling::a//div[contains(@class,'icon-small-edit')]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }

    public void clickAddSectionButton() {
        driver.findElement(ADD_SECTION_BUTTON).click();
    }

    public void setSectionNameInput(String sectionName) {
        waitForElementClickable(SECTION_NAME_INPUT);
        driver.findElement(SECTION_NAME_INPUT).click();
        driver.findElement(SECTION_NAME_INPUT).sendKeys(sectionName);
    }

    public void setDescriptionInput(String description) {
        driver.findElement(DESCRIPTION_INPUT).sendKeys(description);
    }

    public void clickCompleteAddSectionButton() {
        waitForElementClickable(COMPLETE_ADD_SECTION_BUTTON);
        driver.findElement(COMPLETE_ADD_SECTION_BUTTON).click();
    }

    public String getSectionCount() {
        return driver.findElement(GROUPS_SECTION_LOCATOR).getAttribute("childElementCount");

    }

    public void clickDisplayDeletedTestCases() {
        waitForElementClickable(DISPLAY_DELETED_TEST_CASES);
        driver.findElement(DISPLAY_DELETED_TEST_CASES).click();
    }

    public void clickDeleteSectionButton() {
        waitForElementDisplayed(EDIT_SECTION_BUTTON);
        actions.moveToElement(driver.findElement(EDIT_SECTION_BUTTON))
                .moveToElement(driver.findElement(DELETE_SECTION_BUTTON))
                .click().build().perform();
    }


}
