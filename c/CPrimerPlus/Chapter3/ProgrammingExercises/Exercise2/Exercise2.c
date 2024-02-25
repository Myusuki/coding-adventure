#include <stdio.h>

int main(void)
{
	char character = 0;
	int num = 0;

	printf( "Enter a number from 33-126: " );
	scanf( "%d", &num );

	character = num;
	printf( "Your character is: %c\n", character );
	return 0;
}
