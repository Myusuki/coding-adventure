/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author:
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {

    public static void main (String[] args) {

        // WRITE YOUR CODE HERE
				int num1 = Integer.parseInt( args[0] );
				int num2 = Integer.parseInt( args[1] );
				int num3 = Integer.parseInt( args[2] );
				int num4 = Integer.parseInt( args[3] );
				int num5 = Integer.parseInt( args[4] );

				if( num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5 )
				{
					System.out.println( num1 );
				}
				if( num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5 )
				{
					System.out.println( num2 );
				}
				if( num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5 )
				{
					System.out.println( num3 );
				}
				if( num4 > num1 && num4 > num2 && num4 > num3 && num4 > num5 )
				{
					System.out.println( num4 );
				}
				else
				{
					System.out.println( num5 );
				}
    }
}
