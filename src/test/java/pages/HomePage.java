package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public abstract class HomePage extends BasePage {
    private final static String HEADER_MENU_ITEM = "//ul[@class='header-menu']//descendant::a[text()='%s']";
    private final static String CONFIRM_DELETE_INPUT = "//strong[text()='%s']";
    private final static By CONFIRM_DELETE_OK_BUTTON = By.xpath("//div[@id='deleteDialog']//following-sibling::a[contains(@class,'button-ok')]");
    private final static By CONFIRM_DELETE = By.xpath("//strong[contains(text(),'Yes, delete this')]");
    protected Actions actions = new Actions(driver);


    public HomePage(WebDriver driver) {

        super(driver);

    }


    public void openHeaderByName(String headerName) {
        driver.findElement(By.xpath
                (String.format(HEADER_MENU_ITEM, headerName))).click();

    }


    public void clickConfirmDeleteOkButton() {
        waitForElementClickable(CONFIRM_DELETE_OK_BUTTON);
        driver.findElement(CONFIRM_DELETE_OK_BUTTON).click();
    }

    public void clickConfirmDeleteInput(String confirmationText) {
        waitForElementClickable(CONFIRM_DELETE);
        driver.findElement(By.xpath
                (String.format(CONFIRM_DELETE_INPUT, confirmationText))).click();

    }


}



