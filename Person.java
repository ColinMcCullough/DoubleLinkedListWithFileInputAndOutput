
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String first;
    private String last;
    private String id;

    /**
     * Constructor for objects of class Person
     */
    public Person(String first)
    {
        // initialise instance variables
        this.first = first;
    }
    
    /**
     * Constructor for objects of class Person
     */
    public Person(String first, String last)
    {
        // initialise instance variables
        this.first = first;
        this.last = last;
    }
    
    public Person(String first, String last, String id)
    {
        // initialise instance variables
        this.first = first;
        this.last = last;
        this.id = id;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    
    public void setID(String id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }
    
    public String getLast() {
        return last;
    }
    
    public String getId() {
        return id;
    }
    public String toString() {
        return first + " " + last + " " + id;
    }
    
    public boolean equals(Object obj) {
        if(this == obj) {return true;}
        if(obj instanceof Person) {
            if(this.getFirst().equals(((Person)obj).getFirst())) {
                return true;
            }
        }        
        return false;
    }
}
