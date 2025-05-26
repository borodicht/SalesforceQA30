package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void createDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = new ChromeDriver();
            driverThreadLocal.set(driver);
        }
    }

    public static WebDriver getDriver() {
        return  driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        driver.quit();
        driverThreadLocal.remove();
    }
}
