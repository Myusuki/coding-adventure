#include <gb/gb.h>
#include "gameboyexporttest.c"

void main()
{
	SPRITES_8x8;
	set_sprite_data(0, 3, gameboyexporttest_tiles);
	set_sprite_tile(0, 0);
	move_sprite(0, 50, 50);

	set_sprite_tile(1, 1);
	move_sprite(1, 57, 50);

	set_sprite_tile(2, 2);
	move_sprite(2, 50, 57);

	SHOW_SPRITES;
}
