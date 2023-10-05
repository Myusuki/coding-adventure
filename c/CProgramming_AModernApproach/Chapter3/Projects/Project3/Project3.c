#include <stdio.h>

int main()
{
	int gsiPrefix = 0, groupID = 0, publisherCode = 0, itemNum = 0, checkDig = 0;
	printf( "Enter ISBN: " );
	scanf( "%d-%d-%d-%d-%d", &gsiPrefix, &groupID, &publisherCode, &itemNum, &checkDig );

	printf( "GSI Prefix: %d\n", gsiPrefix );
	printf( "Group Identifier: %d\n", groupID );
	printf( "Publisher Code: %d\n", publisherCode );
	printf( "Item number: %d\n", itemNum );
	printf( "Check digit: %d\n", checkDig );
	return 0;
}
