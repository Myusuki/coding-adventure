import java.awt.Color;

/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:
 *
 *************************************************************************/

public class Sierpinski {

	// Height of an equilateral triangle whose sides are of the specified length. 
	public static double height(double length) {

// WRITE YOUR CODE HERE
		return ( Math.sqrt( 3 ) * length )/ 2;
	}

	// Draws a filled equilateral triangle whose bottom vertex is (x, y) 
	// of the specified side length. 
	public static void filledTriangle(double x, double y, double length) {

// WRITE YOUR CODE HERE
		double h = height( length );
		double[] xCoordinates = { x, ( x - (length/ 2) ), ( x + (length/ 2) ) };
		double[] yCoordinates = { y, (y + h), (y + h) };

		StdDraw.filledPolygon( xCoordinates, yCoordinates );
	}

	// Draws a Sierpinski triangle of order n, such that the largest filled 
	// triangle has bottom vertex (x, y) and sides of the specified length. 
	public static void sierpinski(int n, double x, double y, double length) {

// WRITE YOUR CODE HERE
		if( n == 0 )
			return;
		else
		{
			filledTriangle(x, y, length);
			sierpinski(n-1, x, y + height( length ), length/ 2);
			sierpinski( n-1, x - (length/ 2.0), y, length/ 2);
			sierpinski( n-1, x + (length/ 2.0), y, length/ 2);
		}
	}

	// Takes an integer command-line argument n; 
	// draws the outline of an equilateral triangle (pointed upwards) of length 1; 
	// whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
	// draws a Sierpinski triangle of order n that fits snugly inside the outline. 
	public static void main(String[] args) {

// WRITE YOUR CODE HERE 
		StdDraw.setPenColor( Color.BLACK );
		sierpinski( 1, 2.0, 0.0, 4.0 );
	}
}
