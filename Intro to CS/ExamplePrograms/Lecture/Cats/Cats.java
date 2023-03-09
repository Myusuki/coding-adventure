public class Cats
{
	public static void main( String[] args )
	{
		int anasCats = Integer.parseInt( args[ 0 ] );
		int ellensCats = Integer.parseInt( args[ 1 ] );

		if( ellensCats < 0 || anasCats < 0 )
		{
			System.out.println( "Error: Invalid amount of cats!" );
		}
		else
		{
			int totalCats = ellensCats + anasCats;
			System.out.println( "Total number of cats is: " + totalCats );
		}
	}
}
