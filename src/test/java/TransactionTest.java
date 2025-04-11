import org.example.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    Transaction transaction = new Transaction(5);

    @Test
    public void transactionTest() {
        assertNotNull(transaction);
    }

    @Test
    public void transactionAmountTest() {
        double expectedAmount = 5;
        assertEquals(expectedAmount, transaction.getAmount());
    }

    @Test
    public void transactionDateTest() {
        assertNotNull(transaction.getTransactionDate());
    }

}
