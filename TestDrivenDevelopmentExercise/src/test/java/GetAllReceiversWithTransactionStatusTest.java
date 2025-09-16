import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;

import java.util.ArrayList;
import java.util.List;

import static org.example.TransactionStatus.ABORTED;
import static org.example.TransactionStatus.SUCCESSFUL;

public class GetAllReceiversWithTransactionStatusTest {



    @Test
    public void test_whenTransactionExistWithThisStatus_ThenReturnReceivers() {
        ChainblockImpl database = new ChainblockImpl();
        //Lowest->Second
        Transaction transaction1 = new TransactionImpl(1, SUCCESSFUL, "Ivan", "Martin", 5.5);
        //Biggest->First
        Transaction transaction2 = new TransactionImpl(2, SUCCESSFUL, "Dani", "Ivan", 17.5);

        Transaction transaction3 = new TransactionImpl(2, ABORTED, "Mitko", "Martin", 25.5);


        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        Iterable<String> allReceiversWithTransactionStatus = database.getAllReceiversWithTransactionStatus(SUCCESSFUL);
        List<String> names=new ArrayList<>();
        allReceiversWithTransactionStatus.forEach(names::add);

        Assertions.assertEquals("Martin",names.getLast());
        Assertions.assertEquals("Ivan",names.getFirst());
    }
    @Test
    public void test_whenTransactionNotExist_Throw() {
        ChainblockImpl database = new ChainblockImpl();
        //Lowest->Second
        Transaction transaction1 = new TransactionImpl(1, SUCCESSFUL, "Ivan", "Martin", 5.5);
        //Biggest->First
        Transaction transaction2 = new TransactionImpl(2, SUCCESSFUL, "Dani", "Ivan", 17.5);

        Transaction transaction3 = new TransactionImpl(2, ABORTED, "Mitko", "Martin", 25.5);


        database.add(transaction3);


        Assertions.assertThrows(IllegalArgumentException.class,()->database.getAllReceiversWithTransactionStatus(SUCCESSFUL));
    }
}
