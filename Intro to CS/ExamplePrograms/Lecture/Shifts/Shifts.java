public class Shifts
{
	public static void main( String[] args )
	{
		int[] a = { 2, 5, 3, 8, 6 };
		PrintArray( a );
		
		System.out.println( "Shift right" );
		int temp = a[ a.length - 1 ];
		for( int i = a.length - 1; i > 0; i-- )
		{
			a[ i ] = a[ i - 1];
		}
		a[ 0 ] = temp;
		PrintArray( a );

		temp = a[ 0 ];
		System.out.println( "Shift left" );
		for( int i = 0; i < a.length - 1; i++ )
		{
			a[ i ] = a[ i + 1 ];
		}
		a[ a.length - 1 ] = temp;
		PrintArray( a );

	}

	public static void PrintArray( int[] arr )
	{
		for( int x: arr )
		{
			System.out.print( x + " " );
		}
		System.out.println();
	}

}
