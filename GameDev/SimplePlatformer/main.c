#include <stdlib.h>
#include <stdio.h>
#include <tmx.h>
#include <raylib.h>

#define DISPLAY_H 600
#define DISPLAY_W 800

void *raylib_tex_loader(const char *path)
{
	Texture2D *returnValue = malloc(sizeof(Texture2D));
	*returnValue = LoadTexture(path);
	return returnValue;
}

void raylib_free_tex(void *ptr)
{
	UnloadTexture(*((Texture2D *) ptr));
	free(ptr);
}

Color int_to_color(int color)
{
	tmx_col_bytes res = tmx_col_to_bytes(color);
	return *((Color*)&res);
}

#define LINE_THICKNESS 2.5

void draw_polyline(double offset_x, double offset_y, double **points, int points_count, Color color)
{
	int i;
	for (i=1; i<points_count; i++) {
		DrawLineEx((Vector2){offset_x + points[i-1][0], offset_y + points[i-1][1]},
		           (Vector2){offset_x + points[i][0], offset_y + points[i][1]},
		           LINE_THICKNESS, color);
	}
}

void draw_polygon(double offset_x, double offset_y, double **points, int points_count, Color color)
{
	draw_polyline(offset_x, offset_y, points, points_count, color);
	if (points_count > 2) {
		DrawLineEx((Vector2){offset_x + points[0][0], offset_y + points[0][1]},
		           (Vector2){offset_x + points[points_count-1][0], offset_y + points[points_count-1][1]},
		           LINE_THICKNESS, color);
	}
}

void draw_objects(tmx_object_group *objgr)
{
	tmx_object *head = objgr->head;
	Color color = int_to_color(objgr->color);

	while (head) {
		if (head->visible) {
			if (head->obj_type == OT_SQUARE) {
				DrawRectangleLinesEx((Rectangle){head->x, head->y, head->width, head->height}, LINE_THICKNESS, color);
			}
			else if (head->obj_type  == OT_POLYGON) {
				draw_polygon(head->x, head->y, head->content.shape->points, head->content.shape->points_len, color);
			}
			else if (head->obj_type == OT_POLYLINE) {
				draw_polyline(head->x, head->y, head->content.shape->points, head->content.shape->points_len, color);
			}
			else if (head->obj_type == OT_ELLIPSE) {
				DrawEllipseLines(head->x + head->width/2.0, head->y + head->height/2.0, head->width/2.0, head->height/2.0, color);
			}
		}
		head = head->next;
	}
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

void draw_layer(tmx_map *map, tmx_layer *layer)
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
        case L_OBJGR:
          draw_objects(layers->content.objgr);
          break;
        case L_IMAGE:
          draw_image_layer(layers->content.image);
          break;
        case L_LAYER:
          draw_layer(map, layers);
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

int main(int argc, char **argv)
{
	InitWindow(DISPLAY_W, DISPLAY_H, "raylib example");
	if (!IsWindowReady()) {
		fputs("Cannot create a window", stderr);
		return 1;
	}

	SetTargetFPS(30);
  SetExitKey(KEY_NULL);

	/* Set the callback globs in the main function */
	tmx_img_load_func = raylib_tex_loader;
	tmx_img_free_func = raylib_free_tex;

	tmx_map *map = tmx_load("./assets/GameBoyTest.tmx");
	if (!map) {
		tmx_perror("Cannot load map");
		return 1;
	}

  Camera2D camera = { .target = (Vector2){ ( (float)(map->tile_width * map->width) / 2), ( (float)(map->tile_height * map->height) / 2) },
                      .offset = (Vector2){ ( (float)DISPLAY_W / 2), ( (float)DISPLAY_H / 2) },
                      .zoom = 3.0 };

	while (!WindowShouldClose()) {
    // input handling
    // movement
    Vector2 worldToScreenPos = GetScreenToWorld2D( (Vector2){ ( (float)DISPLAY_W / 2), ( (float)DISPLAY_H / 2) }, camera);
    if( (worldToScreenPos.x - ( (float)DISPLAY_W / 2) ) > 0 )
    {
      if( IsKeyDown(KEY_LEFT) )
        camera.target.x -= 10;
    }
    if( (worldToScreenPos.x + ( (float)DISPLAY_W / 2) ) < (map->tile_width * map->height) )
    {
      if( IsKeyDown(KEY_RIGHT) )
        camera.target.x += 10;
    }
    if( (worldToScreenPos.y - ( (float)DISPLAY_H / 2) ) > 0 )
    {
      if( IsKeyDown(KEY_UP) )
        camera.target.y -= 10;
    }
    if( (worldToScreenPos.y + ( (float)DISPLAY_H / 2) ) < (map->tile_height * map->height) )
    {
      if( IsKeyDown(KEY_DOWN) )
        camera.target.y +=10;
    }
    // reset
    if( IsKeyPressed(KEY_R) )
      camera.target = (Vector2){ (float)(map->tile_width * map->width) / 2, (float)(map->tile_height * map->height) / 2};

    // logic
    // Vector2 screenToWorldPos = GetWorldToScreen2D( (Vector2){0, 0}, camera);
    // printf( "X: %f, Y:%f\n", screenToWorldPos.x, screenToWorldPos.y );
    printf( "X: %f, Y: %f\n", worldToScreenPos.x, worldToScreenPos.y );

		BeginDrawing();
      BeginMode2D(camera);
        render_map(map);
      EndMode2D();
		EndDrawing();
	}

	tmx_map_free(map);

	CloseWindow();

	return 0;
}
