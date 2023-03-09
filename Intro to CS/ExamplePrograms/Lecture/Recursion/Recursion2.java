public class Recursion2
{
	public static void main( String[] args )
	{
		int[] a = { 23, 4, 7, 9, 1, 17 };
		printArrayR( a, 0 );
		System.out.println();
		System.out.println( "The sum is: " + sumArrayR( a, a.length ) );
		System.out.println( "The smallest is: " + minArrayR( a, a.length ) );
	}
	public static void printArrayR( int x[], int index )
	{
		if( index > ( x.length - 1 ) )
		{
			return;
		}
		System.out.print( x[ index ] + " " );
		printArrayR( x, index += 1 );
	}
	public static int sumArrayR( int[] x, int index )
	{
		if( index == 0 )
			return 0;
		else
			return x[ index - 1 ] + sumArrayR(x, index -= 1 );
	}
	public static int minArrayR( int[] x, int index )
	{
		if( index == 1 )
			return x[ 0 ];
		return Math.min( x[ index - 1 ], minArrayR( x, index - 1 ) );
	}
}
