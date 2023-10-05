#include <stdio.h>

int main()
{
	float loanAmount = 0;
	printf( "Enter amount of loan: " );
	scanf( "%f", &loanAmount );

	float interest = 0;
	printf( "Enter interest rate: " );
	scanf( "%f", &interest );

	float monthlyPayment = 0;
	printf( "Enter monthly payment: " );
	scanf( "%f", &monthlyPayment );

	float monthlyInterest = (interest / 100) / 12;

	float firstPayment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	printf( "Balance remaining after first payment: %.2f\n", firstPayment );
	loanAmount = loanAmount * (1 + monthlyInterest) - monthlyPayment;

	float secondPayment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	printf( "Balance remaining after second payment: %.2f\n", secondPayment );
	loanAmount = loanAmount * (1 + monthlyInterest) - monthlyPayment;

	float thirdPayment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	printf( "Balance remaining after third payment: %.2f\n", thirdPayment );
	loanAmount = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	
	return 0;
}
