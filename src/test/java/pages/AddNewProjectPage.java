package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewProjectPage extends BasePage {
    private final static By NAME_INPUT = By.cssSelector("input#name");

    public AddNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }

    public void setName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    public void clickRadioButton() {
        WebElement button = driver.findElement(By.cssSelector("input#suite_mode_single"));
        scrollIntoView(button);
        button.click();
    }

    public void clickAddProjectButton() {
        WebElement button = driver.findElement(By.id("accept"));
        scrollIntoView(button);
        button.click();
    }


}
