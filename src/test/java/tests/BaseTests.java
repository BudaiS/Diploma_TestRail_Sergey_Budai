package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

import static constans.Constant.TimeoutVariable.*;

@Listeners(TestListener.class)
public class BaseTests {
    protected String EMAIL = PropertyReader.getProperty("test_rail.email");
    protected String PASSWORD = PropertyReader.getProperty("test_rail.password");
    protected String NEW_PROJECT = PropertyReader.getProperty("test_rail.new_project_name");
    protected String DELETE_SECTION_NAME = PropertyReader.getProperty("test_rail.delete_section_name");
    protected String TEST_PROJECT_NAME = PropertyReader.getProperty("test_rail.test_project_name");
    protected String TEST_MILESTONES_NAME = PropertyReader.getProperty("test_rail.test_milestones_name");
    protected WebDriver driver;
    protected WebDriverWait wait;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
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
