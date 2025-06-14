package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.AccountListPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountModal;
import steps.AccountStep;
import steps.LoginStep;
import utils.DriverFactory;
import utils.TestListener;

import java.time.Duration;
import java.util.HashMap;

import static utils.AllureUtils.takeScreenshot;
import static utils.DriverFactory.*;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    LoginStep loginStep;
    AccountStep accountStep;
    String user = System.getProperty("user");
    String password = System.getProperty("password");

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            HashMap<String, Object> chromePrefs = new HashMap<>();
//            chromePrefs.put("credentials_enable_service", false);
//            chromePrefs.put("profile.password_manager_enabled", false);
//            options.setExperimentalOption("prefs", chromePrefs);
//            options.addArguments("--incognito");
//            options.addArguments("--disable-notifications");
//            options.addArguments("--disable-popup-blocking");
//            options.addArguments("--disable-infobars");
//            driver = new ChromeDriver(options);
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }
        createDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        softAssert = new SoftAssert();

        loginStep = new LoginStep(getDriver());
        accountStep = new AccountStep(getDriver());
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(driver);
        }
        quitDriver();
    }
}
