/*
* A basic blackjack card counter for fun
*/ 

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	char cardValue[3];
	int cardCountValue;
	int cardCount;

	while( cardValue[0] != 'x' )
	{
		// have the user enter a card value 
		printf( "Enter a card value: " );
		scanf( "%2s", cardValue );

		// printf( "%s", cardValue );
		switch( cardValue[0] )
		{
			case 'K':
			case 'Q':
			case 'J':
				cardCountValue = 10;
				break;
			case 'A':
				cardCountValue = 11;
				break;
			default:
				cardCountValue = atoi( cardValue );
				break;
		}
		switch( cardCountValue )
		{
			case 10:
				cardCount--;
				printf( "Card count value is: %d\n", cardCount );
				break;
			case 11:
			case 7:
			case 8:
			case 9:
			case 2:
				cardCount += 0;
				printf( "Card count value is: %d\n", cardCount );
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				cardCount++;
				printf( "Card count value is: %d\n", cardCount );
				break;
		}
	}

	return 0;
}
