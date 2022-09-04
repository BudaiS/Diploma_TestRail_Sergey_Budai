package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteProjectPage extends BasePage {

    private final static By SUCCESS_MESSAGE = By.cssSelector("div.message.message-success");
    private final static By DELETE_PROJECT_BUTTON = By.xpath("//a[text()='New Project']//ancestor::td//following-sibling::td[2]");


    public CompleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(IMAGE);

    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(SUCCESS_MESSAGE).isDisplayed();
    }

    public String getSuccessMessageText() {
        return driver.findElement(SUCCESS_MESSAGE).getText();

    }

    public void clickDeleteProjectButton() {
        driver.findElement(DELETE_PROJECT_BUTTON).click();
    }


}
