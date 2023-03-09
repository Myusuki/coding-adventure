#include <stdio.h>
#include <string.h>

int main()
{
	printf( "Hello. What is your name?\n" );
	printf( "> " );

	char name[100] = "";
	scanf( "%s", name );

	if( strcmp( name, "Alice" ) == 1 || strcmp( name, "Bob" ) == 1 )
	{
		printf( "Sorry, I don't know you. Have a good day.\n" );
	}
	else 
	{
		printf( "Greetings, %s\n", name );
	}

	return 0;
}	
