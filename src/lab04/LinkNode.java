package lab04;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 */

public class LinkNode <E>
{
    private E data;
    private LinkNode <E> next;
    
    public LinkNode()
    {
         data = null;
         next = null;
    }
    
    public LinkNode(E data, LinkNode <E> next)
    {
         this.data = data;
         this.next = next;
    }
    
    /*
     * Post:
     * Return the data attribute of the node.
     */
    public E getData()
    {
        return data;
    }
    
    
    /*
     * Pre:
     * data - the value of data attribute to set.
     * 
     * Post:
     * The data attribute has been set.
     */
    public void setData(E data)
    {
        this.data = data;
    }
    
    /*
     * Post:
     * Returns the next LinkNode attribute.
     */
    public LinkNode <E> getNext()
    {
        return next;
    }
    
    /*
     * Pre:
     * next - the LinkNode value of next attribute to be set.
     * 
     * Post:
     * The next LinkNode attribute has been set.
     */
    public void setNext(LinkNode <E> next)
    {
        this.next = next;
    }
}
