package pages.project;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

@Log4j2
public class AddNewProjectPage extends HomePage {
    private final static By NAME_INPUT = By.cssSelector("input#name");

    public AddNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("setting project name")
    public void setProjectName(String name) {
        log.info("setting project name");
        driver.findElement(NAME_INPUT).sendKeys(name);
    }


}
