#include <stdio.h>

int main()
{
	printf( "Enter an amount: " );
	
	double amount = 0;
	scanf( "%lf", &amount );

	double amountWTax = (amount * .05) + amount;
	printf( "With tax added: %lf\n", amountWTax );

	return 0;
}
