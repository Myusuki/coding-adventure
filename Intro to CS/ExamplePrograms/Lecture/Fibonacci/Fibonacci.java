public class Fibonacci
{
	public static void main( String[] args )
	{
		int num = Integer.parseInt( args[ 0 ] );
		System.out.println( fibonacci( num ) );
	}

	public static int fibonacci( int n )
	{
		if( n == 1 || n == 2 )
		{
			return 1;
		}
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
}
