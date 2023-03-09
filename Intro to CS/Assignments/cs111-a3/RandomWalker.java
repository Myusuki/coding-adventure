/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author:
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
			int coordinateCounter = Integer.parseInt( args[0] );
			int xValue = 0;
			int yValue = 0;
			System.out.println( "(" + xValue + "," + yValue + ")" );

			for( int i = 0; i <= coordinateCounter; i++ )
			{
				int walkdirection = (int)(Math.random() * 4) + 1;

				if( walkdirection == 1 )
				{
					xValue++;
				}
				else if( walkdirection == 2 )
				{
					yValue++;
				}
				else if( walkdirection == 3 )
				{
					xValue--;
				}
				else 
				{
					yValue--;
				}
				System.out.println( "(" + xValue + "," + yValue + ")" );
			}
			System.out.println( "Squared distance = " + ( Math.pow(xValue, 2) + Math.pow(yValue, 2) ) );
    }
}
