#include <stdio.h>

int main()
{
	int n = 0, denom = 1;
	float e = 1.0f;

	printf( "Enter a whole number: " );
	scanf( "%d", &n );

	for( int i = 1; i <= n; i++ )
	{
		e += 1.0f / (denom *= i);
	}

	printf( "Approximation of e: %f\n", e );
	return 0;
}
