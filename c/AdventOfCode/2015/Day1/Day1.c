#include <stdio.h>
#include <string.h>

int main( int argc, char *argv[] )
{
	for( int i = 0; i < argc; i++ )
	{
		printf( "Element %d %s\n", i, argv[i] );
	}

	char string[ strlen(argv[1]) + 1 ];
	strcpy(string, argv[1]);

	for( int i = 0; i < strlen(string); i++ )
	{
		printf( "%c\n", string[i] );
	}

	return 0;
}
