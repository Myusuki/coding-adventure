#include <stdio.h>

int main()
{
	int num1, num2, remainderNum;
	printf( "Enter two integers: " );
	scanf( "%d %d", &num1, &num2 );

	while( num1 != 0 )
	{
		remainderNum = num2 % num1;
		num2 = num1;
		num1 = remainderNum;
	}
	
	printf( "Greatest common divisor: %d\n", num2 );
	return 0;
}
