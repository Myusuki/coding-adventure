#include <stdio.h>

int main()
{
	int x = 0;
	printf( "Enter a number: " );
	scanf( "%d", &x );

	int term1 = (3 * x * x * x * x * x);
	int term2 = (2 * x * x * x * x);
	int term3 = (5 * x * x * x);
	int term4 = (x * x);
	int term5 = 7 * x;
	int term6 = 6;
	int evaluation = term1 + term2 - term3 - term4 + term5 - term6;

	printf( "%d\n", evaluation );
	
	return 0;
}
