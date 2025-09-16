import org.example.ChainblockImpl;
import org.example.Transaction;
import org.example.TransactionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.TransactionStatus.ABORTED;
import static org.example.TransactionStatus.SUCCESSFUL;

public class GetAllOrderedByAmountDescendingThenById_Test {



    @Test
    public void  test_WhenThereAreMultipleTransactions_GetAllOrderedByAmountDescendingThenById(){

        ChainblockImpl database = new ChainblockImpl();
        //Lowest->Second
        Transaction transaction1 = new TransactionImpl(1, SUCCESSFUL, "Ivan", "Martin", 5.5);
        //Biggest->First
        Transaction transaction2 = new TransactionImpl(4, SUCCESSFUL, "Dani", "Ivan", 17.5);

        Transaction transaction3 = new TransactionImpl(2, ABORTED, "Mitko", "Martin", 25.5);

        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);

        Iterable<Transaction> result = database.getAllOrderedByAmountDescendingThenById();
        Assertions.assertNotNull(result);
        List<Transaction> list=new ArrayList<>();
        result.forEach(list::add);

        Assertions.assertEquals(3,list.size());
        Assertions.assertEquals(2,list.getFirst().getId());
        Assertions.assertEquals(4,list.get(1).getId());



    }
}
