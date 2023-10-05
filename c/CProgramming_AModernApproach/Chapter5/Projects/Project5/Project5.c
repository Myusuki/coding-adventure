#include <stdio.h>

int main()
{
	float income = 0.0, tax = 0.0;
	printf( "Enter your income amount: " );
	scanf( "%f", &income );

	if( income <= 750 )
		tax = income * .01f;
	else if( income <= 2250 )
		tax = 7.5 + ( income * .02f );
	else if( income <= 3750 )
		tax = 37.5 + ( income * .03f );
	else if( income <= 5250 )
		tax = 82.5 + ( income * .04f );
	else if( income <= 7000 )
		tax = 142.5 + ( income * .05f );
	else 
		tax = 230.0 + ( income * .06f );

	printf( "The amount of tax due: %.2f\n", tax );

	return 0;
}
