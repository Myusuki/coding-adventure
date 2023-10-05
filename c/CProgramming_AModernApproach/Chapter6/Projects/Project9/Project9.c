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

	int timesPaid = 0;
	printf( "Enter how many times you've paid: " );
	scanf( "%d", &timesPaid );

	while( timesPaid > 0 )
	{
		float payment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
		if( timesPaid % 10 == 1 )
			printf( "Balance remaining after %d st payment: %f\n", timesPaid, payment );
		else if( timesPaid % 10 == 2 )
			printf( "Balance remaining after %d nd payment: %f\n", timesPaid, payment);
		else if( timesPaid % 10 == 3 )
			printf( "Balance remaining after %d rd payment: %f\n", timesPaid, payment);
		else
			printf( "Balance remaining after %d rd payment: %f\n", timesPaid, payment);
		loanAmount = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	}
	// float firstPayment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	// printf( "Balance remaining after first payment: %.2f\n", firstPayment );
	// loanAmount = loanAmount * (1 + monthlyInterest) - monthlyPayment;

	// float secondPayment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	// printf( "Balance remaining after second payment: %.2f\n", secondPayment );
	// loanAmount = loanAmount * (1 + monthlyInterest) - monthlyPayment;

	// float thirdPayment = loanAmount * (1 + monthlyInterest) - monthlyPayment;
	// printf( "Balance remaining after third payment: %.2f\n", thirdPayment );

	return 0;
}
