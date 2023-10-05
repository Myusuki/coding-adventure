#include <stdio.h>

int main()
{
	int numOfDays, startingDay, dayCount = 1;

	printf( "Enter number of days in month: " );
	scanf( "%d", &numOfDays );

	printf( "Enter starting day of the week (1=Sun, 7=Sat): " );
	scanf( "%d", &startingDay );

	for( int i = 1; i <= numOfDays; i++ )
	{
		if( i == 1 && startingDay != dayCount )
		{	
			printf( "  " );
			continue;
	 	}
		
		printf( "%d ", i );
	 	dayCount++;
		if( dayCount == 7 )
		{
			printf( "\n" );
			dayCount = 0;
		}
	}

	return 0;
}
