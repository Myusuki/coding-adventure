#include "./Dungeon1.h"
#include <stdio.h>

void Dungeon1()
{
	int dungeon1;
	while( dungeon1 > 9 )
	{
		Dungeon1_Menu();

		scanf( "%d", &dungeon1 );

		switch( dungeon1 )
		{
			case 1:
				Dungeon1_Block1();
				break;
			case 2:
				Dungeon1_Block2();
				break;
			case 3:
				Dungeon1_Block3();
				break;
			case 4:
				Dungeon1_Block4();
				break;
			case 5:
				Dungeon1_Block5();
				break;
			case 6:
				Dungeon1_Block6();
				break;
			case 7:
				Dungeon1_Block7();
				break;
			case 8:
				Dungeon1_Block8();
				break;
			case 9:
				Dungeon1_Block9();
				break;
			case 0:
				Dungeon1_Block0();
				break;

			default:
				printf( "Sorry, I do not understand such a command. Please input a command I understand." );
				break;
		}
	}
}

void Dungeon1_Menu()
{
	printf( "With your flashlight you see a door straight ahead. What do you do?" );
	printf( "1) Go straight to the door and open it." );
	printf( "2) Explore the bottom left corner of the place." );
	printf( "3) Explore the bottom right corner of the place." );
	printf( "4) Explore the center of the place." );
	printf( "5) Explore the center left of the place." );
	printf( "6) Explore the center right of the place." );
	printf( "7) Explore the top left corner of the place." );
	printf( "8) Explore the top center of the place." );
	printf( "9) Explore the top right corner of the place." );
	printf( "0) Explore where you're standing currently." );
}

void Dungeon1_Block1()
{
	printf( "This is Dungeon 1 Block 1" );
}

void Dungeon1_Block2()
{
	printf( "This is Dungeon 1 Block 2" );
}

void Dungeon1_Block3()
{
	printf( "This is Dungeon 1 Block 3" );
}

void Dungeon1_Block4()
{
	printf( "This is Dungeon 1 Block 4" );
}

void Dungeon1_Block5()
{
	printf( "This is Dungeon 1 Block 5" );
}

void Dungeon1_Block6()
{
	printf( "This is Dungeon 1 Block 6" );
}

void Dungeon1_Block7()
{
	printf( "This is Dungeon 1 Block 7" );
}

void Dungeon1_Block8()
{
	printf( "This is Dungeon 1 Block 8" );
}

void Dungeon1_Block9()
{
	printf( "This is Dungeon 1 Block 9" );
}

void Dungeon1_Block0()
{
	printf( "This is Dungeon 1 Block 0" );
}
