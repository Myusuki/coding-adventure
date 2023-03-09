/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:
 *
 *************************************************************************/

public class PolygonTransform {


	// Returns a new array that is an exact copy of the given array. 
	// The given array is not mutated. 
	public static double[] copy(double[] array) {

// WRITE YOUR CODE HERE
		double[] arrayCopy = new double[ array.length ];
		int i = 0;
		for( double x: array )
		{
			arrayCopy[ i ] = x;
			i++;
		}
		return arrayCopy;
	}
	
	// Scales the given polygon by the factor alpha. 
  public static void scale(double[] x, double[] y, double alpha) {

	// WRITE YOUR CODE HERE
		for( int i = 0; i < x.length; i++ )
		{
			x[ i ] *= alpha;
		}
		for( int j = 0; j < y.length; j++ )
		{
			y[ j ] *= alpha;
		}
	}
    
  // Translates the given polygon by (dx, dy). 
  public static void translate(double[] x, double[] y, double dx, double dy) {

	// WRITE YOUR CODE HERE
  	for( int i = 0; i < x.length; i++ )
		{
			x[ i ] += dx; 
		}
		for( int j = 0; j < y.length; j++ )
		{
			y[ j ] += dy;
		}
	}
/*    
  // Rotates the given polygon theta degrees counterclockwise, about the origin. 
  public static void rotate(double[] x, double[] y, double theta) {

	// WRITE YOUR CODE HERE
  }
*/
    // Tests each of the API methods by directly calling them. 
  public static void main(String[] args) {
		StdDraw.setScale(-5.0, +5.0); 
		double[] x = { 0, 1, 1, 0 }; 
		double[] y = { 0, 0, 2, 1 }; 
		double dx = 2.0, dy = 1.0; 
		StdDraw.setPenColor(StdDraw.RED); 
		StdDraw.polygon(x, y); 
		translate(x, y, dx, dy); 
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.polygon(x, y);
	}
}
