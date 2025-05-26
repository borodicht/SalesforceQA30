package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        Account account = AccountFactory.getAccount("Cold");
        loginStep.auth("tborodich@tms.sandbox", "Password002!");
        accountStep.createAccount(account);
    }
}
