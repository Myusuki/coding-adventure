#include <stdio.h>

int main()
{
	int dollar_amount = 0;
	printf( "Enter a dollar amount: " );
	scanf( "%d", &dollar_amount );

	int twenties = dollar_amount / 20;
	dollar_amount -= twenties * 20;
	printf( "$20 bills: %d\n", twenties );

	int tens = dollar_amount / 10;
	dollar_amount -= tens * 10;
	printf( "$10 bills: %d\n", tens );

	int fives = dollar_amount / 5;
	dollar_amount -= fives * 5;
	printf( "$5 bills: %d\n", fives );

	int singles = dollar_amount / 1;
	dollar_amount -= singles * 1;
	printf( "$1 bills: %d\n", singles );

	return 0;
}
