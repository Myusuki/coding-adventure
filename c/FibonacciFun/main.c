#include <stdio.h>

int Fibonacci( int*, int* );

int main(int argc, char *argv[])
{
	int num1, num2;
	printf( "Enter a number: " );
	scanf( "%d", &num1 );

	printf( "Enter a number: " );
	scanf( "%d", &num2 );

	printf( "Numbers before fibonacci: \n" );
	printf( "Num1: %d\n", num1 );
	printf( "Num2: %d\n", num2 );

	Fibonacci( &num1, &num2 );

	printf( "Numbers after fibonacci: \n" );
	printf( "Num1: %d\n", num1 );
	printf( "Num2: %d\n", num2 );

	return 0;
}

int Fibonacci( int *a, int *b )
{
	int c = 0;
	for( int i = 0; i <= 9; i++ )
	{
		*a = *b;
		*b = c; 
		c = *a + *b;
		printf( "Result: %d\n", c );
	}

	return c;
}
