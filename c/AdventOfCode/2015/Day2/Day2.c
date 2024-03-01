#include <stdio.h>


// get the smallest num out 3 numbers
int MinOf3( int num1, int num2, int num3 );
// checks for the smallest side and returns the value
int MinSide( int width, int length, int height );

int main(void)
{
	FILE *fptr;

	fptr = fopen("order.txt", "r");

	int totalArea = 0;
	int totalLength = 0;

	while( !feof(fptr) )
	{
		int width = 0, length = 0, height = 0;

		fscanf(fptr, "%dx%dx%d", &width, &length, &height);

		// wrapping paper calculations
		int smallestSide = MinSide(width, length, height);
		int surfaceArea = (2 * width * length) + (2 * length * height) + (2 * width * height);
		totalArea += surfaceArea + smallestSide;

		// ribbon calculations 
		int perimeterSide1 = MinOf3(width, length, height);
		int perimeterSide2 = 0;
		// accomadations for potential division by 0
		if( (width == 0 && length == 0) || (width == 0 && height == 0) || (length == 0 && height == 0) )
			perimeterSide2 = 0;
		else
			perimeterSide2 = smallestSide / perimeterSide1;
		int shortestWrappingLength = (2 * perimeterSide1) + (2 * perimeterSide2);
		int bowLength = width * length * height;
		totalLength += shortestWrappingLength + bowLength;
	}
	fclose(fptr);

	printf( "Total wrapping paper length: %d\n", totalArea );
	printf( "Total ribbon length: %d\n", totalLength );

	return 0;
}

// get the smallest num out 3 numbers
int MinOf3( int num1, int num2, int num3 )
{
	int min = num1;

	if( num2 < min )
		min = num2;
	if( num3 < min )
		min = num3;

	return min;
}

// checks for the smallest side and returns the value
int MinSide( int width, int length, int height )
{
	int side1 = 0, side2 = 0, side3 = 0;
	side1 = width * length;
	side2 = length * height;
	side3 = width * height;
	
	int min = side1;
	
	if( side2 < min )
		min = side2;
	if( side3 < min )
		min = side3;

	return min;
}
