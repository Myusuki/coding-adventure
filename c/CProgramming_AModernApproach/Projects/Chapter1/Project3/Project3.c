#include <stdio.h>
#include <math.h>

int main()
{
	double radius;
	printf( "Enter a radius: " ); 
	scanf( "%lf", &radius );
	double sphereVolume = (4.0f/ 3.0f) * M_PI * radius * radius * radius;

	printf( "%lf\n", sphereVolume );
	return 0;
}
