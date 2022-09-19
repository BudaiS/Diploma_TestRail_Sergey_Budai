package pages.reports;

import elements.Input;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utils.AllureUtils;

import java.util.Objects;

@Log4j2
public class AddReportPage extends HomePage {
    private final static By ADD_REPORT_BUTTON_LOCATOR = By.cssSelector("button#submit");
    private final static By DESCRIPTION_AREA_LOCATOR = By.xpath("//label[@for='description']/following-sibling::div[contains(@class,'textarea-resizable')]//textarea");
    private final static By NAME_INPUT_LOCATOR = By.cssSelector("input#name");
    public AddReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("fill Reports form")
    @Attachment(value = "screenshot", type = "image/png")
    public void fillForm(Reports inputReports) {
        log.info("fill Reports form");
        this.nameSetValue(inputReports.getName());
        this.descriptionSetValue(inputReports.getDescription());
        AllureUtils.attachScreenshot(driver);
    }

    public void descriptionSetValue(String value) {
        WebElement inputElement = driver.findElement(DESCRIPTION_AREA_LOCATOR);
        if (Objects.nonNull(value)) {
            log.debug(String.format("Scroll to element %s", inputElement));
            scrollIntoView(inputElement);
            log.debug(String.format("Enter %s to %s input", value, inputElement));
            inputElement.sendKeys(value);
        }
    }
    @Step("click add report button")
    public void clickAddReportButton() {
        WebElement button = driver.findElement(ADD_REPORT_BUTTON_LOCATOR);
        log.debug(String.format("scroll to %s", button));
        scrollIntoView(button);
        log.info("click button");
        button.click();
    }

    public void nameSetValue(String value) {
        WebElement inputElement = driver.findElement(NAME_INPUT_LOCATOR);
        if (Objects.nonNull(value)) {
            log.debug(String.format("Scroll to element %s", inputElement));
            scrollIntoView(inputElement);
            inputElement.clear();
            log.debug(String.format("Enter %s to %s input", value, inputElement));
            inputElement.sendKeys(value);
        }
    }
}
