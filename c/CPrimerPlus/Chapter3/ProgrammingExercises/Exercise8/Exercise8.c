#include <stdio.h>

int main(void)
{
	double cups = 0, cupToPint= 2, ouncesToCup= 8, tablespnToOunce = 2, teaspnToTablespn = 3;

	printf( "How many cups are there: " );
	scanf( "%lf", &cups );

	printf( "That is %f pint(s)\n", cups / cupToPint );
	printf( "That is %f ounce(s)\n", cups * ouncesToCup );
	printf( "That is %f tablespoon(s)\n", cups * ouncesToCup * tablespnToOunce );
	printf( "That is %f teaspoon(s)\n", cups * ouncesToCup * tablespnToOunce * teaspnToTablespn );

	return 0;
}
