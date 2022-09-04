package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public abstract class HomePage extends BasePage {
    private final static String HEADER_MENU_ITEM = "//ul[@class='header-menu']//descendant::a[text()='%s']";
    Actions actions = new Actions(driver);


    public HomePage(WebDriver driver) {

        super(driver);

    }


    public void openHeaderByName(String headerName) {
        driver.findElement(By.xpath
                (String.format(HEADER_MENU_ITEM, headerName))).click();

    }


}



