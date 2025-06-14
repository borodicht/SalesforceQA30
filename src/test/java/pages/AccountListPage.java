package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AccountListPage extends BasePage{

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage open() {
        driver.get("ttps://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account");
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=New]")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public NewAccountModal clickNew() {
        driver.findElement(By.cssSelector("[title=New]")).click();
        return new NewAccountModal(driver);
    }
}
