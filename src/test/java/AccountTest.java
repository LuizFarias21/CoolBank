import org.example.Account;
import org.example.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    Customer oscar = new Customer("Oscar");
    Account checkingAccount = new Account(Account.CHECKING);

    @Test
    public void accountTransactionsTest() {

        oscar.openAccount(checkingAccount);
        checkingAccount.deposit(100);
        checkingAccount.deposit(200);
        checkingAccount.withdraw(50);

        // Test the quantity of transactions
        assertEquals(3, checkingAccount.getTransactions().size());

        // Test if all transactions are summed correctly
        assertEquals(250.0, checkingAccount.sumTransactions());
    }




}
