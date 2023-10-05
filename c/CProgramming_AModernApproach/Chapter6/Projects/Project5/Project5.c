#include <stdio.h>

int main()
{
	int num = 0;
	printf( "Enter a number: " );
	scanf( "%d", &num );


	printf( "The reversal is: " );
	do {
		printf( "%d", (num % 10) );
		num /= 10;
	} while( num != 0 );
	
	printf( "\n" );
	return 0;
}
