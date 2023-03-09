#include <stdio.h>

int main()
{
	char num1 = 'a';
	char num2 = 'b';

	int num1Int = num1;
	int num2Int = num2;

	int sum = num1 + num2;

	printf( "a = %d\n", num1Int );
	printf( "b = %d\n", num2Int );
	printf( " a + b = %d\n", sum );
	return 0;
}
