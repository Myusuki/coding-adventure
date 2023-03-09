/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author:
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {

			// WRITE YOUR CODE HERE
			long num = Long.parseLong( args[0] );
			int numB = 0;
			int numC = 0;

			for( int i = 1; i <= 13; i++ )
			{
				long numA = num % 10;

				if( i % 2 != 0 )
				{
					numB += numA;
				}
				else 
				{
					numC += numA;
				}

				num /= 10;
			}

			numB %= 10;
			numC = ((numC % 10) * 3) % 10;

			System.out.println( (numB + numC) % 10 );

    }
}
