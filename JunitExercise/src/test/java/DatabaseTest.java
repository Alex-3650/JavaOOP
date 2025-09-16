import org.junit.jupiter.api.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Database database;




    @Test
    public void test_creating_Database_over16elements_ExceptionThrown(){
     Integer[] elements=new Integer[17];

      assertThrows(OperationNotSupportedException.class, () -> new Database(elements));
    }
    @Test
    public void test_creating_EmptyDatabase_ExceptionThrown(){


        assertThrows(OperationNotSupportedException.class, Database::new);
    }
    @Test
    public void test_creating_Database_Between0And16Elements_Successful() throws OperationNotSupportedException {
        Integer[] elements=new Integer[]{1,2,3};
        database=new Database(elements);

      assertArrayEquals(elements,database.getElements());
    }

    @Test
    public void test_addNullValue_ExceptionThrown() throws OperationNotSupportedException {
        Integer[] elements=new Integer[]{1,2,3};
        database=new Database(elements);


        assertThrows(OperationNotSupportedException.class,()->database.add(null));

    }
    @Test
    public void test_addValueInTheEndOfTheArray_Successfully() throws OperationNotSupportedException {
        Integer[] elements=new Integer[]{1,2,3};
        database=new Database(elements);
        Integer elementToAdd=8;

        database.add(elementToAdd);


        assertEquals(elementToAdd,database.getElements()[database.getElements().length-1]);
        assertEquals(elements.length+1,database.getElements().length);
    }

    @Test
    public void test_removeValueInTheArray_Successfully() throws OperationNotSupportedException {
        Integer[] elements=new Integer[]{1,2,3};
        int lastNumber=elements[elements.length-2];
        database=new Database(elements);
       int length=database.getElementsCount();

        database.remove();


        assertEquals(length-1,database.getElementsCount());
        assertEquals(lastNumber,database.getElements()[database.getElements().length-1]);

    }
    @Test
    public void test_removeOperationInEmptyArray_ExceptionThrown() throws OperationNotSupportedException {
        Integer[] elements=new Integer[]{1};
        database=new Database(elements);
        database.remove();


        assertThrows(OperationNotSupportedException.class,()->database.remove());




    }


}
