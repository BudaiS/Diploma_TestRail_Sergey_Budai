package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static constans.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static constans.Constant.TimeoutVariable.ZERO_IMPLICIT_WAIT;

public class BaseElements {
    protected WebDriver driver;
    protected String label;


    public BaseElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;


    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(ZERO_IMPLICIT_WAIT, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return isPresent;
    }


}
