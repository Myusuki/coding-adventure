public class Recursion
{
	public static void main( String[] args )
	{
		long num = Long.parseLong( args[ 0 ], 100 );
		System.out.println( factorial( num ) );
	}

	public static long factorial( long n )
	{
		if( n == 0 )
			return 1;
		else
			return n * factorial( n - 1 );
	}
}
