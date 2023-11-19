import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {

    /*
     * Searches for @target at array @a from indices [lo, hi)
     * Returns the index of @target of -1 is not found.
     */
    public static int iterative (Integer target, Integer [] a) 
    {
        //System.out.print(indent + "search("+key+",a,"+lo+","+hi+"); ");
        int hi = a.length; // hi is not included in the search
        int lo = 0;
        String indent = "";

        while (hi > lo) {
   
            int mid = lo + (hi - lo) / 2;
            System.out.println(indent + "(" + lo + "," + mid + "," + hi + ")");
            
            // compareTo returns < 0 if a[mid]<target, >0 if a[mid]>target, =0 if a[mid]==target
            int cmp = a[mid].compareTo(target); // count this comparison (one array access)

            if (cmp == 0 ){
                System.out.println(indent+"found at: " + mid);
                return mid;
            } else if (cmp > 0) {
                hi = mid; // target is smaller than a[mid]
                indent += "\t";
            } else {
                lo = mid + 1; // target is greater than a[mid]
                indent += "\t";
            } 
        }
        return -1; // target not found
    }

    /*
     * Searches for @target at array @a from indices [lo, hi)
     * Returns the index of @target of -1 is not found.
     */
    public static int recursive (Integer target, Integer [] a, int lo, int hi, String indent) 
    {
        System.out.print(indent + "search("+target+",a,"+lo+","+hi+"); ");
        if (hi <= lo) return -1; // key is not present in array a
   
        int mid = lo + (hi - lo) / 2;
        System.out.println(indent + "(" + lo + "," + mid + "," + hi + ")");
        
        int cmp = a[mid].compareTo(target); // count this comparison (one array access) OR the number of calls to the method

        if (cmp == 0 ){
            System.out.println(indent+"found at: " + mid);
	        return mid;
        } else if (cmp > 0) {
            // target is smaller than a[mid]
            return recursive(target, a, lo, mid, indent+"\t");
        } else {
            // target is greater than a[mid]
            return recursive(target, a, mid+1, hi, indent+"\t");
        } 
    }

    public static void main (String[] args) {

        //Integer[] array = {3,5,9,12,15,17};
        Integer[] array = {7,11,19,26,31,33,40,42,47,54};
        System.out.print("Enter target key: ");
        int key = StdIn.readInt();
        recursive(key, array, 0, array.length,"");
        //iterative(key, array);
    }
}
