package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import wrappers.Input;

public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() throws InterruptedException {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("tborodich@tms.sandbox");
        driver.findElement(By.id("password")).sendKeys("Password002!");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(1000);
        newAccountModal.open();
        newAccountModal.createAccount("ALFA", "+34525425425", "+8658876674", "Cold");
        newAccountModal.clickSaveButton();
    }
}
