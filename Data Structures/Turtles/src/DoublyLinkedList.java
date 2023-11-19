// Generic class, handles any data type
public class DoublyLinkedList<T> {

    // inner class private to DoublyLinkedList class
    private class Node<T> {
        // instance variable of the Node class
        T       item;     // data
        Node<T> previous; // referes to previous node
        Node<T> next;     // refers to next node
    }

    // instance variables of the DoublyLinkedList (DLL) class
    Node<T> front;
    int size;

    // initializes the DLL
    DoublyLinkedList (){
        front = null;
        size = 0;
    }

    public boolean isEmpty () {
        return front == null;
    }

    public void addToFront (T item) {

        // create new node
        Node<T> newNode = new Node<T>();
        newNode.item = item;
        newNode.next = front; // the front might be null

        if ( !isEmpty() ) {
            // list is NOT empty
            front.previous = newNode;
        }
        // update the front
        front = newNode;

        size += 1;
    }
    public void traversal () {
        Node<T> ptr = front;
        System.out.print("\\ <-");
        while ( ptr != null ) {
            System.out.print(ptr.item + " <->");
            ptr = ptr.next;
        }
        System.out.println("\\");
    }

    public boolean insertAfter (T item, T target) {

        // find target
        Node<T> ptr = front;
        while ( ptr != null && !ptr.item.equals(target) ) {
            ptr = ptr.next;
        }

        if ( ptr == null ) {
            // target not found
            return false;
        }

        // create node
        Node<T> newNode = new Node<T>();
        newNode.item = item;
        newNode.next = ptr.next;
        newNode.previous = ptr;
        ptr.next = newNode;

        if ( newNode.next != null ) {
            // newNode is not the last item
            newNode.next.previous = newNode;
        }
        size += 1;
        return true;
    }
    
    public static void main (String[] args) {

        DoublyLinkedList<String> dllSongs = new DoublyLinkedList<>();
        dllSongs.addToFront("Ocean man");
        dllSongs.addToFront("Never gonna give you up");
        dllSongs.addToFront("Billy Jean");
        dllSongs.addToFront("Under the sea");

        dllSongs.traversal();
        dllSongs.insertAfter("Sicko mode", "Billy Jean");
        dllSongs.traversal();
    }
}