public class Lefties
{
	public static void main( String[] args )
	{
		int trialCount = 0;
		for( int trial = 1; trial < 100; trial++ )
		{
			int personCount = 0;
			for( int person = 1; person < 20; person++ )
			{
				int lefty = ( int )(Math.random() * 10 + 1);
				if( lefty == 7 )
				{
					personCount++;
				}
			}
			if( personCount >= 2 )
			{
				trialCount++;
			}
		}
		System.out.println( "Trials containing 2 or more lefties is: " + trialCount );
	}
}
