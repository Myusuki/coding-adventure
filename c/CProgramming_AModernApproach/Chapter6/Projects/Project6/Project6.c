#include <stdio.h>

int main()
{
	int num = 0, squareResult = 0;

	printf( "Enter a number: " );
	scanf( "%d", &num );

	for( int evenBase = 2; squareResult < num; evenBase += 2 )
	{
	 	squareResult = evenBase * evenBase;
		printf( "%d\n", squareResult );
	}

	return 0;
}
