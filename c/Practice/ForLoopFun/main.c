#include <stdio.h>

int main(void)
{
	for(int i = 0, j = 0; i < 10 && j < 10; i++, j++)
	{
		printf( "i: %d\n", i );
		printf( "j: %d\n", j );
	}
	return 0;
}
