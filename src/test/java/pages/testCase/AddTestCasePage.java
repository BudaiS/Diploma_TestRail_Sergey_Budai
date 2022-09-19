package pages.testCase;

import elements.DropDown;
import elements.Input;
import elements.QuestionInput;
import elements.TextArea;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.AllureUtils;

@Log4j2
public class AddTestCasePage extends HomePage {
    private final static By DELETED_PERMANENTLY_BUTTON = By.xpath("//input[@id='deletionCaseID']//following-sibling::a[contains(text(),'Delete Permanently')]");


    private final static By CONFIRM_DELETE_PERMANENTLY_BUTTON = By.xpath("//input[@id='isCasesBulkDeletion']//following-sibling::a[contains(text(),'Delete Permanently')]");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("fill TestCase form")
    public void fillForm(TestCase inputTestCase) {
        log.info("fill TestCase form");
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
        AllureUtils.attachScreenshot(driver);
    }

    @Step("click delete permanently button")
    public void clickDeletedPermanentlyButton() {
        waitForElementClickable(DELETED_PERMANENTLY_BUTTON);
        log.info("click delete permanently button");
        driver.findElement(DELETED_PERMANENTLY_BUTTON).click();
    }

    @Step("click confirm delete permanently button")
    public void clickConfirmDeletePermanentlyButton() {
        waitForElementClickable(CONFIRM_DELETE_PERMANENTLY_BUTTON);
        log.info("click confirm delete permanently button");
        driver.findElement(CONFIRM_DELETE_PERMANENTLY_BUTTON).click();
    }


}
