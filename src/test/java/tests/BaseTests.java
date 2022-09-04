package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected String EMAIL = "budai.s@mail.ru";
    protected String PASSWORD = "CJ.q2q9Rx/IrUfqe/CbQ";
    protected WebDriver driver;
    protected WebDriverWait wait;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);


    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {

        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));


    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }


}
