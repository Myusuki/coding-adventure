#include <stdio.h>

int main()
{
	float a = 0.0f, b = 0.0f, max = 0.0f;

	do
	{
		printf( "Enter a number: " );
		scanf( "%f", &b );
		
		if( b > a )
		{
			max = b;
			a = b;
		}
		else
			continue;
	} while( b > 0 );

	printf( "The largest number entered was %f\n", max );

	return 0;
}
