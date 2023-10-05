#include <stdio.h>

int main()
{
	printf( "Enter the first twelve digits of a UPC: " );
	long upcNum = 0;
	scanf( "%ld", &upcNum );

	int num1 = upcNum % 10;
	upcNum /= 10;
	int num2 = upcNum % 10;
	upcNum /= 10;
	int num3 = upcNum % 10;
	upcNum /= 10;
	int num4 = upcNum % 10;
	upcNum /= 10;
	int num5 = upcNum % 10;
	upcNum /= 10;
	int num6 = upcNum % 10;
	upcNum /= 10;
	int num7 = upcNum % 10;
	upcNum /= 10;
	int num8 = upcNum % 10;
	upcNum /= 10;
	int num9 = upcNum % 10;
	upcNum /= 10;
	int num10 = upcNum % 10;
	upcNum /= 10;
	int num11 = upcNum % 10;
	upcNum /= 10;
	int num12 = upcNum % 10;
	upcNum /= 10;
	
	int sum1 = num1 + num3 + num5 + num7 + num9 + num11;
	int sum2 = num2 + num4 + num6 + num8 + num10 + num12;
	int endSum = (sum1 * 3) + sum2;
	endSum--;
	int checkDigit = endSum % 10;
	checkDigit = 9 - checkDigit;
	printf( "The check digit is: %d\n", checkDigit );
	return 0;
}
