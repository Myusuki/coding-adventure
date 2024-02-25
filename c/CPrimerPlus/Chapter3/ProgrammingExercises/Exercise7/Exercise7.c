#include <stdio.h>

int main(void)
{
	double inches = 0, centimeters = 0;
	printf( "How many inches would you like to convert to centimeters: " );
	scanf( "%lf", &inches );

	centimeters = 2.54 * inches;
	printf( "%f inches is %f centimeters.\n", inches, centimeters );

	return 0;
}
