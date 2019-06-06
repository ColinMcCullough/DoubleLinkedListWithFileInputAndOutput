import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.io.FileWriter;
/**
 * Write a description of interface DoubleLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoubleLinkedList<E> implements DLinkListInterface<E>, Iterable<E>
{
    private Node<E> head;
    private int size;
    private static final String FILE_OF_INPUT= "input.txt";
    private static final String FILE_OF_OUTPUT= "output.txt";

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list = list.readFromFile(FILE_OF_INPUT); //reads File into Double Linked List
        for(Integer i : list) {
            i = i * 10;
            System.out.println(i.toString());
        }
        list.writeToFile(FILE_OF_OUTPUT,list); //writes to external file
    }

    /**
     * Writes a DoubleLinkedList of Elements out to a filename
     * @param String filename
     * @param DoubleLinkedList<E>
     * @return true if successful, false otherwise.
     */
    private boolean writeToFile(String filename, DoubleLinkedList<E> list)
    {
        boolean success = false;
        int numEntries = list.getSize();
        if(numEntries > 0) {
            try (FileWriter writer = new FileWriter(filename)) {
                for(int i = 0; i < numEntries; i++) {
                    writer.write(list.get(i).toString());
                    writer.write('\n');
                }
                success = true;
            }
            catch(IOException e) {
                System.err.println("There was a problem writing to " + filename);
            }               
        }
        return success;
    }

    /**
     * Reades a file passed into the paramater and returns a DoubleLinkedList
     * where each element represents a line from the File
     * @param String filename
     * @return DoubleLinkedList<Integer>
     */
    private DoubleLinkedList<Integer> readFromFile(String file)
    {
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(file);
        DoubleLinkedList<Integer> listFromFile = new DoubleLinkedList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String response = reader.readLine();
            while(response != null) {
                if(response.length() > 0) {
                    listFromFile.addFirst(Integer.parseInt(response));                    
                }
                response = reader.readLine();
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("Unable to open " + file);
        }
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                file);
        }
        if(listFromFile.getSize() == 0) {
            System.out.println("List has nothing in it");
        }
        return listFromFile;
    }
    //constructor
    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    /*
     * Adds an Element of Data at a specific index
     * @param int index
     * @param E data
     * @return void
     */
    public void add(int index,E data) {
        if(index < 0 || index > getSize()) { // index is out of bounds
            throw new IndexOutOfBoundsException("This index is out of Bounds");
        }
        Node<E> e = new Node(data);
        if(head == null) { //no elements in list and index is 0
            head = e;
            size++;
        }
        else if(index == 0) { 
            addFirst(data);
        }
        else if(index == getSize()) { //adding element to the end of the list
            addLast(data);
        }
        else { //adding elements in between existing elements
            Node<E> before = getNode(index - 1);
            Node<E> after = getNode(index);
            e.setNext(after);
            e.setPrevious(before);
            before.setNext(e);
            after.setPrevious(e);
            size++;
        }
    }
    
    /*
     *adds element of data to the first index of the list
     *@param Element of data
     *@return void
    */
    public void addFirst(E data) {
        Node<E> e = new Node(data);
        if(head == null) { //no elements in list
            head = e;
        }  
        else { //one or more elements exist in list
            Node<E> last = head.getPrevious();
            last.setNext(e);
            e.setPrevious(last);
            e.setNext(head);
            head.setPrevious(e);
            head = e;
        } 
        size++;
    }

    /*
     *adds element of data to the last index of the list
     *@param Element of data
     *@return void
    */
    public void addLast(E data) {
        Node<E> e = new Node(data);
        if(head == null) { //no elements in list
            head = e;
        }
        else { //one or more elements exist in list
            Node<E> last = head.getPrevious();
            head.setPrevious(e);
            e.setNext(head);
            e.setPrevious(last);
            last.setNext(e);
        }
        size++;
    }

    
    /*
     *removes element of data from the index specified in the param
     *@param index posiition for delection
     *@return void
    */
    public void delete(int index) {
        if(index < 0 || index >= getSize()) { // index is out of bounds
            throw new IndexOutOfBoundsException("This index is out of Bounds");
        }
        else if(index == 0) { 
            deleteFirst();
        } 
        else if(index == getSize() -1) {
            deleteLast();
        }
        else { //will execute if index is not 0 and list is not empty
            Node<E> before = getNode(index).getPrevious();
            Node<E> after = getNode(index).getNext();
            Node<E> nodeToDelete = getNode(index);
            before.setNext(after);
            after.setPrevious(before);
            nodeToDelete.setNext(null);
            nodeToDelete.setPrevious(null);
            size--;
        }
    }
    /*
     *deletes first element of data in the list
     *@return void
    */
    public void deleteFirst() {
        if(head == null) {
            throw new IllegalArgumentException("This list is null");
        }
        Node<E> lastNode = head.getPrevious();
        Node<E> secondNode = head.getNext();
        if(getSize() > 1) {
            secondNode.setPrevious(lastNode);
            lastNode.setNext(secondNode);
            head = secondNode;
        }
        else { //only the head in a list
            head = null;
        }
        size--;
    }

    /*
     *deletes last element of data in the list
     *@return void
    */
    public void deleteLast() {
        if(head == null) {
            throw new IllegalArgumentException("This list is null");
        }
        Node<E> lastNode = head.getPrevious();
        Node<E> secondToLastNode = lastNode.getPrevious();
        if(getSize() > 1) { //more than one element in list
            head.setPrevious(secondToLastNode);
            secondToLastNode.setNext(head);
        } else { //only the head in a list
            head = null;
        }
        size--;
    }

    /*
     *gets the size of the current list
     *@return int
    */
    public int getSize() {
        return size;
    }

    /*
     *removes all elements from the list
     *@return void
    */
    public void clear() {
        Node<E> e = head.getNext();
        while(size > 0) {
            deleteFirst();           
        }
    }
    
    /*
     * Compares data passed into paramater against each element of data in the list
     * @return boolean true if it contains data, false if not
     */
    public boolean contains(E data) {
        boolean containsNode = false;
        Node<E> currentNode = head;
        if(data.equals(currentNode.getData())) { 
            containsNode = true; //first node is a match
        }
        currentNode = currentNode.getNext();
        while((currentNode != head && containsNode == false)) {
            if(data.equals(currentNode.getData())) {
                containsNode = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return containsNode;
    }
    
    /*
     * Gets element at specified index 
     * @param int index
     * @return element at specified index
     */
    public E get(int index) {
        if(index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("This index is out of Bounds");
        }
        Node<E> nodeByIndex = head;
        int i = 0;
        while(i < index) {
            nodeByIndex = nodeByIndex.getNext();
            i++;
        }
        return nodeByIndex.getData();
    }

    /*
     * Gets Node at specified index 
     * @param int index
     * @return Node<E> at specified index
     */
    public Node<E> getNode(int index) {
        if(index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("This index is out of Bounds");
        }
        Node<E> nodeByIndex = head;
        int i = 0;
        while(i < index) {
            nodeByIndex = nodeByIndex.getNext();
            i++;
        }
        return nodeByIndex;
    }

    /*
     * Gets data at index position 0
     * @return Element at first index position
     */
    public E getFirst(){
        if(head == null) {
            throw new IllegalArgumentException("This list is null");
        }
        return head.getData();   
    } 

    
    /*
     * Gets data at last index position
     * @return Element at last index position
     */
    public E getLast() {
        if(head == null) {
            throw new IllegalArgumentException("This list is null");
        }
        Node<E> lastNode = head.getPrevious();
        return lastNode.getData();  
    } 

    // return Iterator instance 
    public Iterator<E> iterator() 
    { 
        return new ListIterator<E>(this); 
    } 

    class ListIterator<E> implements Iterator<E> { 
        Node<E> current; 
        int index = 0;

        public ListIterator(DoubleLinkedList<E> list) 
        { 
            current = list.getNode(0); 
        } 

        public boolean hasNext() 
        { 
            boolean hasNextNode = false;
            if(current != null && index < size) {
                hasNextNode = true;
                index++;
            }
            return hasNextNode;
        } 

        public E next() 
        { 
            E data = current.getData(); 
            current = current.getNext(); 
            return data; 
        } 

        public void remove() 
        { 
            throw new UnsupportedOperationException(); 
        } 
    } 

    private static class Node<E>
    {
        private Node<E> next;
        private Node<E> previous;
        private E data;
        /**
         * Constructor for objects of class Node
         */
        public Node(E obj)
        {
            // initialise instance variables
            data = obj;
            setNext(this);
            setPrevious(this);
        }
        
        //
        public void setNext(Node next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public boolean hasNext() {
            if(next != null) {
                return true;
            }
            return false;
        }
    }
}
