#include <stdio.h>

int main()
{
	int num1, num2, num3, num4;
	printf( "Enter four integers: " );
	scanf( "%d %d %d %d", &num1, &num2, &num3, &num4 );

	int max1, max2, max, min1, min2, min;
	if( num1 >= num2 )
	{
		max1 = num1;
		min1 = num2;
	}
	else 
	{
		max1 = num2;
		min1 = num1;
	}

	if( num3 >= num4 )
	{
		max2 = num3;
		min2 = num4;
	}
	else 
	{
		max2 = num4;
		min2 = num3;
	}

	if( max1 >= max2 )
	{
		max = max1;
	}
	else 
	{
		max = max2;
	}

	if( min1 <= min2 )
	{
		min = min1;
	}
	else 
	{
		min = min2;
	}

	printf( "Largest: %d\n", max );
	printf( "Smallest: %d\n", min );

	return 0;
}
