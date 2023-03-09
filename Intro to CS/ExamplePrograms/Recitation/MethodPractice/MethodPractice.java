public class MethodPractice
{
	public static void main( String[] args )
	{
		double num = Double.parseDouble( args[ 0 ] );
		System.out.println( IsAPowerOfThree( num ) );
	}
	public static boolean IsAPowerOfThree( double n )
	{
		if( n == 0 )
		{
			return false;
		}
		while( n != 1 )
		{
			if( n % 3 != 0 )
			{
				return false;
			}
			n = n / 3;
		}
		return true;
	}
}
