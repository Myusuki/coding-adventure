#include <stdio.h>

int main()
{
	float ogCommission, rivalCommission, pricePerShare, value;
	int numOfShare;

	printf( "Enter number of shares: " );
	scanf( "%d", &numOfShare );
	printf( "Enter price per share: " );
	scanf( "%f", &pricePerShare );

	value = pricePerShare * numOfShare;

	// Original Broker commission rates
	if( value < 2500.00f )
		ogCommission = 30.00f + .017f * value;	
	else if( value < 6250.00f )
		ogCommission = 56.00f + .0066f * value;
	else if( value < 20000.00f )
		ogCommission = 76.00f + .0034f * value;
	else if( value < 50000.00f )
		ogCommission = 100.00f + .0022f * value;
	else if( value < 500000.00f )
		ogCommission = 155.00f + .0011f * value;
	else 
		ogCommission = 255.00f + .0009f * value;

	if ( ogCommission < 39.00f )
		ogCommission = 39.00f;

	// Rival Broker commission rates
	if( numOfShare < 2000 )
		rivalCommission = 33.00f + ( .03f * numOfShare );
	else if( numOfShare >= 2000 )
		rivalCommission = 33.00f + ( .02 * numOfShare );

	printf( "Original Broker's Commission: $%.2f\n", ogCommission );
	printf( "Rival Broker's Commission: $%.2f\n", rivalCommission );

	return 0;
}
