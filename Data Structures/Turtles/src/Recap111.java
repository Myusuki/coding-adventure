public class Recap111 {
    
    public static void main (String[] args) {

        // there are two types of variables: 
        
        // (1) variables that hold primitive data types
        int intValue = 4;
        char charValue = 'a';
        
        // (2) variables that hold references to objects
        // arrays in Java are objects
        int[] intArray = new int[4]; // intArray is a reference to an array of 4 integers
        intArray[3] = 121;
        System.out.println(intArray[3]);

        // Instatiate 1 object of type Turtle
        Turtle turtle1 = new Turtle();
        System.out.println( turtle1.getAngle() );

    }
}
