import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.TransactionStatus.FAILED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetByIdTest {



    @Test
    public void test_Successfully_TryToGetTransactionById(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);
        database.add(transaction1);

       assertEquals(database.getById(transaction1.getId()),transaction1);


    }
    @Test
    public void test_TryToGetTransactionByNotExistingId(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);

        assertThrows(IllegalArgumentException.class,()->database.getById(transaction1.getId()));

    }
}
