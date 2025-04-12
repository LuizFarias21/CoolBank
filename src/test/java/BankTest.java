import org.example.Account;
import org.example.Bank;
import org.example.Customer;
import org.junit.jupiter.api.Test;

import static org.example.Bank.toDollars;
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

    @Test
    public void totalInteresPaidTest() {
        Bank bank = new Bank();
        Account checkingAccount1 = new Account(Account.CHECKING);
        Account checkingAccount2 = new Account(Account.CHECKING);

        Customer henry = new Customer("Henry");
        Customer carl = new Customer("Carl");

        bank.addCustomer(henry);
        bank.addCustomer(carl);

        henry.openAccount(checkingAccount1);
        carl.openAccount(checkingAccount2);

        checkingAccount1.interestEarned();
        checkingAccount2.interestEarned();

        checkingAccount1.deposit(30000);
        checkingAccount2.deposit(70000);



        assertEquals(100.0, bank.totalInterestPaid());
    }

    @Test
    public void toDollarsTest() {
        double value = 21;
        assertEquals("$21.00", toDollars(21));
    }
}
