#include <stdio.h>

int main(void)
{
	FILE *fptr;

	fptr = fopen("order1.txt", "r");

	char string[12];
	long int total = 0;

	// fgets(string, 12, fptr);
	// int i = 0;
	// int length = 0;
	// int width = 0;
	// int height = 0;
	//
	// while( string[i] != 'x' )
	// {
	// 	if( string[i + 1] == 'x' )
	// 	{
	// 		int num = (int)string[i];
	// 		num -= 48;
	// 		length += num;
	// 	}
	// 	else
	// 	{
	// 		length *= 10;
	// 		int num = (int)string[i];
	// 		num -= 48;
	// 		length += num;
	// 		length *= 10;
	// 	}
	// 	printf( "Length: %d\n", length );
	// 	i++;
	// }
	// i++;
	// while( string[i] != 'x' )
	// {
	// 	if( string[i + 1] == 'x' )
	// 	{
	// 		int num = (int)string[i];
	// 		num -= 48;
	// 		width += num;
	// 	}
	// 	else
	// 	{
	// 		width *= 10;
	// 		int num = (int)string[i];
	// 		num -= 48;
	// 		width += num;
	// 		width *= 10;
	// 	}
	// 	printf( "Width: %d\n", width );
	// 	i++;
	// }
	// i++;
	// while( string[i] != '\n' )
	// {
	// 	if( string[i + 1] == '\n' )
	// 	{
	// 		int num = (int)string[i];
	// 		num -= 48;
	// 		height += num;
	// 	}
	// 	else
	// 	{
	// 		height *= 10;
	// 		int num = (int)string[i];
	// 		num -= 48;
	// 		height += num;
	// 		height *= 10;
	// 	}
	// 	printf( "Height: %d\n", height );
	// 	i++;
	// }
	// total += (2 * length * width) + (2 * width * height) + (2 * height * length);
	// printf( "Total: %d\n", total );

	while( fgets(string, 12, fptr))
	{
		int i = 0;
		int length = 0;
		int width = 0;
		int height = 0;
		if( string[i] == '\0' )
			break;
		while( string[i] != 'x' )
		{
			if( string[i + 1] == 'x' )
			{
				int num = (int)string[i];
				num -= 48;
				length += num;
			}
			else
			{
				length *= 10;
				int num = (int)string[i];
				num -= 48;
				length += num;
				length *= 10;
			}
			printf( "Length: %d\n", length );
			i++;
		}
		i++;
		while( string[i] != 'x' )
		{
			if( string[i + 1] == 'x' )
			{
				int num = (int)string[i];
				num -= 48;
				width += num;
			}
			else
			{
				width *= 10;
				int num = (int)string[i];
				num -= 48;
				width += num;
				width *= 10;
			}
			printf( "Width: %d\n", width );
			i++;
		}
		i++;
		while( string[i] != '\n' )
		{
			if( string[i + 1] == '\n' )
			{
				int num = (int)string[i];
				num -= 48;
				height += num;
			}
			else
			{
				height *= 10;
				int num = (int)string[i];
				num -= 48;
				height += num;
				height *= 10;
			}
			printf( "Height: %d\n", height );
			i++;
		}
		total += (2 * length * width) + (2 * width * height) + (2 * height * length);
		int side1 = 2 * length * width;
		int side2 = 2 * width * height;
		int side3 = 2 * height * length;
		int min = side1;

		if( side2 < side1 )
			min = side2;
		else if( side3 < side1 )
			min = side3;
		
		total += min;
		printf( "Min: %d\n", min );
		printf( "Total: %ld\n", total );
	}
	printf( "Total: %ld\n", total );
	return 0;
}


