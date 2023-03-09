#include <stdio.h>
#include <string.h>

int main()
{
	printf( "Hello. What is your name?\n" );
	printf( "> " );
	
	char name[100] = "";
	scanf( "%s", name );

	printf( "Greetings, %s!\n", name );
	
	return 0;
}
