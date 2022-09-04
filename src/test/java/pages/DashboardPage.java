package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final static By ADD_PROJECT = By.id("sidebar-projects-add");
    private final static By TEST_PROJECT = By.xpath("//div[contains(@class,'summary-title')]//following-sibling::a[text()='TestProject']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }

    public boolean isAddProjectButtonDisplayed() {
        return driver.findElement(ADD_PROJECT).isDisplayed();
    }

    public void clickAddProjectButton() {
        driver.findElement(ADD_PROJECT).click();
    }

    public void clickTestProject() {
        driver.findElement(TEST_PROJECT).click();
    }

}
