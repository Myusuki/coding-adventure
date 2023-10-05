#include <stdio.h>

int main()
{
	int itemNum = 0;
	printf( "Enter an item number: " );
	scanf( "%d", &itemNum );

	float unitPrice = 0;
	printf( "Enter unit price: " );
	scanf( "%f", &unitPrice );

	int month = 0, day = 0, year = 0;
	printf( "Enter purchase date (mm/dd/yyyy): " );
	scanf( "%d/%d/%d", &month, &day, &year ); 

	printf( "Item\tUnit\tPurchase\n\tPrice\tDate\n" );
	printf( "%d\t$%.2f\t%d/%d/%d\n", itemNum, unitPrice, month, day, year );
	return 0;
}
