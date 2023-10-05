#include <stdio.h>

int main()
{
	int fracNum, fracDen, num1, num2, remainderNum;
	printf( "Enter a fraction: " );
	scanf( "%d/%d", &fracNum, &fracDen );
	
	num1 = fracNum;
	num2 = fracDen;

	while( num1 != 0 )
	{
		remainderNum = num2 % num1;
		num2 = num1;
		num1 = remainderNum;
	}

	fracNum /= num2;
	fracDen /= num2;

	printf( "In lowest terms: %d/%d\n", fracNum, fracDen );

	return 0;
}
