
// Generic class
// Use one implementation for MANY data types
public class CircularLinkedList<T> { // T stands for T
    
    // instance variables
    private Node<T> last; // reference to the last node of the CLL
    private int size;

    // constant time access to the last node
    // access the first node? constant time O(1)
    
    // traverse the entire LL? linear 

    // nested class - can be visible inside CircularLinkedList class
    private class Node <T> {
        // instance variables of the node class
        T item; // data part of the node
        Node<T>   next; // link part of the node
    }

    public int getSize () {
        return size;
    }

    public boolean isEmpty () {
        return last == null;
    }

    public void addToFront (T item) {

        // create the node + add data
        Node<T> newNode = new Node<T>();
        newNode.item = item;

        if ( last == null ) {
            // empty list
            newNode.next = newNode; // newNode points to itself because
            // it is the only node on the CLL
            last = newNode; // update last to point to the only node
        } else {   
            newNode.next = last.next; // newNode points to first node
            last.next = newNode; // make newNode the new front
        }
         size += 1;
    }

    // start at the front and print every node's data
    public void traverse () {

        if ( last == null ) {
            return;
        }
        Node<T> ptr = last.next; // ptr starts at the front

        do { // do-while executes the loop at least one time
            System.out.print(ptr.item + " -> ");
            ptr = ptr.next; // move to the next node
        } while ( ptr != last.next ); // traverse stops when we are back at the front
        
        System.out.println(" back to the first node");

    }

    public T removeFront () {

        T item = null;
        if ( last == null ) {
            // list is empty
            return null;
        } if ( last == last.next ) {
            // one item in the list
            item = last.item;
            last = null;     
        } else {
            // more than 1 item in the list
            item = last.item;
            last.next = last.next.next; // last points to the second node
        }
        size -= 1;
        return item;
    }

    public static void main (String[] args) {

        // client to test CLL
        CircularLinkedList<String> list = new CircularLinkedList<String>();
        list.addToFront("turtle");
        list.addToFront("owl");
        list.addToFront("dog");
        list.addToFront("cat");
        list.traverse();
        list.removeFront();
        list.traverse();

        CircularLinkedList<Integer> intLL = new CircularLinkedList<Integer>();
        intLL.addToFront(7);
        intLL.addToFront(5);
        intLL.addToFront(4);
        intLL.traverse();
    }
}
