package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class DropDown extends BaseElements {
    private final static String BUTTON_LOCATOR = "//label[starts-with(text(),'%s')]//following-sibling::div[1]";
    private final static String OPTION_LOCATOR = "//li[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }


    public void selectByVisibleText(String visibleText) {
        if (Objects.nonNull(visibleText)) {
            WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
            log.debug(String.format("Scroll to dropdown %s", label));
            scrollIntoView(button);
            log.debug(String.format(
                    "Click %s dropdown to expand the list of options", label));
            button.click();
            WebElement option = driver.findElement(By.xpath(String.format(OPTION_LOCATOR, visibleText)));
            log.debug(String.format("Scroll to dropdown %s", visibleText));
            scrollIntoView(option);
            log.debug(String.format(
                    "Click %s option", option));
            option.click();
        }
    }


}
