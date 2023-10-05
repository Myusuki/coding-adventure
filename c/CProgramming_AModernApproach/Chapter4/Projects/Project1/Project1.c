#include <stdio.h>

int main()
{
	int num = 0;
	printf( "Enter a two-digit number: " );
	scanf( "%d", &num );

	int num1 = 0, num2 = 0;
	num1 = num / 10;
	num2 = num % 10;

	printf( "The reversal is: %d%d\n", num2, num1 );

	return 0;
}
