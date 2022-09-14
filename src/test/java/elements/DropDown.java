package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class DropDown extends BaseElements {
    private final static String BUTTON_LOCATOR = "//label[starts-with(text(),'%s')]//following-sibling::div";
    private final static String OPTION_LOCATOR = "//li[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }


    public void selectByVisibleText(String visibleText) {
        if (Objects.nonNull(visibleText)) {
            WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
            scrollIntoView(button);
            button.click();
        }
        if (Objects.nonNull(visibleText)) {
            WebElement option = driver.findElement(By.xpath(String.format(OPTION_LOCATOR, visibleText)));
            scrollIntoView(option);
            option.click();
        }
    }


}
