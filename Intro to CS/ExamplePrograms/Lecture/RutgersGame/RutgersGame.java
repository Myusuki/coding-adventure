public class RutgersGame
{
	public static void main( String[] args )
	{
		int nbrFriends = args.length;
		int sum = 0;
		int i = 0;

		int totalRatings = nbrFriends;

		while( i < nbrFriends )
		{
			int rating = Integer.parseInt( args [ i ] );
			if( rating < 1 || rating > 5 )
			{
				totalRatings -= 1;
			}
			else 
			{
				sum += rating;
			}

			i++;
		}

		double avg = (sum * 1.0) / totalRatings;
		System.out.println( "The game's ratings average is: " + avg);
	}
}
