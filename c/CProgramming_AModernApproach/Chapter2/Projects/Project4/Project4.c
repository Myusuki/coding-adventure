#include <stdio.h>

int main()
{
	float amount = 0;
	printf( "Enter an amount: " );
	scanf( "%f", &amount );

	float amount_w_tax = amount * 1.05;
	printf( "Amount after 5%% tax: %.2f\n", amount_w_tax );
	return 0;
}
