package tests;


import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OverviewPage;
import pages.testCase.AddTestCasePage;
import pages.testCase.TestCaseDetailsPage;
import pages.testCase.TestCasesPage;
import utils.TestCaseFactory;

import static constans.Constant.TestCaseTestsConstants.*;

@Log4j2
public class TestCaseTests extends BaseTests {


    Faker faker = new Faker();
    OverviewPage overviewPage;
    TestCasesPage testCasesPage;
    AddTestCasePage addTestCasePage;
    TestCaseDetailsPage testCaseDetailsPage;

    @BeforeClass
    public void initialise() {
        overviewPage = new OverviewPage(driver);
        testCasesPage = new TestCasesPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        testCaseDetailsPage = new TestCaseDetailsPage(driver);

    }


    @Test(groups = {"Smoke"})
    public void createAndDeleteSectionTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject(TEST_PROJECT_NAME);
        overviewPage.waitForPageLoaded();
        overviewPage.openHeaderByName(TEST_CASES_HEADER);
        testCasesPage.waitForPageLoaded();
        String EXPECTED_AFTER_DELETE_COUNT = testCasesPage.getSectionCount();
        testCasesPage.clickAddSectionButton();
        testCasesPage.setSectionNameInput(DELETE_SECTION_NAME);
        testCasesPage.setDescriptionInput(faker.random().toString());
        testCasesPage.clickCompleteAddSectionButton();
        testCasesPage.clickDisplayDeletedTestCases();
        testCasesPage.waitForPageLoaded();
        Assert.assertEquals(testCasesPage.getSectionCount(), EXPECTED_SECTION_COUNT,
                "Сheck the number of sections");
        testCasesPage.clickDeleteSectionButton(DELETE_SECTION_NAME);
        testCasesPage.isWaitConfirmationMessagesDisplayed();
        testCasesPage.clickConfirmDeleteInput(CONFIRMATION_TEST_CASE_TEXT);
        testCasesPage.clickConfirmDeleteOkButton();
        testCasesPage.clickDisplayDeletedTestCases();
        testCasesPage.waitForPageLoaded();
        Assert.assertEquals(testCasesPage.getSectionCount(), EXPECTED_AFTER_DELETE_COUNT,
                "Сheck the number of sections");


    }

    @Test(groups = {"Smoke"})
    public void createAndDeleteTestCasesTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject(TEST_PROJECT_NAME);
        overviewPage.waitForPageLoaded();
        overviewPage.openHeaderByName(TEST_CASES_HEADER);
        testCasesPage.waitForPageLoaded();
        testCasesPage.clickOverallAddInEntityPageButton(TEST_CASE_BUTTON_NAME);
        addTestCasePage.waitForPageLoaded();
        TestCase testTestCase = TestCaseFactory.getFullInfoTestCase();
        addTestCasePage.fillForm(testTestCase);
        addTestCasePage.clickOverallAddInAddPageButton();
        testCaseDetailsPage.waitForPageLoaded();
        testCaseDetailsPage.getTestCaseInfo();
        Assert.assertEquals(testCaseDetailsPage.getTestCaseInfo(), testTestCase,
                "Checking the correctness of filling out the form");
        Assert.assertTrue(testCaseDetailsPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful creation of a test case");
        Assert.assertEquals(testCaseDetailsPage.getAccessMessageText(), ACCESS_MESSAGE_TEXT,
                "Verify the text of the message");
        testCaseDetailsPage.clickEditButton();
        addTestCasePage.waitForPageLoaded();
        addTestCasePage.clickOverallDeleteButton();
        addTestCasePage.clickDeletedPermanentlyButton();
        addTestCasePage.clickConfirmDeletePermanentlyButton();
        testCaseDetailsPage.waitForPageLoaded();
        Assert.assertTrue(testCaseDetailsPage.isAccessMessageDisplayed(),
                "Checking for a message about the successful deletion of the test case");
        Assert.assertEquals(testCaseDetailsPage.getAccessMessageText(), ACCESS_DELETE_TEST_CASE_MESSAGE_TEXT,
                "Verify the text of the message");


    }

}
