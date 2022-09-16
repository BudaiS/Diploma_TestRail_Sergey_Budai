package pages.testRunsResult;

import elements.DropDown;
import elements.TextArea;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utils.AllureUtils;

import java.util.Objects;

@Log4j2
public class AddTestPlanPage extends HomePage {
    private final static By NAME_INPUT_LOCATOR = By.xpath("//label[@for='name'][starts-with(text(),'Name')]//following-sibling::input");

    public AddTestPlanPage(WebDriver driver) {
        super(driver);
    }

    @Step("fill TestPlan form")
    @Attachment(value = "screenshot", type = "image/png")
    public void fillForm(TestPlan inputTestPlan) {
        log.info("fill TestPlan form");
        this.nameSetValue(inputTestPlan.getName());
        new DropDown(driver, "Milestone").selectByVisibleText(inputTestPlan.getMilestone());
        new TextArea(driver, "description").setValue(inputTestPlan.getDescription());
        AllureUtils.attachScreenshot(driver);
    }

    public void nameSetValue(String value) {
        WebElement inputElement = driver.findElement(NAME_INPUT_LOCATOR);
        if (Objects.nonNull(value)) {
            log.debug(String.format("Scroll to element %s", inputElement));
            scrollIntoView(inputElement);
            log.debug(String.format("Enter %s to %s input", value, inputElement));
            inputElement.sendKeys(value);
        }


    }

}
