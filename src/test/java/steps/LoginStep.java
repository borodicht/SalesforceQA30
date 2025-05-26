package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void auth(String user, String password) {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
    }
}
