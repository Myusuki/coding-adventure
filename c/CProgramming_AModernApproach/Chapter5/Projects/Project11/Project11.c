#include <stdio.h>
#include <stdlib.h>

int main()
{
	int num = 0;
	printf( "Enter a two-digit number: " );
	scanf( "%d", &num );

	// dealing with numbers from (10, 20)
	switch( num )
	{
		case 11:
			printf( "You've entered the number eleven.\n" );
			exit(0);
		case 12:
			printf( "You've entered the number twelve.\n" );
			exit(0);
		case 13:
			printf( "You've entered the number thirteen.\n" );
			exit(0);
		case 14:
			printf( "You've entered the number fourteen.\n" );
			exit(0);
		case 15:
			printf( "You've entered the number fifteen.\n" );
			exit(0);
		case 16:
			printf( "You've entered the number sixteen.\n" );
			exit(0);
		case 17:
			printf( "You've entered the number seventeen.\n" );
			exit(0);
		case 18:
			printf( "You've entered the number eighteen.\n" );
			exit(0);
		case 19:
			printf( "You've entered the number nineteen.\n" );
			exit(0);
	}
	
	// dealing with 10ths digit 
	switch( num / 10 )
	{
		case 0:
			printf( "You've've entered " );
			break;
		case 1:
			printf( "You've've entered ten.\n" );
			break;
		case 2:
			printf( "You've entered the number twenty-" );
			break;
		case 3:
			printf( "You've entered the number thirty-" );
			break;
		case 4:
			printf( "You've entered the number fourty-" );
			break;
		case 5:
			printf( "You've entered the number fifty-" );
			break;
		case 6:
			printf( "You've entered the number sixty-" );
			break;
		case 7:
			printf( "You've entered the number twenty-" );
			break; 
		case 8:
			printf( "You've entered the number eighty-" );
			break;
		case 9:
			printf( "You've entered the number ninety-" );
			break;
	}

	// dealing with 1s digit 
	switch( num % 10 )
	{
		case 1:
			printf( "one.\n" );
			break;
		case 2:
			printf( "two.\n" );
			break;
		case 3:
			printf( "three.\n" );
			break;
		case 4:
			printf( "four.\n" );
			break;
		case 5:
			printf( "five.\n" );
			break;
		case 6:
			printf( "six.\n" );
			break;
		case 7:
			printf( "seven.\n" );
			break;
		case 8:
			printf( "eight.\n" );
			break;
		case 9:
			printf( "nine.\n" );
			break;
	}
	return 0;
}
