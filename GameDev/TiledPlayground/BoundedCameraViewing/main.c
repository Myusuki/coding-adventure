#include <stdlib.h>
#include <stdio.h>
#include <tmx.h>
#include <raylib.h>
#include "include/mapRender.h"

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

	tmx_map *map = tmx_load(argv[1] );
	if (!map) {
		tmx_perror("Cannot load map");
		return 1;
	}

  Camera2D camera = { .target = (Vector2){ ( (float)(map->tile_width * map->width) / 2), ( (float)(map->tile_height * map->height) / 2) },
                      .offset = (Vector2){ ( (float)DISPLAY_W / 2), ( (float)DISPLAY_H / 2) },
                      .zoom = 1.0 };

	while (!WindowShouldClose()) {
    // input handling
    // movement
    Vector2 worldToScreenPos = GetScreenToWorld2D( (Vector2){ ( (float)DISPLAY_W / 2), ( (float)DISPLAY_H / 2) }, camera);
    if( ( (float)worldToScreenPos.x - ( (float)DISPLAY_W / 2) ) > 0 )
    {
      if( IsKeyDown(KEY_LEFT) )
        camera.target.x -= 10;
    }
    if( ( (float)worldToScreenPos.x + ( (float)DISPLAY_W / 2) ) < (map->tile_width * map->height) )
    {
      if( IsKeyDown(KEY_RIGHT) )
        camera.target.x += 10;
    }
    if( ( (float)worldToScreenPos.y - ( (float)DISPLAY_H / 2) ) > 0 )
    {
      if( IsKeyDown(KEY_UP) )
        camera.target.y -= 10;
    }
    if( ( (float)worldToScreenPos.y + ( (float)DISPLAY_H / 2) ) < (map->tile_height * map->height) )
    {
      if( IsKeyDown(KEY_DOWN) )
        camera.target.y += 10;
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
