#include <stdio.h>
#include <getopt.h>
#include <stdlib.h>

int fibonacci( int n )
{
	int result = 0;
	if( n == 0 )
	{
		return 0;
	}
	return fibonacci(n - 1) + fibonacci(n - 2);
}

void help()
{
	printf( "Usage: fibonacci [OPTIONS]...\n\n" );
	printf( "fibonacci is a program that prints out the fibonacci sequence up to a specified number of times.\n\n" );
	printf( "Options:\n" );
	printf( "-n \t prints out the fibonacci sequence up to a specified number times. takes an integer. default value is 5 if no argument is given. \n" );
	printf( "-h \t show help\n" );
}

int main( int argc, char *argv[] )
{
	int opt; 

	while( (opt = getopt(argc, argv, "n:") ) != -1 )
	{
		switch( opt )
		{
			case 'n':
				fibonacci(atoi(optarg) );
				break;
			case ':':
				switch ( optopt ) 
				{
					case 'n':
						fibonacci(5);
						break;
					default:
						help();
						exit(1);
						break;
				}
		}
	}
	return 0;
}
