import java.util.ArrayList;

public class AL 
{
	public static void main( String[] args )
	{
		ArrayList<String> names = new ArrayList<String>();
		while( !StdIn.isEmpty() )
		{
			String s = StdIn.readString();
			names.add(s);
		}
		StdOut.println( names );

		for( String s: names )
		{
			if( s.charAt( 0 ) == 'd' || s.charAt( 0 ) == 'D' )
			{
				StdOut.print( s + " " );
			}
		}
		StdOut.println();

		for( int i = names.size() - 1; i >= 0; i-- )
		{
			String s = names.get( i );
			if( s.length() < 5 )
			{
				names.remove( i );
			}
		}
		StdOut.println( names );
		names.add( 2, "Xena" );
		StdOut.println( names );
		// StdOut.println();
		/*
		for( String s: names )
		{
			StdOut.print( s + " " );
		}
		StdOut.println();

		for( int i = 0; i < names.size(); i++ )
		{
			StdOut.print( names.get(i) + " " );
		}
		StdOut.println();
		*/
	}
}
