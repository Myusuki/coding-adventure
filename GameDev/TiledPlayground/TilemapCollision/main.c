#include <stdio.h>
#include <raylib.h>
#include <tmx.h>
#include "include/mapRender.h"
#include "include/player.h"

#define MIN( a, b ) ( (a) < (b) ? (a) : (b) )

int main(void)
{
  const int windowWidth = 800;
  const int windowHeight = 600;

  SetWindowSize(windowWidth, windowHeight);
  SetConfigFlags(FLAG_WINDOW_RESIZABLE | FLAG_VSYNC_HINT);
  // SetConfigFlags(FLAG_FULLSCREEN_MODE | FLAG_VSYNC_HINT);
  InitWindow(GetScreenWidth(), GetScreenHeight(), "Tilemap Collision");
  SetWindowMinSize(windowWidth, windowHeight);
  SetExitKey(KEY_NULL);
  SetTargetFPS(60);

  // tmx inits
  tmx_img_load_func = RaylibTexLoad;
  tmx_img_free_func = RaylibTexFree;

  tmx_map *map = tmx_load("../assets/GameBoyTest.tmx");
  if( map == NULL )
  {
    tmx_perror( "Could not load CaveRuinsEntrance.tmx");
    return 1;
  }

  // render texture
  RenderTexture2D targetTexture = LoadRenderTexture(windowWidth, windowHeight);
  SetTextureFilter(targetTexture.texture, TEXTURE_FILTER_BILINEAR);

  // map rectangle
  Rectangle mapRect = { .x = 0, .y = 0, .width = (map->tile_width * map->width), .height = (map->tile_height * map->height) };
  Player player = { .position = (Vector2){ (mapRect.width / 2), (mapRect.height / 2) },
                   .hurtbox = (Rectangle){ (player.position.x - 8), (player.position.y - 8), 16, 16 },
                   .speed = (Vector2){ 128, 128 }, .collided = false };
  Camera2D camera = { .target = player.position,
                      .offset = (Vector2){ (windowWidth / 2.0f), (windowHeight / 2.0f) },
                      .rotation = 0.0f, .zoom = 5.0f };

  while( !WindowShouldClose() )
  {
    printf( "Map Tiles: %d\n", map->tilecount );
    printf( "Map Width: %d\n", map->width );
    printf( "Map Height: %d\n", map->height );
    // input handling and logic
    printf( "Screen Width: %d\n", GetScreenWidth() );
    printf( "Screen Height: %d\n", GetScreenHeight() );
    float scale = MIN( (float)GetScreenWidth() / windowWidth, (float) GetScreenHeight() / windowHeight ); 
    printf( "Scale Factor: %f\n", scale );

    UpdatePlayer(map, &camera, &player, (Vector2){ windowWidth, windowHeight}, mapRect, GetFrameTime() );
    // printf( "Player Collision: %d\n", player.collided );

    // draw
    // draw to render texture
    BeginTextureMode(targetTexture);
      BeginMode2D(camera);
        RenderMap(map);
        DrawPlayer(&player, player.collided);
      EndMode2D();
    EndTextureMode();
    // draw to screen
    BeginDrawing();
      ClearBackground(BLACK);
      DrawTexturePro(targetTexture.texture, (Rectangle){ 0, 0, targetTexture.texture.width, -targetTexture.texture.height },
                    (Rectangle){ (GetScreenWidth() - ( (float)windowWidth * scale) ) * 0.5f, (GetScreenHeight() - ( (float)windowHeight * scale) ) * 0.5f, (float)windowWidth * scale, (float)windowHeight * scale }, 
                    (Vector2){0, 0}, 0.0f, WHITE);
    EndDrawing();

  }
  tmx_map_free(map);
  CloseWindow();

  return 0;
}
