import org.example.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    double expectedAmount = 5;
    Transaction transaction = new Transaction(expectedAmount);

    @Test
    public void transactionTest() {
        assertNotNull(transaction);
    }

    @Test
    public void transactionAmountTest() {
        assertEquals(expectedAmount, transaction.getAmount());
    }

    @Test
    public void transactionDateTest() {
        assertNotNull(transaction.getTransactionDate());
    }

}
