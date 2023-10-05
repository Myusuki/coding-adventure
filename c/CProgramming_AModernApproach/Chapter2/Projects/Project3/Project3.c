#include <stdio.h>

int main()
{
	float radius;
	printf( "Enter a radius: " );
	scanf( "%f", &radius );

	float volume = 4.0f/3.0f * 3.14 * radius * radius * radius;
	printf( "The volume is: %f\n", volume );

	return 0;
}
