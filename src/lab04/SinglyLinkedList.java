package lab04;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 * 
 * Edit for lab4: Made Queue more generic, can be used for any object type, not just Currency.
 */

public class SinglyLinkedList <E>
{
    private int count; 
    private LinkNode <E> start;
    private LinkNode <E> end;
    
    public SinglyLinkedList()
    {
        count = 0;
        start = null;
        end = null;
    }
    
    /*
     * Return number of elements in the list.
     * 
     * Post: 
     * Return number of elements as an integer
     */
    public int getCount()
    {
        return count;
    }
    
    /*
     * Return the first node of the list.
     *
     * Post: 
     * Return the first node of the list if the list is not empty.
     * Return null if the list is empty.
     */
    public LinkNode <E> getStart()
    {
        return start;
    }
    
    /*
     * Return the last node of the list.
     *
     * Post: 
     * Return the last node of the list if the list is not empty.
     * Return null if the list is empty.
     */
    public LinkNode <E> getEnd()
    {
        return end;
    }
    
    /*
     * Add a Currency object into the list at the given index.
     * 
     * Pre:
     * curr - the reference to the Currency object. Cannot be null.
     * i    - the index at which the curr is added to the list. Cannot be negative.
     * 
     * Post:
     * An exception will be thrown if curr is null or if i negative.
     * If i is 0, the curr is added to the start of the list.
     * If i is equal to or greater than the number of elements n the list, the curr is added at the end of the list.
     */
    public void add(E data, int i)
    {
    	/* 
    	Pseudocode:
    	Check if currency is null or position is negative
        Make new node with currency
        If list is empty
            start and end = new node
        Else if adding at start
            Put new node before current start
        Else if adding at end or further
            Attach new node after current end
        Else
            Insert new node at position
        Increase count by 1
    	 */
    	
    	if (data == null) {
    		throw new IllegalArgumentException("data is null");
    	} else if (i < 0) {
    		throw new IllegalArgumentException("Index is negative");
    	}
    	
        LinkNode<E> newNode = new LinkNode<>(data, null);
        
        if (start == null) { // Insert as list's first node
            start = newNode;
            end = newNode;
        } else if (i+1 > count) { // Insert after list's tail node
            end.setNext(newNode);
            end = newNode; 
        } else if (i == 0) {
            newNode.setNext(start);
            start = newNode;
        } else { // Insert in middle of list
            LinkNode<E> currNode = start;
            for (int j = 0; j < i-1; j++) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
        count++;
    }
    
    
    /*
     * Remove and return the Currency object from the list at the given index 
     *
     * Pre:
     * i - the index at which the Currency object will be removed.
     * 
     * Post:
     * If i is negative or equal to or greater than the number of elements in the list, a null is returned.
     * Otherwise the Currency object at the index i is removed from the list and is returned.
     */
    public E remove(int i)
    {
    	/*
    	Pseudocode:
    	Check position is not negative or that list is not empty
        If removing first node
            Remove first node
        Else
            Find node at position and remove
        Adjust end if needed
        Decrease count and return removed currency
    	 */
    	
    	if (i < 0 || i >= count || start == null) { // if curr list is empty
            return null;
        } else if (i == 0) { // if removing first node
            E startCurr = start.getData();
            start = start.getNext();
            count--;
            if (count == 0) { // if there's only one node
                end = null;
            }
            return startCurr;
        } else { // remove from middle or end of list
            LinkNode <E> node = start;
            
            for (int j = 0; j < i-1; j++) {
                node = node.getNext();
            }
            E curr = node.getNext().getData();
            node.setNext(node.getNext().getNext());
            count--;
            if (i == count) {
                end = node;
            }
            return curr;
        }
    }
        
    /*
     * Get the Currency object at the given index.
     *
     * Pre:
     * i - the index at which the Currency object will be returned.
     * 
     * Post:
     * Returns null if the index i is out of range.
     * Returns the Currency object at the index i if i is in the range.
     */
    public E getData(int i)
    {
    	/*
    	Pseudocode:
    	Check that position is not negative or out of bounds
        Find currency at that position
        Return currency
    	 */
    	
        if (i < 0 || i >= count) {
            return null;
        }
        
        LinkNode <E> currNode = start;

        for (int j = 0; j < i; j++) {
            currNode = currNode.getNext();
        }
        
        return currNode.getData();
    }
    
    /*
     * Print the Currency objects in the list in the order from the start to the end of the list.
     * 
     * Post:
     * Returns a string containing all the Currency objects in the list.
     */
    public String printList()
    {
        String nodeList = "";
        LinkNode <E> currNode = start;
        
        for (int i = 0; i < count; i++) {
            nodeList += currNode.getData().toString() + "\t";
            currNode = currNode.getNext();
        }
        
        return nodeList;
    }
    
    /*
    * Check if the list is empty.
    * 
    * Post:
    * Returns true if the list is empty.
    * Returns false if the list is not empty.
    */
    public boolean isListEmpty()
    {
        return start == null;
    }    
}
