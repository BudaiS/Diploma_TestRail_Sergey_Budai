package pages.testCase;

import elements.ContainerElements;
import elements.FieldElements;
import enums.AutomationType;
import enums.Priority;
import enums.Type;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class TestCaseDetailsPage extends HomePage {


    private final static By TITLE_NAME = By.xpath("//div[contains(@class,'content-header-title')]");
    private final static By SECTION_NAME = By.cssSelector(".content-breadcrumb a");


    public TestCaseDetailsPage(WebDriver driver) {
        super(driver);
    }

    public TestCase getTestCaseInfo() {
        TestCase.TestCaseBuilder testCaseBuilder = TestCase.builder();
        String title = driver.findElement(TITLE_NAME).getText().trim();
        if (title != "") {
            testCaseBuilder.title(title);
        }
        String section = driver.findElement(SECTION_NAME).getText();
        if (section != "") {
            testCaseBuilder.section(section);
        }
        String type = new ContainerElements(driver, "Type").getText();
        if (type != "") {
            testCaseBuilder.type(Type.fromString(type));
        }
        String priority = new ContainerElements(driver, "Priority").getText();
        if (priority != "") {
            testCaseBuilder.priority(Priority.fromString(priority));
        }
        String estimate = new ContainerElements(driver, "Estimate").getText().substring(0, 1);
        if (estimate != "") {
            testCaseBuilder.estimate(estimate);
        }
        String references = new ContainerElements(driver, "References").getText();
        if (references != "") {
            testCaseBuilder.references(references);
        }
        String automationType = new ContainerElements(driver, "Automation Type").getText();
        if (automationType != "") {
            testCaseBuilder.automationType(AutomationType.fromString(automationType));
        }
        String preconditions = new FieldElements(driver, "Preconditions").getText();
        if (preconditions != "") {
            testCaseBuilder.preconditions(preconditions);
        }
        String steps = new FieldElements(driver, "Steps").getText();
        if (steps != "") {
            testCaseBuilder.steps(steps);
        }
        String expectedResult = new FieldElements(driver, "Expected Result").getText();
        if (expectedResult != "") {
            testCaseBuilder.expectedResult(expectedResult);
        }

        return testCaseBuilder.build();
    }


}
