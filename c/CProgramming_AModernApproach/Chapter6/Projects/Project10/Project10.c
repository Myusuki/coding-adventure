#include <stdio.h>

int main()
{
	int mm1, mm2, dd1, dd2, yy1, yy2;

	printf( "Enter a date (mm/dd/yy): " );
	scanf( "%d/%d/%d", &mm1, &dd1, &yy1 );

	mm2 = mm1;
	dd2 = dd1;
	yy2 = yy1;

	while( mm2 != 0 && dd2 != 0 && yy2 != 0 )
	{
		printf( "Enter a date (mm/dd/yy): " );
		scanf( "%d/%d/%d", &mm2, &dd2, &yy2 );
		if( mm2 == 0, dd2 == 0, yy2 == 0 )
			break;

		if( yy1 < yy2  )
			continue;
		else if( yy2 < yy1 )
		{
			mm1 = mm2;
			dd1 = dd2;
			yy1 = yy2;
			continue;
		}
		else if( mm1 < mm2 )
			continue;
		else if( mm2 < mm1 )
		{
			mm1 = mm2;
			dd1 = dd2;
			yy1 = yy2;
			continue;
		}
		else if( dd1 < dd2 )
			continue;
		else if( dd2 < dd1 )
		{
			mm1 = mm2;
			dd1 = dd2;
			yy1 = yy2;
			continue;
		}
	}

	printf( "%d/%d/%2.2d is the earliest date\n", mm1, dd1, yy1 );

	return 0;
}
