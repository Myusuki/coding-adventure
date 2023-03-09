#include <stdio.h>

int main()
{
	long dollarAmount = 0;
	printf( "Enter a dollar amount: $ " );
	scanf( "%li", &dollarAmount );

	long fiftiesNeeded = dollarAmount / 50;
	printf( "$50 bills: %li\n", fiftiesNeeded );
	dollarAmount -= fiftiesNeeded * 50;

	long twentiesNeeded = dollarAmount / 20;
	printf( "$20 bills: %li\n", twentiesNeeded );
	dollarAmount -= twentiesNeeded * 20;

	long tensNeeded = dollarAmount / 10;
	printf( "$10 bills: %li\n", tensNeeded );
	dollarAmount -= tensNeeded * 10;

	long fivesNeeded = dollarAmount / 5;
	printf( "$5 bills: %li\n", fivesNeeded );
	dollarAmount -= fivesNeeded * 5;

	long singlesNeeded = dollarAmount / 1; 
	printf( "$1 bills: %li\n", singlesNeeded );
	dollarAmount -= singlesNeeded * 1;
	return 0;
}
