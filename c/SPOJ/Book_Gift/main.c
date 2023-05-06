#include <stdio.h>

int main(	)
{
	int testCaseNum = 0;
	scanf( "%d\n", &testCaseNum );

	int books = 0, children = 0;
	int divisible[ testCaseNum ];
	for( int i = 0; i < testCaseNum; i++ )
	{
		scanf( "%d %d", &children, &books );
		if( books % children == 0 )
		{
			divisible[ i ] = 1;
		}
		else
		{
			divisible[ i ] = 0;
		} 
	}
	for( int i = 0; i < testCaseNum; i++ )
	{
		if( divisible[ i ] == 1 )
		{
			printf( "YES\n" );
		}
		else 
		{
			printf( "NO\n" );
		}

	} 

	return 0;
}
