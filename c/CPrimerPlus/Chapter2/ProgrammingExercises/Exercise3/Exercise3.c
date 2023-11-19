#include <stdio.h>

int main(void)
{
	int ageYears = 0;
	int ageDays = 0;

	printf( "Enter your age( in years ): " );
	scanf( "%d", &ageYears );
	ageDays = ageYears * 365;

	printf( "You are %d days old\n", ageDays );
	
	return 0;
}
