public class LoopCount
{
	public static void main( String[] args )
	{
		int loopCount = Integer.parseInt( args[ 0 ] );

		for( int i = 1; i <= loopCount; i++ )
		{
			System.out.print( i + ", " );
		}
	}
}
