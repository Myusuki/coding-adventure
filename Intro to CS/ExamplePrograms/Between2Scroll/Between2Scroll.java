public class Between2Scroll
{
	public static void main( String[] args )
	{
		int num1 = Integer.parseInt( args[ 0 ] );
		int num2 = Integer.parseInt( args[ 1 ] );

		for( int i = 2; i < args.length; i++ )
		{
			if( Integer.parseInt( args[ i ] ) > num1 && Integer.parseInt( args[ i ] ) < num2 || Integer.parseInt( args[ i ] ) < num1 && Integer.parseInt( args[ i ] ) > num2 )
			{
				System.out.print( args[ i ] + " ");
			}
		}
		System.out.println();
	}
}
