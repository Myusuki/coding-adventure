#include <stdio.h>

int main()
{
	int hour = 0, minute = 0;
	printf( "Enter a 24-hour time: " );
	scanf( "%2d:%2d", &hour, &minute );

	if( hour > 12 && hour < 24 )
	{
		hour -= 12;
		printf( "Equivalent 12-hour time: %2d:%2d PM", hour, minute );
	}
	else if( hour == 24 )
		printf( "Equivalent 12-hour time: 12:%2d AM\n", minute );
	else if( hour == 12 )
		printf( "Equivalent 12-hour time: 12:%2d PM\n", minute );
	else
	{
		printf( "Equivalent 12-hour time: %2d:%2d AM", hour, minute );
	}
	return 0;
}
