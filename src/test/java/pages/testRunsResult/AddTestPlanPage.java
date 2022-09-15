package pages.testRunsResult;

import elements.DropDown;
import elements.TextArea;
import models.TestPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.Objects;

public class AddTestPlanPage extends HomePage {
    private final static By NAME_INPUT_LOCATOR = By.xpath("//label[@for='name'][starts-with(text(),'Name')]//following-sibling::input");

    public AddTestPlanPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(TestPlan inputTestPlan) {
        new AddTestPlanPage(driver).nameSetValue(inputTestPlan.getName());
        new DropDown(driver, "Milestone").selectByVisibleText(inputTestPlan.getMilestone());
        new TextArea(driver, "description").setValue(inputTestPlan.getDescription());

    }

    public void nameSetValue(String value) {
        WebElement inputElement = driver.findElement(NAME_INPUT_LOCATOR);
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }


    }

}
