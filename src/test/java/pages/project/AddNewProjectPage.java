package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class AddNewProjectPage extends BasePage {
    private final static By NAME_INPUT = By.cssSelector("input#name");
    private final static By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");

    public AddNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }

    public void setProjectName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }


    public void clickAddProjectButton() {
        WebElement button = driver.findElement(ADD_PROJECT_BUTTON_LOCATOR);
        scrollIntoView(button);
        button.click();
    }


}
