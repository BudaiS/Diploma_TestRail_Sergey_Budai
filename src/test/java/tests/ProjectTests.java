package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddNewProjectPage;
import pages.CompleteProjectPage;


public class ProjectTests extends BaseTests {
    private final static String NEW_PROJECT = "New Project";
    private final static String EXPECTED_SUCCESS_MESSAGE = "Successfully added the new project.";
    private final static String EXPECTED_DELETE_SUCCESS_MESSAGE = "Successfully deleted the project.";
    private final static String CONFIRMATION_TEXT = "Yes, delete this project (cannot be undone)";
    AddNewProjectPage addNewProjectPage;
    CompleteProjectPage completeProjectPage;


    @BeforeClass
    public void initialise() {
        addNewProjectPage = new AddNewProjectPage(driver);
        completeProjectPage = new CompleteProjectPage(driver);
    }

    @Test
    public void createAndDeleteNewProjectTests() {
        loginPage.waitForPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickAddProjectButton();
        addNewProjectPage.waitForPageLoaded();
        addNewProjectPage.setName(NEW_PROJECT);
        addNewProjectPage.clickRadioButton();
        addNewProjectPage.clickAddProjectButton();
        completeProjectPage.waitForPageLoaded();
        Assert.assertTrue(completeProjectPage.isSuccessMessageDisplayed(), "Checking for a Success Message");
        Assert.assertEquals(completeProjectPage.getSuccessMessageText(), EXPECTED_SUCCESS_MESSAGE, "Message text check");
        completeProjectPage.clickDeleteProjectButton();
        completeProjectPage.clickConfirmDeleteInput(CONFIRMATION_TEXT);
        completeProjectPage.clickConfirmDeleteOkButton();
        completeProjectPage.waitForPageLoaded();
        Assert.assertTrue(completeProjectPage.isSuccessMessageDisplayed(), "Checking for a Success Message");
        Assert.assertEquals(completeProjectPage.getSuccessMessageText(), EXPECTED_DELETE_SUCCESS_MESSAGE, "Message text check");


    }
}
