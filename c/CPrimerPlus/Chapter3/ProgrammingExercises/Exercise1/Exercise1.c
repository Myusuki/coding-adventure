#include <stdio.h>

int main(void)
{
	printf( "%zd\n", sizeof(int) );
	printf( "%zd\n", sizeof(float) );

	int intLetMeBE = 2147483647;
	float floatLetMeBE = 1.0e30;
	int intOverflowME = 2147483648;
	float floatOverflowME = 1.0e37;
	float floatUnderflowME = 3.1495265 / 10.0;

	printf( "This is zen (int): %d\n", intLetMeBE );
	printf( "This is zen (float): %lf\n", floatLetMeBE );
	printf( "I'M OVERFLOWN! (int): %d\n", intOverflowME );
	printf( "I'M OVERFLOWN! (float): %lf\n", floatOverflowME );
	printf( "I'm underweight (float): %lf\n", floatUnderflowME );

	return 0;
}
