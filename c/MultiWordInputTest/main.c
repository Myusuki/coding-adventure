#include <stdio.h>

int main(int argc, char *argv[])
{
	char name[100];
	printf( "Please enter your full name: " );
	//scanf( "%[^\n]", name );
	gets( name );
	printf( "Your name is: %s\n", name );


	return 0;
}
