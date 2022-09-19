package pages.reports;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
@Log4j2
public class ReportsPage extends HomePage {
    private final static By ACTIVITY_SUMMARY_LINK_LOCATOR = By.xpath("//a[contains(text(),'Activity Summary')]");
    private final static String REPORT_NAME_LINK = "//a[text()='%s']";
    private final static By ACCESS_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'message-success')][not(contains(@class,'successPanel'))]");
    private final static By DELETE_REPORT_BUtTON_LOCATOR = By.cssSelector("div.icon-small-delete");
    public ReportsPage(WebDriver driver) {
        super(driver);
    }
    @Step("click Activity Summary link")
    public void clickActivitySummaryLink() {
        log.info("click Activity Summary link");
        driver.findElement(ACTIVITY_SUMMARY_LINK_LOCATOR).click();
    }
    @Step("click {reportName} link")
    public void clickTestReport(String reportName) {
        waitForElementClickable(By.xpath(String.format(REPORT_NAME_LINK, reportName)));
        log.info(String.format("Click %s", reportName));
        driver.findElement(By.xpath
                (String.format(REPORT_NAME_LINK, reportName))).click();
    }

    @Step("check message is displayed")
    public boolean isAccessMessageReportDisplayed() {
        log.info("return message is displayed");
        return driver.findElement(ACCESS_MESSAGE_LOCATOR).isDisplayed();
    }

    @Step("check message text")
    public String getAccessMessageReportText() {
        log.info("return message text");
        return driver.findElement(ACCESS_MESSAGE_LOCATOR).getText();
    }
    @Step("click delete report button")
    public void clickDeleteReportButton() {
        waitForElementClickable(DELETE_REPORT_BUtTON_LOCATOR);
        driver.findElement(DELETE_REPORT_BUtTON_LOCATOR).click();
    }
}
