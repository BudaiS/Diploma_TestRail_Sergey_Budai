package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends HomePage {
    private final static By ADD_PROJECT = By.id("sidebar-projects-add");
    private final static String TEST_PROJECT = "//div[contains(@class,'summary-title')]//following-sibling::a[text()='%s']";

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

    public void clickTestProject(String projectName) {
        driver.findElement(By.xpath(String.format(TEST_PROJECT, projectName))).click();
    }

}
