import org.example.Account;
import org.example.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void accountTransactionsTest() {

        Customer oscar = new Customer("Oscar");
        Account checkingAccount = new Account(Account.CHECKING);
        oscar.openAccount(checkingAccount);
        checkingAccount.deposit(100);
        checkingAccount.deposit(200);
        checkingAccount.withdraw(50);

        // Test the quantity of transactions
        assertEquals(3, checkingAccount.getTransactions().size());

        // Test if all transactions are summed correctly
        assertEquals(250.0, checkingAccount.sumTransactions());

    }

    @Test
    public void DepositAndWithdrawTransactionsTest() {

        Customer oscar = new Customer("Oscar");
        Account checkingAccount = new Account(Account.CHECKING);
        oscar.openAccount(checkingAccount);

        checkingAccount.deposit(100);
        checkingAccount.withdraw(50);

        assertEquals(100.0, checkingAccount.getTransactions().getFirst().getAmount());
        assertEquals(-50.0, checkingAccount.getTransactions().getLast().getAmount());

    }

    @Test
    public void DepositAndWithdrawTransactionsExceptionTest() {

        Customer oscar = new Customer("Oscar");
        Account checkingAccount = new Account(Account.CHECKING);
        oscar.openAccount(checkingAccount);

        IllegalArgumentException depositException = assertThrows(IllegalArgumentException.class, () -> checkingAccount.deposit(-1));
        IllegalArgumentException withdrawException = assertThrows(IllegalArgumentException.class, () -> checkingAccount.withdraw(-1));

        assertEquals("Amount must be greater than zero", depositException.getMessage());
        assertEquals("Amount must be greater than zero", withdrawException.getMessage());
    }

    @Test
    public void interestEarnedTest() {

        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxiSavingAccount = new Account(Account.MAXI_SAVINGS);
        Account invalidAccount = new Account(3);

        // Test for checking accounts
        checkingAccount.deposit(1000);
        assertEquals(1, checkingAccount.interestEarned());

        // Test for saving accounts
        savingsAccount.deposit(500);
        assertEquals(0.5, savingsAccount.interestEarned());

        savingsAccount.deposit(600);
        assertEquals(2.2, savingsAccount.interestEarned());

        // Test for maxi saving accounts
        maxiSavingAccount.deposit(100);
        assertEquals(2.0, maxiSavingAccount.interestEarned());

        maxiSavingAccount.deposit(1100);
        assertEquals(60.0, maxiSavingAccount.interestEarned());

        maxiSavingAccount.deposit(1000);
        assertEquals(220.0, maxiSavingAccount.interestEarned());

        // Test for invalid account
        IllegalStateException invalidAccountType = assertThrows(IllegalStateException.class, () -> invalidAccount.interestEarned());
        assertEquals("Unknown account type: 3", invalidAccountType.getMessage());
    }

}
