package pages.milestones;

import elements.DropDown;
import elements.Input;
import elements.QuestionInput;
import elements.TextArea;
import models.Milestones;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class AddMilestonesPage extends HomePage {
    public AddMilestonesPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Milestones inputMilestones) {
        new Input(driver, "Name").setValue(inputMilestones.getName());
        new QuestionInput(driver, "refs").setValue(inputMilestones.getReferences());
        new DropDown(driver, "Parent").selectByVisibleText(inputMilestones.getParent());
        new TextArea(driver, "description").setValue(inputMilestones.getDescription());
        new Input(driver, "Start Date").setValue(inputMilestones.getStartDate());
        new Input(driver, "End Date").setValue(inputMilestones.getEndDate());
    }

}
