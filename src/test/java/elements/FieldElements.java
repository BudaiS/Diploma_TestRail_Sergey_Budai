package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class FieldElements extends BaseElements {

    private final static String VISIBLE_TEXT_LOCATOR = "//span[@class='field-title-inner'][text()='%s']//parent::div//following-sibling::div[@class='field-content'][1]//div//p";

    public FieldElements(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        By textElementLocator = By.xpath(
                String.format(VISIBLE_TEXT_LOCATOR, label));
        if (!isElementPresent(textElementLocator)) {
            return null;
        }
        WebElement textElement = driver.findElement(textElementLocator);
        scrollIntoView(textElement);
        return textElement.getText();
    }

}
