import org.example.Account;
import org.example.Bank;
import org.example.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void customerSummaryNoAccountTest() {
        Bank bank = new Bank();
        Customer maria = new Customer("Maria");
        bank.addCustomer(maria);

        assertEquals("Customer Summary\n - Maria (0 accounts)", bank.customerSummary());
    }

    @Test
    public void customerSummaryOneAccountTest() {
        Bank bank = new Bank();
        Customer maria = new Customer("Maria");
        maria.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(maria);

        assertEquals("Customer Summary\n - Maria (1 account)", bank.customerSummary());
    }

    @Test
    public void customerSummaryMultipleAccountsTest() {
        Bank bank = new Bank();
        Customer maria = new Customer("Maria");
        maria.openAccount(new Account(Account.CHECKING));
        maria.openAccount(new Account(Account.SAVINGS));
        bank.addCustomer(maria);

        assertEquals("Customer Summary\n - Maria (2 accounts)", bank.customerSummary());
    }
}
