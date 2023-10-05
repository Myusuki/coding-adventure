// OOP implementation of an integer linked list
public class IntLL {
    
    private IntNode front; // reference to the first node of the LL

    // running time: O(1) constant
    public IntLL () {
        front = null; // empty linked list
    }

    // Running time: O(1)
    public void addToFront (int item) {

        // 1. create a new node and store item in it
        IntNode node = new IntNode();
        node.item = item;

        // 2. make new node point to the first node of the LL
        node.next = front;

        // 3. update front to point to the new node
        front = node;
    }

    // Running time: ~n => O(n) linear
    // traversing/print the linked list
    public void print () {

        IntNode ptr = front; // ptr refers to the first node of the LL

        while ( ptr != null ) {
            // 100% sure that ptr is pointing to a node
            System.out.print(ptr.item + " -> ");

            // make ptr hop into the next node
            ptr = ptr.next; // counting this operation towards the running time
        }

        // ptr points to null
        System.out.println("\\");
    }

    // Running time (worst-case): inserting after the last item
    // O(n) linear
    // inserts a node containing itemToInsert after node containing target
    public boolean insertAfter (int itemToInsert, int target ) {

        IntNode ptr = front; // starts at the begining of the LL

        // traverse the LL looking for target
        while ( ptr != null && ptr.item != target ) {
            ptr = ptr.next; // count this operation towards the running time
        }

        if ( ptr == null ) {
            // 1. target wasn't found
            return false;
        } else {
            // 2. target was found, insert
            IntNode node = new IntNode();
            node.item = itemToInsert;
            node.next = ptr.next; // new node pointing to the node after ptr
            ptr.next = node; // ptr (target) points to the new node
            return true;
        }
    }

    // Running time
    // Best-case: delete the first item O(1)
    // Worst-case: delete the last item ~n: O(n) linear
    public boolean delete (int itemToDelete) {

        IntNode ptr = front;
        IntNode prev = null;

        // traverse the ll
        while ( ptr != null && ptr.item != itemToDelete ) {
            prev = ptr;
            ptr = ptr.next; // count this operation towards the running time
        }
        if ( ptr == null ) {
            // itemToDelete not found
            return false;
        } else if ( ptr == front ) {
            // itemToDelete is the first node of the LL
            front = front.next; // removes the first node
        } else {
            prev.next = ptr.next;
        }
        return true;
    }

    // client to test the linked list object functionalities
    public static void main (String[] args) {
        // instatiate a linked list object
        IntLL ll = new IntLL();

        ll.addToFront(3);
        ll.addToFront(6);
        ll.addToFront(12);
        ll.addToFront(48);
        ll.addToFront(96);

        ll.print();

        ll.insertAfter(24,48);
        ll.print();

        // Create a LL with 3 nodes: node3->node2->node1
        // IntNode node1 = new IntNode();
        // node1.item = 3;
        // node1.next = null;

        // ll.front = node1;

        // IntNode node2 = new IntNode();
        // node2.item = 6;
        // node2.next = node1;

        // ll.front = node2;

        // IntNode node3 = new IntNode();
        // node3.item = 12;
        // node3.next = node2; // or node3.next = ll.front;

        // ll.front = node3;
    }
}
