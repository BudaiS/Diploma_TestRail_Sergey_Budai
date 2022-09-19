package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Input extends BaseElements {

    private final static String INPUT_LOCATOR = "//label[contains(text(),'%s')]/following-sibling::input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug(String.format("Enter %s to %s input", value, label));
            inputElement.sendKeys(value);
        }


    }
}
