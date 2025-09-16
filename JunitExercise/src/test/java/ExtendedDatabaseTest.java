import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtendedDatabaseTest {
    private Person person;
    private Database database;
    private Person[] people;

        @BeforeEach
    public void setUp( ) throws OperationNotSupportedException {
            this.person=new Person(12,"Ivan");
            Person grigor=new Person(1,"Grigor");
            this.people=new Person[]{person,grigor};
        this.database=new Database(people);
    }


    @Test
    public void test_findPersonByUsername_Successfully() throws OperationNotSupportedException {


        Person ivan = database.findByUsername("Ivan");
        assertEquals(person, ivan);


    }
    @Test
    public void test_findPersonByUsername_EnterNull_Throw() throws OperationNotSupportedException {



        assertThrows(OperationNotSupportedException.class,()-> database.findByUsername(null) );


    }
    @Test
    public void test_findNotExistingPersonByUsername_Throw() throws OperationNotSupportedException {



        assertThrows(OperationNotSupportedException.class,()-> database.findByUsername("Peter") );


    }
    @Test
    public void test_findExistingPersonById_Successful() throws OperationNotSupportedException {

        Person ivan = database.findById(12);
        assertEquals(person, ivan);
        assertEquals(person.getId(), ivan.getId());
        assertEquals(person.getUsername(), ivan.getUsername());



    }
    @Test
    public void test_findUnexistingPersonById_Successful() throws OperationNotSupportedException {


        assertThrows(OperationNotSupportedException.class,()->database.findById(14));


    }
}
