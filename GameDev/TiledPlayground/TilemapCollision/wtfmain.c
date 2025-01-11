#include <stdio.h>
#include <raylib.h>
#include <tmx.h>
#include "include/player.h"
#include "include/mapRender.h"

// macro funcs
#define MAX( a, b ) ( (a) > (b) ? (a) : (b) )
#define MIN( a, b ) ( (a) < (b) ? (a) : (b) )

int main(void)
{
  const int windowWidth = 800;
  const int windowHeight = 640;

  SetConfigFlags(FLAG_VSYNC_HINT);

  InitWindow(windowWidth, windowHeight, "Window Resizing");
  SetWindowMinSize(windowWidth, windowHeight);
  SetExitKey(KEY_NULL);
  SetTargetFPS(60);

  tmx_img_load_func = RaylibTexLoad;
  tmx_img_free_func = RaylibTexFree;

  tmx_map *map = tmx_load("../assets/CaveRuinsEntrance.tmx");
  if( map == NULL )
  {
    tmx_perror( "Could not load GameBoyTest.tmx" );
    return 1;
  }

  // render texture
  RenderTexture2D targetTexture = LoadRenderTexture(windowWidth, windowHeight);
  SetTextureFilter(targetTexture.texture, TEXTURE_FILTER_BILINEAR);

  Rectangle mapRect = { .x = 0, .y = 0, .width = map->width * map->tile_width, .height = map->height * map->tile_height };
  Player player = { .position = (Vector2){ mapRect.width / 2, mapRect.height / 2 },
                    .hurtbox = { player.position.x - 16, player.position.y - 16, 32, 32 },
                    .speed = (Vector2){ 128, 128 }, .canJump = false };
  Camera2D camera = { .target = player.position,
                      .offset = (Vector2){ (float)windowWidth / 2, (float)windowHeight / 2},
                      .rotation = 0.0f, .zoom = 5.0f };

  while( !WindowShouldClose() )
  {
    float scale = MIN( (float)GetScreenWidth() / windowWidth, (float)GetScreenHeight() / windowHeight );

    UpdatePlayer(&camera, &player, windowWidth, windowHeight, mapRect, GetFrameTime() );

    // render tilemap to render texture
    BeginTextureMode(targetTexture);
      BeginMode2D(camera);
        RenderMap(map);
        DrawRectangleRec(player.hurtbox, BLACK);
      EndMode2D();
    EndTextureMode();
    // draw
    BeginDrawing();
      ClearBackground(BLACK);
      DrawTexturePro(targetTexture.texture, (Rectangle){0, 0, targetTexture.texture.width, -targetTexture.texture.height},
        (Rectangle){ (GetScreenWidth() - ( (float)windowWidth * scale) ) * 0.5f, (GetScreenHeight() - ( (float)windowHeight * scale) ) * 0.5f, (float)windowWidth * scale, (float)windowHeight * scale}, 
        (Vector2){0, 0}, 0.0f, WHITE);
    EndDrawing();
  }
  tmx_map_free(map);
  CloseWindow();

  return 0;
}
