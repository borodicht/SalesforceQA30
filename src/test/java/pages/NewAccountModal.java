package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.Picklist;

public class NewAccountModal extends BasePage{

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
    }

    public void createAccount(String name, String phone, String fax, String rating) {
        new Input(driver, "Account Name").write(name);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Picklist(driver, "Rating").select(rating);
    }

    public void clickSaveButton() {
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
    }
}
