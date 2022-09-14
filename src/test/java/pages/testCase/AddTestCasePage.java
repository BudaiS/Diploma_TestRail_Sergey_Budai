package pages.testCase;

import elements.DropDown;
import elements.Input;
import elements.QuestionInput;
import elements.TextArea;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class AddTestCasePage extends HomePage {
    private final static By DELETED_PERMANENTLY_BUTTON = By.xpath("//input[@id='deletionCaseID']//following-sibling::a[contains(text(),'Delete Permanently')]");
    private final static By ADD_TEST_CASE_BUTTON = By.xpath("//button[@id='accept']");
    private final static By DELETE_TEST_CASE_BUTTON = By.xpath("//span[contains(@class,'button-delete')]");
    private final static By CONFIRM_DELETE_PERMANENTLY_BUTTON = By.xpath("//input[@id='isCasesBulkDeletion']//following-sibling::a[contains(text(),'Delete Permanently')]");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);
    }

    public void clickAddTestCaseButton() {
        driver.findElement(ADD_TEST_CASE_BUTTON).click();
    }

    public void fillForm(TestCase inputTestCase) {
        new Input(driver, "Title").setValue(inputTestCase.getTitle());
        new DropDown(driver, "Section").selectByVisibleText(inputTestCase.getSection());
        new DropDown(driver, "Type").selectByVisibleText(inputTestCase.getType().getName());
        new DropDown(driver, "Priority").selectByVisibleText(inputTestCase.getPriority().getName());
        new Input(driver, "Estimate").setValue(inputTestCase.getEstimate());
        new QuestionInput(driver, "refs").setValue(inputTestCase.getReferences());
        new DropDown(driver, "Automation Type").selectByVisibleText(inputTestCase.getAutomationType().getName());
        new TextArea(driver, "custom_preconds").setValue(inputTestCase.getPreconditions());
        new TextArea(driver, "custom_steps").setValue(inputTestCase.getSteps());
        new TextArea(driver, "custom_expected").setValue(inputTestCase.getExpectedResult());

    }

    public void clickDeleteTestCaseButton() {
        waitForElementClickable(DELETE_TEST_CASE_BUTTON);
        driver.findElement(DELETE_TEST_CASE_BUTTON).click();
    }

    public void clickDeletedPermanentlyButton() {
        waitForElementClickable(DELETED_PERMANENTLY_BUTTON);
        driver.findElement(DELETED_PERMANENTLY_BUTTON).click();
    }

    public void clickConfirmDeletePermanentlyButton() {
        waitForElementClickable(CONFIRM_DELETE_PERMANENTLY_BUTTON);
        driver.findElement(CONFIRM_DELETE_PERMANENTLY_BUTTON).click();
    }


}
