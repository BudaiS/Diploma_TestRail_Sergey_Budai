package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class AddNewProjectPage extends HomePage {
    private final static By NAME_INPUT = By.cssSelector("input#name");

    public AddNewProjectPage(WebDriver driver) {
        super(driver);
    }


    public void setProjectName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }


}
