package tests;

import lombok.extern.log4j.Log4j2;
import models.Reports;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OverviewPage;
import pages.reports.AddReportPage;
import pages.reports.ReportDetailsPage;
import pages.reports.ReportsPage;
import utils.ReportsFactory;

import static constans.Constant.ReportsTestsConstants.*;

@Log4j2
public class ReportsTests extends BaseTests {
    OverviewPage overviewPage;
    ReportsPage reportsPage;
    AddReportPage addReportPage;
    ReportDetailsPage reportDetailsPage;


    @BeforeClass(alwaysRun = true)
    public void initialise() {
        overviewPage = new OverviewPage(driver);
        reportsPage = new ReportsPage(driver);
        addReportPage = new AddReportPage(driver);
        reportDetailsPage = new ReportDetailsPage(driver);
    }

    @Test(groups = {"allTest", "smoke"})
    public void createAndDeleteReportsTests() {
        loginPage.waitForLoginPageLoaded();
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.waitForPageLoaded();
        dashboardPage.clickTestProject(TEST_PROJECT_NAME);
        overviewPage.waitForPageLoaded();
        overviewPage.openHeaderByName(REPORTS_HEADER);
        reportsPage.waitForPageLoaded();
        reportsPage.clickActivitySummaryLink();
        addReportPage.waitForPageLoaded();
        Reports testReports = ReportsFactory.getMinInfoReports();
        addReportPage.fillForm(testReports);
        addReportPage.clickAddReportButton();
        reportsPage.waitForPageLoaded();
        Assert.assertTrue(reportsPage.isAccessMessageReportDisplayed(),
                "Checking for a message about the successful creation of a report");
        Assert.assertEquals(reportsPage.getAccessMessageReportText(), EXPECTED_ACCESS_REPORT_MESSAGE_TEXT,
                "check message text");
        reportsPage.clickTestReport(TEST_REPORT_NAME);
        reportDetailsPage.waitForPageLoaded();
        reportDetailsPage.getReportsInfo();
        Assert.assertEquals(reportDetailsPage.getReportsInfo(), testReports,
                "Checking the correctness of filling out the form");
        reportDetailsPage.openHeaderByName(REPORTS_HEADER);
        reportsPage.waitForPageLoaded();
        reportsPage.clickDeleteReportButton();
        reportsPage.clickConfirmDeleteOkButton();
        reportsPage.waitForPageLoaded();
        Assert.assertTrue(reportsPage.isAccessMessageReportDisplayed(),
                "Checking for a message about the successful delete of a report");
        Assert.assertEquals(reportsPage.getAccessMessageReportText(), EXPECTED_DELETE_REPORT_MESSAGE_TEXT,
                "check message text");


    }
}
