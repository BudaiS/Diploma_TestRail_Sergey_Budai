package pages.reports;

import models.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class ReportDetailsPage extends HomePage {
    private final static By NAME_REPORT_LOCATOR = By.cssSelector("div#header h1");
    private final static By DESCRIPTION_REPORT_LOCATOR = By.cssSelector("div.description p");


    public ReportDetailsPage(WebDriver driver) {
        super(driver);
    }

    public Reports getReportsInfo() {
        Reports.ReportsBuilder reportsBuilder = Reports.builder();
        driver.switchTo().frame("report");
        String name = driver.findElement(NAME_REPORT_LOCATOR).getText();
        if (name != "") {
            reportsBuilder.name(name);
        }
        String description = driver.findElement(DESCRIPTION_REPORT_LOCATOR).getText();
        if (description != "") {
            reportsBuilder.description(description);
        }
        driver.switchTo().defaultContent();

        return reportsBuilder.build();


    }
}
