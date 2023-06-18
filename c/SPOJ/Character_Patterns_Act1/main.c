#include <stdio.h>

int main()
{
	int testCaseNum = 0;
	scanf( "%d", &testCaseNum );

	int row = 0, column = 0;
	int input[ testCaseNum ][ 2 ];
	for( int i = 0; i < testCaseNum; i++ )
	{
		scanf( "%d %d", &row, &column );
		input[ i ][ 0 ] = row;
		input[ i ][ 1 ] = column;
	}

	for( int i = 0; i < testCaseNum; i++ )
	{
		int counter = 1;
		for( int boardRow = 1; boardRow <= input[ i ][ 0 ]; boardRow++ )
		{
			for( int boardColumn = 1; boardColumn <= input[ i ][ 1 ]; boardColumn++ )
			{
				if( counter % 2 != 0 )
				{
					printf( "*" );
					counter++;
				}

				else
				{
					if( counter % 2 == 0 )
					{
						printf( "." );
						if( boardColumn == input[ i ][ 1 ] )
						{
							continue;
						}
						else 
						{
							counter++;
						}
					}
				}
			}
			printf( "\n" ); 
		}
		printf( "\n" );
	}

	return 0;
}
