#include <stdio.h>

int main()
{
	int areaCode = 0, telephonePrefix = 0, lineNum = 0;

	printf( "Enter a phone number [(xxx) xxx-xxxx]: " );
	scanf( "(%d) %d-%d", &areaCode, &telephonePrefix, &lineNum);

	printf( "You entered: %d.%d.%d\n", areaCode, telephonePrefix, lineNum );

	return 0;
}
