import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DrunkenTurtles {
    
    // client program
    public static void main (String[] args) {

        StdOut.print("Enter the sanctuary number of turtles: ");
        int numberOfTurtles = StdIn.readInt();

        StdOut.print("Enter the number of steps for the turtles take: ");
        int numberOfSteps = StdIn.readInt();

        StdOut.print("Enter the step size for the turtles (all turtle are of the same size): ");
        double stepSize = StdIn.readDouble();

        // allocate enough space to hold all numberOfTurtles turtles
        // allocates the array to hold numberOfTurtles
        Turtle[] turtles = new Turtle[numberOfTurtles];

        // instantiate the turtles object
        // each turtle is one object, each turtle is in one array index
	    // Running time
	    //     tilde notation: ~t
	    //     big O notation: O(t)
        for ( int i = 0; i < turtles.length; i++ ) {
            
            // position
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);

            // color
            int red = StdRandom.uniform(256);
            int green = StdRandom.uniform(256); // [0,255]
            int blue = StdRandom.uniform(256);
            Color color = new Color(red,green,blue); // instantiate a Color object

            // instantiate the turtle object - object of type Turtle
            turtles[i] = new Turtle(x,y,0.0,color);
        }

        StdDraw.setXscale(-1, 5);
        StdDraw.setYscale(-1, 5);

    // make each turtle take ONE step at a time for a total of numberOfSteps
	// Running time
	//     tilde notation: f(s,t) = s * 2t = ~2ts
	//     big O notation: O(ts)
        for ( int i = 1; i <= numberOfSteps; i++ ) { // s
        
            // traverse the entire array to:
            // 1. make each turtle turn left by a random angle
            // 2. make each turtle take 1 step 
            // running time: f(n) = (1 + 1) * t = ~2t
            for ( int j = 0; j < turtles.length; j++ ) { // t

                double angle = StdRandom.uniform(0.0, 361.0);
                turtles[j].turnLeft(angle);       // read
                turtles[j].moveForward(stepSize); // read
            }
        }
    }
}
