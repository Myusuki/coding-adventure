#include <stdio.h>

int main()
{
	// using P( 1 + rate/ n ) - payment 
	float loan = 0;
	printf( "Enter amount of loan: " );
	scanf( "%f", &loan );

	float interestRate = 0;
	printf( "Enter interest rate: " );
	scanf( "%f", &interestRate );

	float monthlyPayment = 0;
	printf( "Enter monthly payment: " );
	scanf( "%f", &monthlyPayment );

	loan *= 1 + ( ( interestRate / 100)/ 12 );
	loan -= monthlyPayment;
	printf( "Balance remaining after first payment: %.2f\n", loan );

	loan *= 1 + ( ( interestRate / 100)/ 12 );
	loan -= monthlyPayment;
	printf( "Balance remaining after second payment: %.2f\n", loan );
	
	loan *= 1 + ( ( interestRate / 100)/ 12 );
	loan -= monthlyPayment;
	printf( "Balance remaining after third payment: %.2f\n", loan );

	return 0;
}
