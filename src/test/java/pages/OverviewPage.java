package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends HomePage {
    private final static By ADD_MILESTONE = By.id("navigation-overview-addmilestones");
    private final static By ADD_TEST_CASES_BUTTON = By.id("sidebar-cases-add");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }

    public boolean isAddMilestoneButtonDisplayed() {
        return driver.findElement(ADD_MILESTONE).isDisplayed();
    }

    public void clickAddTEstCasesButton() {
        driver.findElement(ADD_TEST_CASES_BUTTON).click();
    }
}
