public class GuessingGame
{
	public static void main( String[] args )
	{
		int randoNum = ( int )(Math.random() * 1000 + 1);
		int guess = 0;
		do 
		{
			StdOut.print( "Enter a number from 1 - 1000: " );
			guess = StdIn.readInt();

			if( guess > randoNum )
			{
				StdOut.println( "Your guess is too big! Try again!" );
			}
			else if( guess < randoNum )
			{
				StdOut.println( "Your guess is too small! Try again!" );
			}
		} while( guess != randoNum );

		StdOut.println( "Congrats! You've guessed the number!" );
	}
}
