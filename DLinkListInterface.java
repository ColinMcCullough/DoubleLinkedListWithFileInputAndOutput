
/**
 * Write a description of interface DLinkListInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface DLinkListInterface<E>
{
    /**
     * Adds an element by index
     * @Throws IndexOutOfBoundsException (index < 0 || index > size)
     * @param int, Element
     */
    void add(int index,E data);
    
    /**
     * Adds an element to the start of the List
     * @param Element
     */
    void addFirst(E data);
    
    /**
     * Adds an element to the end of the List
     * @param Element
     */
    void addLast(E data);
    
    
    /**
     * Deletes an element by index
     * @param int
     * @Throws IndexOutOfBoundsException (index < 0 || index >= size)
     */
    void delete(int index);
    
    /**
     * Adds the first element of the List
     */
    void deleteFirst();
    
    /**
     * Deletes the last element of the List
     */
    void deleteLast();
    
    /**
     * Returns the number of elemenets in the List
     * @return int
     */
    int getSize();
    
    /**
     * Clears the list of all elements
     */
    void clear();
    
    /**
     * Returns true if Element is contained in the list
     * Element data must override equals method of Big O object
     * @param Element
     * @return boolean
     */
    boolean contains(E data);
    
    /**
     * Gets Element in List using the index of its position
     * @param int
     * @throws IndexOutOfBoundsException (index < 0 || index >= size)
     * @return Element
     */
    E get(int index);
    
    /**
     * Gets first Element in List
     * @return Element
     */
    E getFirst();
    
    /**
     * Gets last Element in List
     * @return Element
     */
    E getLast();
}
