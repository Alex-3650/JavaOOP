import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.TransactionStatus.*;

public class GetByTransactionStatusTest {



    @Test
    public void test_whenTransactionExistWithThisStatus_ThenReturnThem(){
        ChainblockImpl database=new ChainblockImpl();
        Transaction transaction1=new TransactionImpl(1, SUCCESSFUL,"Ivan","Martin",5.5);
        //Biggest->First
        Transaction transaction2=new TransactionImpl(2, SUCCESSFUL,"Ivan","Martin",17.5);

        Transaction transaction3=new TransactionImpl(2, ABORTED,"Ivan","Martin",25.5);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);

        List<Transaction> transactions = iterableList(database);

        Assertions.assertEquals(2,transactions.size());


        Assertions.assertEquals(transaction2,transactions.getFirst());



    }

    @Test
    public void test_whenTransactionDoNotExistWithThisStatus_ThenReturnException(){
        ChainblockImpl database=new ChainblockImpl();
        Assertions.assertThrows(IllegalArgumentException.class,()->database.getByTransactionStatus(FAILED));
    }

    private static List<Transaction> iterableList(ChainblockImpl database) {
        Iterable<Transaction> allTransactions = database.getByTransactionStatus(SUCCESSFUL);
        Assertions.assertNotNull(allTransactions);
        List<Transaction> transactions=new ArrayList<>();

        allTransactions.forEach(transactions ::add);
        return transactions;
    }
}
