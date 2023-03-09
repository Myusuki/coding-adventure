#include <stdio.h>

int main()
{
	double percentage;
	printf( "Enter a percentage: " );
	scanf( "%lf", &percentage );
	
	double percentTodec = percentage / 100;
	printf( "%f\n", percentTodec );
	return 0;
}
