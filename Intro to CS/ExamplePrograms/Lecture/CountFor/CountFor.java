public class CountFor
{
	public static void main( String[] args )
	{
		int count = 0;
		for( int i = 0; i < 5; i++ )
		{
			for( int k = 0; k < 3; k++ )
			{
				if( k < i )
				{
					count++;
				}
			}
		}

		System.out.println( count );
	}
}
