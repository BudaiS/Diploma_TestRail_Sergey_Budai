package pages.testRunsResult;

import elements.DropDown;
import elements.Input;
import elements.QuestionInput;
import elements.TextArea;
import models.TestRun;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class AddTestRunPage extends HomePage {

    public AddTestRunPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(TestRun inputTestRun) {
        new Input(driver, "Name").setValue(inputTestRun.getName());
        new QuestionInput(driver, "refs").setValue(inputTestRun.getReferences());
        new DropDown(driver, "Milestone").selectByVisibleText(inputTestRun.getMilestones());
        new DropDown(driver, "Assign To").selectByVisibleText(inputTestRun.getAssignTo());
        new TextArea(driver, "description").setValue(inputTestRun.getDescription());
    }

}
