#include <stdio.h>

int main()
{
	int speedKnots = 0;
	printf( "Enter the wind speed in knots: " );
	scanf( "%d", &speedKnots );

	if( speedKnots < 1 )
		printf( "The air is calm\n" );
	else if( speedKnots <= 3 )
		printf( "The air is light\n" );
	else if( speedKnots >= 4 && speedKnots <= 27 )
		printf( "The air is breezy\n" );
	else if( speedKnots >= 28 && speedKnots <= 47 )
		printf( "The air is as strong as a gale\n" );
	else if( speedKnots >= 49 && speedKnots <= 63 )
		printf( "Storm incoming\n" );
	else 
		printf( "Hurricane incoming\n" );


	return 0;
}
