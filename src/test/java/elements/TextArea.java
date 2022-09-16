package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class TextArea extends BaseElements {
    private final static String TEXTAREA_LOCATOR = "//label[@for='%s']/following-sibling::div[contains(@class,'textarea-resizable')]/div[1]";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.debug(String.format("Scroll to element %s", label));
            scrollIntoView(inputElement);
            log.debug(String.format("Enter %s to text area %s", value, label));
            inputElement.sendKeys(value);
        }

    }
}
