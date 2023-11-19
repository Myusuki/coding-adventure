// Generic implementation of a BST
// K is the data type for the key
// V is the data type for the value 
// Interafce in java has methods that whichever class extends it 
// will be obligated to implement those methods
//
// Comparable interface has one methods - compareTo

public class BST<K extends Comparable<K>, V>
{
	private class Node
	{
		K key;
		V value; 
		private Node left;
		private Node right;
		public Node( K key, V value )
		{
			this.key = key;
			this.value = value;
		}
	}


	// instance variables of the BST
	private Node root; // root node of the BST
	private int size; // number of items in the BST
	
	// insert the pair <key, value> into the BST 
	// if the key is already present, update value 
	public void put( K key, V value )
	{
		// 1. search for the key 
		Node ptr = root;
		Node prev = null; // prev will be 1 step behind ptr 
		int cmp = 0;
		
		while( ptr != null )
		{
			cmp = key.compareTo(ptr.key);
			if( cmp == 0 )
			{
				// found the key, no duplicates, updates the value for key
				ptr.value = value;
			}
			prev = ptr;

			if( cmp < 0 )
			{
				ptr = ptr.left;	
			}
			else 
			{
				ptr = ptr.right;
			}
		}

		// 2. insert at the failure point 
		Node newNode = new Node( key, value );

		// if BST is empty, ptr and prev are null 
		if( prev == null )
		{
			root = newNode;
		}
		else if( cmp < 0 )
		{
			prev.left = newNode;
		}
		else
		{
			prev.right = newNode;
		}
	}

	// Running time: 
	// Best Case: search for root: O(1);
	// Worst Case: searching for a key at the leaf level (tree might be skewed): O(n)
	public V get(K targetKey)
	{
		Node ptr = root;
		while( ptr != null )
		{
			int cmp = targetKey.compareTo(ptr.key);
			if( cmp == 0 )
			{
				// found it, return the value associated with key
				return ptr.value;
			}
			else if( cmp < 0 )
			{
				// targetKey is smaller than ptr.key
				ptr = ptr.left;
			}
			else 
			{
				// targetKey is larger than ptr.key
				ptr = ptr.right;
			}
		}
		return null;
	}

	public void inorder( Node x, LinkedQueue<K> queue )
	{
		if( x == null )
		{
			return;
		}
		inorder(x.left, queue);
		// print or enqueue
		queue.enqueue(x.key);
		inorder(x.right, queue);
	}

	public static void main(String[] args) {
		BST<String, String> cas = new BST<>();
		cas.put( "js3422", "John Smith" );
		cas.put( "bd45", "Brian David" );
		cas.put( "ef5873", "Ella Fitz" );
		cas.put( "mt7374", "Mary Taylor" );

		System.out.println( cas.get("bd45") );

		// inorder will enqueue the kens in ascending order
		LinkedQueue<String> ascendingOrder = new LinkedQueue<>();
		cas.inorder(cas.root, ascendingOrder);

		// while the queue is not empty, dequeue and print
		while( !ascendingOrder.isEmpty() )
		{
			System.out.println( ascendingOrder.dequeue() );
		}
	}
	
}
