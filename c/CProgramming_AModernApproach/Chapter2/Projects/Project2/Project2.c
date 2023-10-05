#include <stdio.h>

int main()
{
	float radius = 10, volume = (4.0f/3.0f) * 3.14 * (radius * radius * radius);

	printf( "Volume of a 10-meter radius sphere: %f\n", volume );
	
	return 0;
}
