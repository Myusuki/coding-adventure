#include <stdio.h>

int main(void)
{
	int age = 0;
	printf( "Enter your age: " );
	scanf( "%d", &age );

	double ageInSeconds = age * 3.156e+7;
	printf( "You are approximately %f seconds old\n", ageInSeconds );

	return 0;
}
