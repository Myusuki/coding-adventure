#include <stdio.h>

int countBoxes( int boxes );
int fibonacci( int x );

int main(void)
{
	int boxes = 10;
	// countBoxes(boxes);
	// printf( "%d ", fibonacci(boxes) );
	for( int i = 0; i <= boxes; i++ )
	{
		printf( "%d ", fibonacci( i ) );
	}
	printf( "\n" );

	return 0;
}

int countBoxes( int boxes )
{
	if( boxes == 0 )
		return 0;
	printf( "%d ", boxes );
	return countBoxes(--boxes);
}

int fibonacci( int x )
{
	if( x <= 0 )
	{
		return 0;
	}
	else if( x == 1 )
		return 1;
	return fibonacci(x -1) +fibonacci(x - 2);
}

