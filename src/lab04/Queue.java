package lab04;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 * 
 * Edit for lab4: Made Queue more generic, can be used for any object type, not just Currency.
 */

public class Queue <E>
{
    private SinglyLinkedList <E> list;
    
    public Queue()
    {
        list = new SinglyLinkedList<>();
    }
    
    /*
     * Add a Currency object to the end of the queue.
     * 
     * Pre:
     * curr - The Currency object to be enqueued.
     *
     * Post:
     * If curr is not null, it has been added to the end of the queue.
     * If curr is null, an exception is thrown.
     */
    public void enqueue(E curr)
    {
        list.add(curr, list.getCount());
    }
    
    /*
     * Remove and return the Currency object from the beginning of the queue.
     * 
     * Post:
     * If the queue is not empty, the Currency object at the beginning of the queue is removed and returned.
     * If the queue is empty, a null is returned.
     */
    public E dequeue()
    {
        return list.remove(0);
    }
    
    /*
     * Return the Currency object from the beginning of the queue.
     * 
     * Post:
     * If the queue is not empty, the Currency object at the beginning of the queue is returned.
     * If the queue is empty, a null is returned.
     */
    public E peekFront()
    {
        return list.getData(0);
    }
    
    /*
     * Return the Currency object from the end of the queue.
     * 
     * Post:
     * If the queue is not empty, the Currency object at the end of the queue is returned.
     * If the queue is empty, a null is returned.
     */
    public E peekRear()
    {
        return list.getData(list.getCount() - 1);
    }
    
    /*
    * Print the Currency objects in the queue in the order from the beginning to the end of the queue.
    *
    * Post:
    * Returns a string containing all the Currency objects in the queue.
    */
    public String printQueue()
    {
        return list.printList();
    }
    
    /*
     * Check if the queue is empty.
     * 
     * Post:
     * Returns true if the queue is empty.
     * Returns false if the queue is not empty.
     */
    public boolean isEmpty()
    {
    	return list.isListEmpty();
    }
    
}
