import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Test;

import static org.example.TransactionStatus.FAILED;
import static org.example.TransactionStatus.SUCCESSFUL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveTransactionByIdTest {


    @Test
    public void test_RemoveTransactionWithExistingId_Successfully(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);
        database.add(transaction1);

        int count = database.getCount();

        database.removeTransactionById(transaction1.getId());
        assertEquals(count-1,database.getCount());
        

    }
    @Test
    public void test_RemoveTransactionWithNonExistingId_Throws(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);

        assertThrows(IllegalArgumentException.class,()->database.removeTransactionById(transaction1.getId()));


    }
}
