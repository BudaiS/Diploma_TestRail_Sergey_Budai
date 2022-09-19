package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DashboardPage extends HomePage {
    private final static By ADD_PROJECT = By.id("sidebar-projects-add");
    private final static String TEST_PROJECT = "//div[contains(@class,'summary-title')]//following-sibling::a[text()='%s']";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @Step("check is add project button displayed")
    public boolean isAddProjectButtonDisplayed() {
        log.info("return add project button is displayed");
        return driver.findElement(ADD_PROJECT).isDisplayed();
    }

    @Step("click add project button")
    public void clickAddProjectButton() {
        log.info("click add project button");
        driver.findElement(ADD_PROJECT).click();
    }

    @Step("click {projectName}")
    public void clickTestProject(String projectName) {
        log.debug(String.format("click %s", projectName));
        driver.findElement(By.xpath(String.format(TEST_PROJECT, projectName))).click();
    }

}
