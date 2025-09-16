import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.TransactionStatus.*;
import static org.example.TransactionStatus.SUCCESSFUL;

public class GetAllSendersWithTransactionStatusTest {



    @Test
    public void test_whenTransactionExistWithThisStatus_ThenReturnThem(){
        ChainblockImpl database=new ChainblockImpl();
        //Lowest->Second
        Transaction transaction1=new TransactionImpl(1, SUCCESSFUL,"Ivan","Martin",5.5);
        //Biggest->First
        Transaction transaction2=new TransactionImpl(2, SUCCESSFUL,"Dani","Martin",17.5);

        Transaction transaction3=new TransactionImpl(2, ABORTED,"Mitko","Martin",25.5);


        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);


        List<String> names = iterableList(database);
        String first = names.getFirst();
        String last = names.getLast();
        Assertions.assertEquals(first,transaction2.getFrom());
        Assertions.assertEquals(last,transaction1.getFrom());


    }

    @Test
    public void test_whenTransactionDoNotExistWithThisStatus_ThenReturnException(){
        ChainblockImpl database=new ChainblockImpl();
        Assertions.assertThrows(IllegalArgumentException.class,()->database.getAllSendersWithTransactionStatus(FAILED));
    }

    private static List<String> iterableList(ChainblockImpl database) {
        Iterable<String> allTransactions = database.getAllSendersWithTransactionStatus(SUCCESSFUL);
        Assertions.assertNotNull(allTransactions);
        List<String> transactions=new ArrayList<>();

        allTransactions.forEach(transactions ::add);
        return transactions;
    }
}
