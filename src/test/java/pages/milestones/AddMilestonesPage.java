package pages.milestones;

import elements.DropDown;
import elements.Input;
import elements.QuestionInput;
import elements.TextArea;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestones;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.AllureUtils;

@Log4j2
public class AddMilestonesPage extends HomePage {
    public AddMilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Step("fill Milestones form")
    public void fillForm(Milestones inputMilestones) {
        log.info("fill Milestones form");
        new Input(driver, "Name").setValue(inputMilestones.getName());
        new QuestionInput(driver, "refs").setValue(inputMilestones.getReferences());
        new DropDown(driver, "Parent").selectByVisibleText(inputMilestones.getParent());
        new TextArea(driver, "description").setValue(inputMilestones.getDescription());
        new Input(driver, "Start Date").setValue(inputMilestones.getStartDate());
        new Input(driver, "End Date").setValue(inputMilestones.getEndDate());
        AllureUtils.attachScreenshot(driver);
    }

}
