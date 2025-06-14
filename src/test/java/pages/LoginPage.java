package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "username")
    private WebElement userNameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (id = "Login")
    private WebElement loginButton;

    @Override
    public LoginPage open() {
        log.info("Opening LoginPage");
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com");
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public HomePage login(String user, String password) {
        log.info("Log in with credential: '{}', '{}'", user, password);
        userNameField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
