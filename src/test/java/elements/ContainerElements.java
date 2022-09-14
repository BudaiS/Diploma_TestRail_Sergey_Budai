package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContainerElements extends BaseElements {
    private final static String VISIBLE_TEXT_LOCATOR = "//label[@class='io-label'][text()='%s']//ancestor::td";

    public ContainerElements(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        String innerText = driver.findElement(By.xpath(String.format(VISIBLE_TEXT_LOCATOR, label))).getAttribute("innerText");
        String text = innerText.substring(innerText.lastIndexOf("\n") + 1);
        return text;


    }

}
