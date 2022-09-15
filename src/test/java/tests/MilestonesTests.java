package tests;

import models.Milestones;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OverviewPage;
import pages.milestones.AddMilestonesPage;
import pages.milestones.MilestonesPage;
import utils.MilestonesFactory;

import static constans.Constant.MilestonesTestsConstants.*;


public class MilestonesTests extends BaseTests {

    OverviewPage overviewPage;
    MilestonesPage milestonesPage;
    AddMilestonesPage addMilestonesPage;

    @BeforeClass
    public void initialise() {
        overviewPage = new OverviewPage(driver);
        milestonesPage = new MilestonesPage(driver);
        addMilestonesPage = new AddMilestonesPage(driver);

    }

    @Test
    public void createAndeDeleteMilestones() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject(TEST_PROJECT_NAME);
        overviewPage.waitForPageLoaded();
        overviewPage.openHeaderByName(MILESTONES_HEADER);
        milestonesPage.waitForPageLoaded();
        milestonesPage.clickOverallAddInEntityPageButton(MILESTONE_BUTTON_NAME);
        addMilestonesPage.waitForPageLoaded();
        Milestones testMilestones = MilestonesFactory.getFullInfoMilestones();
        addMilestonesPage.fillForm(testMilestones);
        addMilestonesPage.clickOverallAddInAddPageButton();
        milestonesPage.waitForPageLoaded();
        Assert.assertTrue(milestonesPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful creation of a milestone");
        Assert.assertEquals(milestonesPage.getAccessMessageText(), EXPECTED_ACCESS_MESSAGE_TEXT,
                "Message text check");
        milestonesPage.clickExpandButton();
        milestonesPage.clickEntityMilestonesInput();
        milestonesPage.clickDeleteSelectedButton();
        milestonesPage.clickConfirmDeleteInput();
        milestonesPage.clickConfirmDeleteButton();
        milestonesPage.waitForPageLoaded();
        Assert.assertTrue(milestonesPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful delete of a milestone");
        /*Assert.assertEquals(milestonesPage.getAccessMessageText(), EXPECTED_DELETE_MESSAGE_TEXT,
                "Message text check");*/


    }
}
