#include <stdio.h>

int main(int argc, char *argv[])
{
	char test = 'c';

	printf( "The ASCII value of character is: %d\n", (int)test );

	int implicitConversion = test + 1;

	printf( "The sum of 1 and c is: %d\n", implicitConversion );

	return 0;
}
