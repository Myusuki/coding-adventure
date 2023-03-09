public class Recursion
{
	public static void main( String[] args )
	{
		convert( 100 );
		System.out.println();
		System.out.println( gcd( 3388, 436 ) );
	}
	
	public static void convert( int n )
	{
		int quotient = n / 2;
		int remainder = n % 2;
		if( n > 1 )
		{
			convert( quotient );
		}
		System.out.print( remainder );
	}

	public static int gcd( int num1, int num2 )
	{
		if( num2 == 0 )
		{
			return num1;
		}
		int remainder = num1 % num2;
		return ( gcd( num2, remainder ) );
	}

}
