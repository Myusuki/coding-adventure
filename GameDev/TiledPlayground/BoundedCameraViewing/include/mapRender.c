#include <stdlib.h>
#include <stdio.h>
#include <raylib.h>
#include <tmx.h>
#include "mapRender.h"

Color int_to_color(int color)
{
	tmx_col_bytes res = tmx_col_to_bytes(color);
	return *((Color*)&res);
}

void draw_image_layer(tmx_image *image)
{
	Texture2D *texture = (Texture2D*)image->resource_image;
	DrawTexture(*texture, 0, 0, WHITE);
}

void draw_tile(void *image, unsigned int sourceX, unsigned int sourceY, unsigned int sourceWidth, unsigned int sourceHeight,
               unsigned int destX, unsigned int destY, float opacity, unsigned int flags)
{
    Texture2D *texture = (Texture2D*)image;
    int op = 0xFF * opacity;
    DrawTextureRec(*texture, (Rectangle) {sourceX, sourceY, sourceWidth, sourceHeight}, (Vector2) {destX, destY}, (Color) {op, op, op, op});
}

void draw_tile_layer(tmx_map *map, tmx_layer *layer)
{
	unsigned long i, j;
	unsigned int gid, x, y, w, h, flags;
	float op;
	tmx_tileset *ts;
	tmx_image *im;
	void* image;
	op = layer->opacity;
	for (i=0; i<map->height; i++) {
		for (j=0; j<map->width; j++) {
			gid = (layer->content.gids[(i*map->width)+j]) & TMX_FLIP_BITS_REMOVAL;
			if (map->tiles[gid] != NULL) {
				ts = map->tiles[gid]->tileset;
				im = map->tiles[gid]->image;
				x  = map->tiles[gid]->ul_x;
				y  = map->tiles[gid]->ul_y;
				w  = ts->tile_width;
				h  = ts->tile_height;
				if (im) {
          image = im->resource_image;
				}
				else {
          image = ts->image->resource_image;
				}
				flags = (layer->content.gids[(i*map->width)+j]) & ~TMX_FLIP_BITS_REMOVAL;
        draw_tile(image, x, y, w, h, j*ts->tile_width, i*ts->tile_height, op, flags);
			}
		}
	}
}

void draw_all_layers(tmx_map *map, tmx_layer *layers)
{
	while (layers)
  {
		if (layers->visible)
    {
      switch( layers->type )
      {
        case L_GROUP:
          draw_all_layers(map, layers->content.group_head);
          break;
        // case L_OBJGR:
        //   draw_objects(layers->content.objgr);
        //   break;
        case L_IMAGE:
          draw_image_layer(layers->content.image);
          break;
        case L_LAYER:
          draw_tile_layer(map, layers);
          break;
        default:
          break;
      }
		}
		layers = layers->next;
	}
}

void render_map(tmx_map *map)
{
	ClearBackground(int_to_color(map->backgroundcolor));
	draw_all_layers(map, map->ly_head);
}
