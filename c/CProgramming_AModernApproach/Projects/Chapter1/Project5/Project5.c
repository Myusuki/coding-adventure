#include <stdio.h>

int main()
{
	long x;
	printf( "Enter a value for x: " );
	scanf( "%li", &x );

	long polynomialYValue = (3 * (x * x * x * x *x) ) + (2 * (x * x * x * x) ) - (5 * (x * x * x) ) - (x * x) + (7 * x) - 6; 
	printf( "%li\n", polynomialYValue );
	return 0;
}
