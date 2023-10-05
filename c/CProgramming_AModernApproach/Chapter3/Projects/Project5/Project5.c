#include <stdio.h>

int main()
{
	int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16;

	printf( "Enter the numbers from 1 to 16 in any order: \n" );
	scanf( "%d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d", &num1, &num2, &num3, &num4, &num5, &num6, &num7, &num8, &num9, &num10, &num11, &num12, &num13, &num14, &num15, &num16 );

	printf( "%d %d %d %d\n", num1, num2, num3, num4 );
	printf( "%d %d %d %d\n", num5, num6, num7, num8 );
	printf( "%d %d %d %d\n", num9, num10, num11, num12 );
	printf( "%d %d %d %d\n", num13, num14, num15, num16 );

	int rowSum1, rowSum2, rowSum3, rowSum4;
	rowSum1 = num1 + num2 + num3 + num4;
	rowSum2 = num5 + num6 + num7 + num8;
	rowSum3 = num9 + num10 + num11 + num12;
	rowSum4 = num13 + num14 + num15 + num16;

	int columnSum1, columnSum2, columnSum3, columnSum4; 
	columnSum1 = num1 + num5 + num9 + num13;
	columnSum2 = num2 + num6 + num10 + num14;
	columnSum3 = num3 + num7 + num11 + num15;
	columnSum4 = num4 + num8 + num12 + num16;

	int diagonalSum1, diagonalSum2;
	diagonalSum1 = num1 + num6 + num11 + num16;
	diagonalSum2 = num4 + num7 + num10 + num13;

	printf( "Row sums: %d %d %d %d\n", rowSum1, rowSum2, rowSum3, rowSum4 );
	printf( "Column sums: %d %d %d %d\n", columnSum1, columnSum2, columnSum3, columnSum4 );
	printf( "Diagonal sums: %d %d\n", diagonalSum1, diagonalSum2 );

	return 0;
}
