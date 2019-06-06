import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DoubleLinkedListUnitTests.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DoubleLinkedListUnitTests
{
    private DoubleLinkedList doubleLi1;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;
    /**
     * Default constructor for test class DoubleLinkedListUnitTests
     */
    public DoubleLinkedListUnitTests()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
        doubleLi1 = new DoubleLinkedList();
        person1 = new Person("person1", "last", "12312");
        person2 = new Person("person2", "last", "2342342");
        person3 = new Person("person3", "last", "423525");
        person4 = new Person("person4", "last", "12312");
        person5 = new Person("person5", "last", "2342342");
        person6 = new Person("person6", "last", "423525");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testcontains()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        doubleLi1.add(0, person1);
        doubleLi1.add(1, person2);
        doubleLi1.add(2, person3);
        doubleLi1.add(3, person4);
        doubleLi1.add(4, person5);
        assertEquals(true, doubleLi1.contains(person1));
        assertEquals(true, doubleLi1.contains(person2));
        assertEquals(true, doubleLi1.contains(person3));
        assertEquals(true, doubleLi1.contains(person4));
        assertEquals(true, doubleLi1.contains(person5));
    }
    
    @Test
    public void testAddFirst()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        doubleLi1.addFirst(person1);
        assertEquals(person1, doubleLi1.getFirst());
    }
    
    @Test
    public void testAddFirstWithTwo()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        doubleLi1.addFirst(person1);
        doubleLi1.addFirst(person2);
        assertEquals(person2, doubleLi1.getFirst());
    }
    
    @Test
    public void testAddFirstWithMultiple()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        doubleLi1.addFirst(person1);
        doubleLi1.addFirst(person2);
        doubleLi1.addFirst(person3);
        assertEquals(person3, doubleLi1.getFirst());
    }
    
    @Test
    public void testAddLast()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        Person person1 = new Person("Person1", "McCullough", "820016476");
        doubleLi1.addLast(person1);
        assertEquals(person1, doubleLi1.getLast());
    }
    
    @Test
    public void testAddLastWithTwo()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        doubleLi1.addLast(person1);
        doubleLi1.addLast(person2);
        doubleLi1.addLast(person3);
        assertEquals(person3, doubleLi1.getLast());
    }
    
    @Test
    public void testAddLastWithMultiple()
    {
        DoubleLinkedList<Person> doubleLi1 = new DoubleLinkedList<Person>();
        doubleLi1.addLast(person1);
        doubleLi1.addLast(person2);
        assertEquals(person2, doubleLi1.getLast());
    }


    @Test
    public void testGetByIndex()
    {
        doubleLi1 = new DoubleLinkedList();
        person1 = new Person("person1", "last", "12312");
        person2 = new Person("person2", "last", "2342342");
        person3 = new Person("person3", "last", "423525");
        doubleLi1.addFirst(person3);
        doubleLi1.addFirst(person2);
        doubleLi1.addFirst(person1);
        assertEquals(person1, doubleLi1.get(0));
        assertEquals(person2, doubleLi1.get(1));
        assertEquals(person3, doubleLi1.get(2));
    }
   

    @Test
    public void TestAddByIndex()
    {
        doubleLi1.add(0, person1);
        assertEquals(person1, doubleLi1.get(0));
        doubleLi1.add(1, person2);
        assertEquals(person2, doubleLi1.get(1));
        doubleLi1.add(2, person3);
        assertEquals(person3, doubleLi1.get(2));
        doubleLi1.add(3, person4);
        assertEquals(person4, doubleLi1.get(3));
    }
    
    @Test
    public void TestAddByIndexToCentr()
    {
        doubleLi1.add(0, person1);
        assertEquals(person1, doubleLi1.get(0));
        doubleLi1.add(1, person2);
        assertEquals(person2, doubleLi1.get(1));
        doubleLi1.add(2, person3);
        assertEquals(person3, doubleLi1.get(2));
        doubleLi1.add(3, person4);
        assertEquals(person4, doubleLi1.get(3));
        doubleLi1.add(2, person5);
        assertEquals(person5, doubleLi1.get(2));
        assertEquals(person3, doubleLi1.get(3));
        assertEquals(person4, doubleLi1.get(4));
    }
    
    @Test
    public void TestDeleteFirst()
    {
        doubleLi1.add(0, person1);
        doubleLi1.add(1, person2);
        doubleLi1.add(2, person3);
        doubleLi1.add(3, person4);
        doubleLi1.add(4, person5);
        doubleLi1.add(5, person6);
        doubleLi1.deleteFirst();
        assertEquals(person2, doubleLi1.get(0));
        assertEquals(person3, doubleLi1.get(1));
        assertEquals(person4, doubleLi1.get(2));
        assertEquals(person5, doubleLi1.get(3));
        assertEquals(person6, doubleLi1.get(4));
    }
    
        @Test
    public void TestDeleteLast()
    {
        doubleLi1.add(0, person1);
        doubleLi1.add(1, person2);
        doubleLi1.add(2, person3);
        doubleLi1.add(3, person4);
        doubleLi1.add(4, person5);
        doubleLi1.add(5, person6);
        doubleLi1.deleteLast();
        assertEquals(person1, doubleLi1.get(0));
        assertEquals(person2, doubleLi1.get(1));
        assertEquals(person3, doubleLi1.get(2));
        assertEquals(person4, doubleLi1.get(3));
        assertEquals(person5, doubleLi1.get(4));
    }
    
            @Test
    public void TestDeleteByIndex()
    {
        doubleLi1.add(0, person1);
        doubleLi1.add(1, person2);
        doubleLi1.add(2, person3);
        doubleLi1.add(3, person4);
        doubleLi1.add(4, person5);
        doubleLi1.add(5, person6);
        doubleLi1.delete(1);
        assertEquals(person1, doubleLi1.get(0));
        assertEquals(person3, doubleLi1.get(1));
        assertEquals(person4, doubleLi1.get(2));
        assertEquals(person5, doubleLi1.get(3));
        assertEquals(person6, doubleLi1.get(4));
    }
    
            @Test
    public void TestgetSize()
    {
        doubleLi1.add(0, person1);
        doubleLi1.add(1, person2);
        doubleLi1.add(2, person3);
        doubleLi1.add(3, person4);
        doubleLi1.add(4, person5);
        doubleLi1.add(5, person6);
        assertEquals(6, doubleLi1.getSize());
    }
    
            @Test
    public void TestClear()
    {
        doubleLi1.add(0, person1);
        doubleLi1.add(1, person2);
        doubleLi1.add(2, person3);
        doubleLi1.add(3, person4);
        doubleLi1.add(4, person5);
        doubleLi1.add(5, person6);
        doubleLi1.clear();
        assertEquals(0, doubleLi1.getSize());
    }
}





