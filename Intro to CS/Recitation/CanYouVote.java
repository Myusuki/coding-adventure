public class CanYouVote
{
	public static void main( String[] args )
	{
		double age = Double.parseDouble( args[ 0 ] );
		boolean UScitizen = Boolean.parseBoolean( args[ 1 ] );

		if( age >= 18 && UScitizen == true )
		{
			System.out.println( "You are of age and a US citizen! You're allowed to vote" );
		}
		else if( age >= 18 && UScitizen == false )
		{
			System.out.println( "You aren't an US citizen! You aren't allowed to vote!" );
		}
		else if( age < 18 && UScitizen == true )
		{
			System.out.println( "You are not of voting age! You aren't allowed to vote!" );
		}
		else if( age < 18 && UScitizen == false ) 
		{
			System.out.println( " You are not of age and not a US citizen! You aren't allowed to vote!" );
		}

	}
}
