#include <stdio.h>

int main()
{
	printf( "Enter a number between 0 and 32767: " );
	int num = 0;
	scanf( "%d", &num );
	int num1 = num % 8;
	num /= 8;
	int num2 = num % 8;
	num /= 8;
	int num3 = num % 8;
	num /= 8;
	int num4 = num % 8;
	num /= 8;
	int num5 = num % 8;
	printf( "In octal, your number is: %d%d%d%d%d\n", num5, num4, num3, num2, num1 );

	return 0;
}
