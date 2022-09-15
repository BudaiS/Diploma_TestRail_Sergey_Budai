package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public abstract class HomePage extends BasePage {
    private final static String HEADER_MENU_ITEM = "//ul[@class='header-menu']//descendant::a[text()='%s']";
    private final static String CONFIRM_DELETE_INPUT = "//strong[text()='%s']";
    private final static By CONFIRM_DELETE_OK_BUTTON = By.xpath("//div[@id='deleteDialog']//following-sibling::a[contains(@class,'button-ok')]");
    private final static By CONFIRM_DELETE = By.xpath("//strong[contains(text(),'Yes, delete this')]");
    private final static By ACCESS_MESSAGE = By.cssSelector(".message.message-success");
    private final static By EDIT_BUTTON_LOCATOR = By.xpath("//a[contains(@class,'button-edit')]");
    private final static By DELETE_OVERALL_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'button-delete')]");
    private final static By ADD_OVERALL_IN_ADD_PAGE_BUTTON = By.id("accept");
    private final static String ADD_OVERALL_IN_ENTITY_PAGE_BUTTON_LOCATOR = "//span[text()='%s']";
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

    public boolean isAccessMessageDisplayed() {
        return driver.findElement(ACCESS_MESSAGE).isDisplayed();
    }

    public String getAccessMessageText() {
        return driver.findElement(ACCESS_MESSAGE).getText();
    }

    public void clickEditButton() {
        waitForElementClickable(EDIT_BUTTON_LOCATOR);
        driver.findElement(EDIT_BUTTON_LOCATOR).click();
    }

    public void clickOverallDeleteButton() {
        waitForElementClickable(DELETE_OVERALL_BUTTON_LOCATOR);
        driver.findElement(DELETE_OVERALL_BUTTON_LOCATOR).click();
    }

    public void clickOverallAddInAddPageButton() {
        WebElement button = driver.findElement(ADD_OVERALL_IN_ADD_PAGE_BUTTON);
        scrollIntoView(button);
        button.click();
    }

    public void clickOverallAddInEntityPageButton(String entityName) {
        driver.findElement(By.xpath
                (String.format(ADD_OVERALL_IN_ENTITY_PAGE_BUTTON_LOCATOR, entityName))).click();

    }


}



