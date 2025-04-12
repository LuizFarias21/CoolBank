import org.example.Account;
import org.example.Customer;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    @Test
    public void openAccountTest() {
        Customer henry = new Customer("Henry");
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxiSavingAccount = new Account(Account.MAXI_SAVINGS);

        henry.openAccount(checkingAccount);
        henry.openAccount(savingsAccount);
        henry.openAccount(maxiSavingAccount);

        ArrayList<Account> henryAccounts = henry.getAccounts();

        assertTrue(henryAccounts.contains(checkingAccount));
        assertTrue(henryAccounts.contains(savingsAccount));
        assertTrue(henryAccounts.contains(maxiSavingAccount));
    }

    @Test
    public void totalInterestEarnedTest() {

        final double EXPECTED_VALUE = 305.0;

        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxiSavingAccount = new Account(Account.MAXI_SAVINGS);

        Customer henry = new Customer("Henry");
        henry.openAccount(checkingAccount);
        henry.openAccount(savingsAccount);
        henry.openAccount(maxiSavingAccount);

        checkingAccount.deposit(1000);
        savingsAccount.deposit(2000);
        maxiSavingAccount.deposit(3000);

        assertEquals(EXPECTED_VALUE, henry.totalInterestEarned());
    }

    @Test
    public void customerStatementTest() {
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxiSavingAccount = new Account(Account.MAXI_SAVINGS);

        Customer henry = new Customer("Henry");
        henry.openAccount(checkingAccount);
        henry.openAccount(savingsAccount);
        henry.openAccount(maxiSavingAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
        maxiSavingAccount.deposit(3000);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdraw $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Maxi Savings Account\n" +
                "  deposit $3,000.00\n" +
                "Total $3,000.00\n" +
                "\n" +
                "Total in all accounts $6,900.00", henry.getStatement());

    }

    @Test
    public void numberOfAccountsTest() {
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        Customer oscar = new Customer("Oscar");
        oscar.openAccount(checkingAccount);
        oscar.openAccount(savingsAccount);
        assertEquals(2, oscar.getNumberOfAccounts());
    }
}
