#include <stdio.h>

/*print Farenheit-Celsius table 
for fahr = 0, 20, ..., 300; floating point version
*/
main()
{
	float fahr, celsius;
	float lower, upper, step;

	lower = 0; /* lower limit of temperature scale */
	upper = 300; /* upper limit */
	step = 20; /* step size */

	printf( "Celsius \tFahrenheit\n" );
	celsius = lower;
	while( celsius <= upper )
	{
		fahr = celsius * ( 5.0 / 5.0 ) + 32;
		printf( "%5.0f %18.1f\n", celsius, fahr );
		celsius = celsius + step;
	}
}
