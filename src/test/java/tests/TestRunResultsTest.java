package tests;

import lombok.extern.log4j.Log4j2;
import models.TestPlan;
import models.TestRun;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OverviewPage;
import pages.testRunsResult.*;
import utils.TestPlanFactory;
import utils.TestRunFactory;

import static constans.Constant.TestRunsResultsTestsConstants.*;

@Log4j2
public class TestRunResultsTest extends BaseTests {

    OverviewPage overviewPage;
    TestRunsResultsPage testRunsResultsPage;
    AddTestRunPage addTestRunPage;
    TestRunDetailsPage testRunDetailsPage;
    AddTestPlanPage addTestPlanPage;
    TestPlanDetailsPage testPlanDetailsPage;

    @BeforeClass
    public void initialise() {
        overviewPage = new OverviewPage(driver);
        testRunsResultsPage = new TestRunsResultsPage(driver);
        addTestRunPage = new AddTestRunPage(driver);
        testRunDetailsPage = new TestRunDetailsPage(driver);
        addTestPlanPage = new AddTestPlanPage(driver);
        testPlanDetailsPage = new TestPlanDetailsPage(driver);
    }

    @Test(groups = {"Smoke"})
    public void createAndDeleteTestRunTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject(TEST_PROJECT_NAME);
        overviewPage.waitForPageLoaded();
        overviewPage.openHeaderByName(TEST_RUNS_RESULTS_HEADER);
        testRunsResultsPage.waitForPageLoaded();
        testRunsResultsPage.clickOverallAddInEntityPageButton(TEST_RUN_BUTTON_NAME);
        addTestRunPage.waitForPageLoaded();
        TestRun testTestRun = TestRunFactory.getFullInfoTestRun();
        addTestRunPage.fillForm(testTestRun);
        addTestRunPage.clickOverallAddInAddPageButton();
        testRunDetailsPage.waitForPageLoaded();
        Assert.assertTrue(testRunDetailsPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful creation of a test run");
        Assert.assertEquals(testRunDetailsPage.getAccessMessageText(), EXPECTED_ACCESS_TEST_RUN_MESSAGE_TEXT,
                "Message text check");
        testRunDetailsPage.clickEditButton();
        addTestRunPage.waitForPageLoaded();
        addTestRunPage.clickOverallDeleteButton();
        addTestRunPage.clickConfirmDeleteInput(CONFIRM_DELETE_TEST_RUN_TEXT);
        addTestRunPage.clickConfirmDeleteOkButton();
        testRunsResultsPage.waitForPageLoaded();
        Assert.assertTrue(testRunsResultsPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful delete of a test run");
        Assert.assertEquals(testRunsResultsPage.getAccessMessageText(), EXPECTED_DELETE_TEST_RUN_MESSAGE_TEXT,
                "Message text check");


    }

    @Test(groups = {"Smoke"})
    public void createAndDeleteTestPlanTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject(TEST_PROJECT_NAME);
        overviewPage.openHeaderByName(TEST_RUNS_RESULTS_HEADER);
        testRunsResultsPage.waitForPageLoaded();
        testRunsResultsPage.clickOverallAddInEntityPageButton(TEST_PLAN_BUTTON_NAME);
        addTestPlanPage.waitForPageLoaded();
        TestPlan testTestPlan = TestPlanFactory.getFullInfoTestPlan();
        addTestPlanPage.fillForm(testTestPlan);
        addTestPlanPage.clickOverallAddInAddPageButton();
        testPlanDetailsPage.waitForPageLoaded();
        Assert.assertTrue(testPlanDetailsPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful creation of a test plan");
        Assert.assertEquals(testPlanDetailsPage.getAccessMessageText(), EXPECTED_ACCESS_TEST_PLAN_MESSAGE_TEXT,
                "Message text check");
        testPlanDetailsPage.clickEditButton();
        addTestPlanPage.waitForPageLoaded();
        addTestPlanPage.clickOverallDeleteButton();
        addTestPlanPage.clickConfirmDeleteInput(CONFIRM_DELETE_TEST_PLAN_TEXT);
        addTestPlanPage.clickConfirmDeleteOkButton();
        testRunsResultsPage.waitForPageLoaded();
        testRunsResultsPage.waitForTextToBe(EXPECTED_DELETE_TEST_PLAN_MESSAGE_TEXT);
        Assert.assertTrue(testRunsResultsPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful delete of a test plan");
        Assert.assertEquals(testRunsResultsPage.getAccessMessageText(), EXPECTED_DELETE_TEST_PLAN_MESSAGE_TEXT,
                "Message text check");


    }
}
