import org.w3c.dom.Node;

public class LLInsertAfter {
    public insertAfter( Node head, int target, int newValue )
    {
        while( head.item != null )
        {
            if( head.item != target )
                head.next;
            else if( head.item == target )
                head.item = newValue;
            
        }

    }
   public static void main(String[] args) {
    
   } 
}
