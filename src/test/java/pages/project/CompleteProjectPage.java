package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class CompleteProjectPage extends HomePage {

    private final static By SUCCESS_MESSAGE = By.cssSelector("div.message.message-success");
    private final static String DELETE_PROJECT_BUTTON = "//a[text()='%s']//ancestor::td//following-sibling::td[2]";


    public CompleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }


    public void clickDeleteProjectButton(String newProject) {
        driver.findElement(By.xpath(String.format(DELETE_PROJECT_BUTTON, newProject))).click();
    }

    public boolean isAccessMessageDisplayed() {
        return driver.findElement(SUCCESS_MESSAGE).isDisplayed();
    }

    public String getAccessMessageText() {
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }


}
