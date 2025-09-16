import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Test;

import static org.example.TransactionStatus.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddAndContainUnitTest {





    @Test
    public void test_addMultipleTransaction_SaveOnlyUnique_AndContainThemSuccessfullyInTheDatabase(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);
        Transaction transaction2=new TransactionImpl(2, FAILED,"Ivan","Martin",25.5);
        Transaction  transaction3=new TransactionImpl(3, FAILED,"Ivan","Martin",25.5);
        Transaction  transaction4=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);

        Result result = new Result(transaction1, transaction2, transaction3, transaction4);


        assertFalse(database.contains(result.transaction1()));
       assertEquals(0,database.getCount());

        extracted(database, result);

        assertTrue(database.contains(result.transaction1()));
        assertTrue(database.contains(result.transaction1().getId()));
        assertEquals(3,database.getCount());
    }

    private static void extracted(ChainblockImpl database, Result result) {
        database.add(result.transaction1());
        database.add(result.transaction2());
        database.add(result.transaction3());
        database.add(result.transaction4());
    }

    private record Result(Transaction transaction1, Transaction transaction2, Transaction transaction3, Transaction transaction4) {
    }


}
