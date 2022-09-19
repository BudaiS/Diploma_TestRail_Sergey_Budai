package pages.testCase;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

@Log4j2
public class TestCasesPage extends HomePage {
    private final static String DELETE_SECTION_BUTTON = "//span[text()='%s']//following-sibling::a//following-sibling::div[contains(@class,'icon-small-delete')]";
    private final static By ADD_SECTION_BUTTON = By.id("addSection");
    private final static By SECTION_NAME_INPUT = By.id("editSectionName");
    private final static By DESCRIPTION_INPUT = By.id("editSectionDescription_display");
    private final static By COMPLETE_ADD_SECTION_BUTTON = By.id("editSectionSubmit");
    private final static By GROUPS_SECTION_LOCATOR = By.cssSelector("div#groups");
    private final static By DISPLAY_DELETED_TEST_CASES = By.xpath("//span[text()='Display Deleted Test Cases']");
    private final static String EDIT_SECTION_BUTTON = "//span[text()='%s']//following-sibling::a//div[contains(@class,'icon-small-edit')]";
    private final static By CONFIRMATION_MESSAGES = By.xpath("//div[@class='dialog-body']//following-sibling::p[contains(@class,'text-delete')][contains(text(),'You will irrevocably delete at least ')]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Step("click add section button")
    public void clickAddSectionButton() {
        log.info("click add section button");
        driver.findElement(ADD_SECTION_BUTTON).click();
    }

    @Step("setting section name")
    public void setSectionNameInput(String sectionName) {
        waitForElementClickable(SECTION_NAME_INPUT);
        log.info("click section name input");
        driver.findElement(SECTION_NAME_INPUT).click();
        log.debug(String.format("enter %s in section name input", sectionName));
        driver.findElement(SECTION_NAME_INPUT).sendKeys(sectionName);
    }

    @Step("setting description")
    public void setDescriptionInput(String description) {
        log.debug(String.format("enter %s in description input", description));
        driver.findElement(DESCRIPTION_INPUT).sendKeys(description);
    }

    @Step("click complete add section button")
    public void clickCompleteAddSectionButton() {
        waitForElementClickable(COMPLETE_ADD_SECTION_BUTTON);
        log.info("click add section button");
        driver.findElement(COMPLETE_ADD_SECTION_BUTTON).click();
    }

    @Step("return section count")
    public String getSectionCount() {
        log.info("return section count");
        return driver.findElement(GROUPS_SECTION_LOCATOR).getAttribute("childElementCount");

    }

    @Step("click display deleted test case")
    public void clickDisplayDeletedTestCases() {
        waitForElementClickable(DISPLAY_DELETED_TEST_CASES);
        log.info("click display deleted test case");
        driver.findElement(DISPLAY_DELETED_TEST_CASES).click();
    }

    @Step("click delete {sectionName} button")
    public void clickDeleteSectionButton(String sectionName) {
        log.info("wait for element %s is displayed");
        waitForElementDisplayed(By.xpath(String.format(EDIT_SECTION_BUTTON, sectionName)));
        log.debug(String.format("move to element %s", sectionName));
        actions.moveToElement(driver.findElement(By.xpath(String.format(EDIT_SECTION_BUTTON, sectionName))))
                .moveToElement(driver.findElement(By.xpath(String.format(DELETE_SECTION_BUTTON, sectionName))))
                .click().build().perform();
    }

    @Step("wait is confirmation message displayed")
    public void isWaitConfirmationMessagesDisplayed() {
        log.info("wait is confirmation message displayed");
        waitForElementDisplayed(CONFIRMATION_MESSAGES);
    }


}
