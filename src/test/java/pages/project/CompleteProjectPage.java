package pages.project;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

@Log4j2
public class CompleteProjectPage extends HomePage {

    private final static String DELETE_PROJECT_BUTTON = "//a[text()='%s']//ancestor::td//following-sibling::td[2]";


    public CompleteProjectPage(WebDriver driver) {
        super(driver);
    }


    @Step("click delete project button")
    public void clickDeleteProjectButton(String newProject) {
        log.debug(String.format("delete %s ", newProject));
        driver.findElement(By.xpath(String.format(DELETE_PROJECT_BUTTON, newProject))).click();
    }


}
