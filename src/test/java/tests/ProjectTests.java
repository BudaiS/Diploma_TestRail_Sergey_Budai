package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.project.AddNewProjectPage;
import pages.project.CompleteProjectPage;

import static constans.Constant.ProjectTestsConstants.*;


public class ProjectTests extends BaseTests {


    AddNewProjectPage addNewProjectPage;
    CompleteProjectPage completeProjectPage;


    @BeforeClass
    public void initialise() {
        addNewProjectPage = new AddNewProjectPage(driver);
        completeProjectPage = new CompleteProjectPage(driver);
    }

    @Test
    public void createAndDeleteNewProjectTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickAddProjectButton();
        addNewProjectPage.waitForPageLoaded();
        addNewProjectPage.setProjectName(NEW_PROJECT);
        addNewProjectPage.clickOverallAddInAddPageButton();
        completeProjectPage.waitForPageLoaded();
        Assert.assertTrue(completeProjectPage.isAccessMessageDisplayed(),
                "Checking for a Success Message");
        Assert.assertEquals(completeProjectPage.getAccessMessageText(), EXPECTED_SUCCESS_MESSAGE,
                "Message text check");
        completeProjectPage.clickDeleteProjectButton(NEW_PROJECT);
        completeProjectPage.clickConfirmDeleteInput(CONFIRMATION_TEXT);
        completeProjectPage.clickConfirmDeleteOkButton();
        completeProjectPage.waitForPageLoaded();
        Assert.assertTrue(completeProjectPage.isAccessMessageDisplayed(),
                "Checking for a Success Message");
        Assert.assertEquals(completeProjectPage.getAccessMessageText(), EXPECTED_DELETE_SUCCESS_MESSAGE,
                "Message text check");


    }
}
