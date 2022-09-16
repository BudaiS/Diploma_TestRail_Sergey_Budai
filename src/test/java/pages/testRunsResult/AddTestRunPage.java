package pages.testRunsResult;

import elements.DropDown;
import elements.Input;
import elements.QuestionInput;
import elements.TextArea;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestRun;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.AllureUtils;

@Log4j2
public class AddTestRunPage extends HomePage {

    public AddTestRunPage(WebDriver driver) {
        super(driver);
    }

    @Step("fill TestRun form")
    @Attachment(value = "screenshot", type = "image/png")
    public void fillForm(TestRun inputTestRun) {
        log.info("fill TestRun form");
        new Input(driver, "Name").setValue(inputTestRun.getName());
        new QuestionInput(driver, "refs").setValue(inputTestRun.getReferences());
        new DropDown(driver, "Milestone").selectByVisibleText(inputTestRun.getMilestones());
        new DropDown(driver, "Assign To").selectByVisibleText(inputTestRun.getAssignTo());
        new TextArea(driver, "description").setValue(inputTestRun.getDescription());
        AllureUtils.attachScreenshot(driver);
    }

}
