#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <getopt.h>

const char *printHelp()
{
	return "Help!";
}

int main( int argc, char *argv[] )
{
	int opt = 0;

	while( (opt = getopt(argc, argv, ":gh") ) != -1 )
	{
		switch ( opt ) 
		{
			case 'g':
				printf( "Hello, World!\n" );
				break;
			case 'h':
				printHelp();
				exit(EXIT_FAILURE);
				break;
			default:
				char str = printHelp();
				fprintf( stderr, str, argv[0] );
				return 0;
				break;
		}
	}

	return 0;
}
