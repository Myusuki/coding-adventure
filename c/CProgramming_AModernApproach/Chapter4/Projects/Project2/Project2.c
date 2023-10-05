#include <stdio.h>

int main()
{
	int num = 0;
	printf( "Enter a three-digit number: " );
	scanf( "%d", &num );

	int num1 = 0, num2 = 0, num3 = 0;
	num1 = num / 100;
	num2 = (num % 100) / 10;
	num3 = num % 10;
	printf( "The reversal is: %d%d%d\n", num3, num2, num1 );

	return 0;
}
