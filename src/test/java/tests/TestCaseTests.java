package tests;


import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OverviewPage;
import pages.TestCasesPage;

public class TestCaseTests extends BaseTests {
    private final static String SECTION_NAME = "SectionDelete";
    private final static String TEST_CASES_HEADER = "Test Cases";
    private final static String EXPECTED_SECTION_COUNT = "2";
    private final static String CONFIRMATION_TEXT = "Yes, delete this section (cannot be undone)";
    Faker faker = new Faker();
    OverviewPage overviewPage;
    TestCasesPage testCasesPage;

    @BeforeClass
    public void initialise() {
        overviewPage = new OverviewPage(driver);
        testCasesPage = new TestCasesPage(driver);

    }


    @Test
    public void createAndDeleteSectionTests() {
        loginPage.waitForPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject();
        overviewPage.waitForPageLoaded();
        overviewPage.openHeaderByName(TEST_CASES_HEADER);
        testCasesPage.waitForPageLoaded();
        String EXPECTED_AFTER_DELETE_COUNT = testCasesPage.getSectionCount();
        testCasesPage.clickAddSectionButton();
        testCasesPage.setSectionNameInput(SECTION_NAME);
        testCasesPage.setDescriptionInput(faker.random().toString());
        testCasesPage.clickCompleteAddSectionButton();
        testCasesPage.clickDisplayDeletedTestCases();
        testCasesPage.waitForPageLoaded();
        Assert.assertEquals(testCasesPage.getSectionCount(), EXPECTED_SECTION_COUNT, "Сheck the number of sections");
        testCasesPage.clickDeleteSectionButton();
        testCasesPage.clickConfirmDeleteInput(CONFIRMATION_TEXT);
        testCasesPage.clickConfirmDeleteOkButton();
        testCasesPage.clickDisplayDeletedTestCases();
        testCasesPage.waitForPageLoaded();
        Assert.assertEquals(testCasesPage.getSectionCount(), EXPECTED_AFTER_DELETE_COUNT, "Сheck the number of sections");


    }

}
