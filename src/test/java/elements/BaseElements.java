package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static constans.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static constans.Constant.TimeoutVariable.ZERO_IMPLICIT_WAIT;
@Log4j2
public class BaseElements {
    protected WebDriver driver;
    protected String label;


    public BaseElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;


    }

    public void scrollIntoView(WebElement element) {
        log.debug(String.format("Scroll to element %s", label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(ZERO_IMPLICIT_WAIT, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return isPresent;
    }


}
