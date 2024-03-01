#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main( int argc, char *argv[] )
{
	char *string; 
	string = malloc(sizeof(char) * strlen(argv[1]) + 1);
	strcpy(string, argv[1] );

	int floor = 0;
	int basementStart = 0;

	for( int i = 0; i < strlen(string); i++ )
	{
		if( string[i] == '(' )
			floor++;
		else if( string[i] == ')' ) 
			floor--;
	}
	printf( "Floor: %d\n", floor );

	floor = 0;
	for( int i = 0; i < strlen(string); i++ )
	{
		if( string[i] == '(' )
			floor++;
		else if( string[i] == ')' ) 
			floor--;
		
		if( floor == -1 )
		{
			basementStart = i + 1;
			break;
		}
	}

	free(string);
	printf( "Santa goes to the basement at %d character.\n", basementStart );

	return 0;
}
