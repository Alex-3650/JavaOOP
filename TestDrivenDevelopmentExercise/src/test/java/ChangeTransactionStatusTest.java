import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.example.TransactionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.TransactionStatus.FAILED;
import static org.example.TransactionStatus.SUCCESSFUL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeTransactionStatusTest {




    @Test
    public void test_changeStatus_Successfully(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, FAILED,"Ivan","Martin",25.5);
        Transaction transaction2=new TransactionImpl(2, SUCCESSFUL,"Ivan","Martin",25.5);
        database.add(transaction1);
        database.add(transaction2);



        database.changeTransactionStatus(2,FAILED);
         assertEquals(FAILED,transaction2.getStatus());

    }



    @Test
    public void test_changeNotExistingStatus_Throw(){
        ChainblockImpl database=new ChainblockImpl();


        assertThrows(IllegalArgumentException.class,()-> database.changeTransactionStatus(99,FAILED));



    }

}
