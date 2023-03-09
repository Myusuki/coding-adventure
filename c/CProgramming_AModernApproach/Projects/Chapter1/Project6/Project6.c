#include <stdio.h>

int main()
{
	long x;
	printf( "Enter a value for x: ");
	scanf( "%li", &x );

	long polynomialYvalue = ((((3 * x + 2) * x + 5) * x - 1 ) * x + 7) * x - 6;
	printf( "%li\n", polynomialYvalue );
	return 0;
}
