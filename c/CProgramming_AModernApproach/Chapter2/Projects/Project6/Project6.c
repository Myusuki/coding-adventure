#include <stdio.h>

int main()
{
	int x = 0;
	printf( "Enter a number: " );
	scanf( "%d", &x );

	int evaluation = ((((3 * x + 2) * x - 5 ) * x- 1) * x + 7) * x - 6;

	printf( "%d\n", evaluation );
	return 0;
}
