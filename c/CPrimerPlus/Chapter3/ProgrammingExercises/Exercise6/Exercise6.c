#include <stdio.h>

int main(void)
{
	double quart = 0;
	double quartToGrams = 950;
	double moleculeToGrams = 3.0e-23;

	printf( "Enter the amount of water (in quarts): " );
	scanf( "%lf", &quart );

	double amountOfMolecules = (quart * quartToGrams) / moleculeToGrams;

	printf( "There are approximately %f molecules in %f quarts of water.\n", amountOfMolecules, quart );

	return 0;
}
