#include <stdio.h>
#include <stdlib.h>
#include <raylib.h>
#include <tmx.h>
#include "include/mapRender.h"

// macro funcs
#define MAX( a, b ) ( (a) > (b) ? (a) : (b) )
#define MIN( a, b ) ( (a) < (b) ? (a) : (b) )

int main(void)
{
  SetConfigFlags(FLAG_WINDOW_RESIZABLE | FLAG_VSYNC_HINT);

  InitWindow(windowWidth, windowHeight, "Window Resizing");
  SetWindowMinSize(windowWidth, windowHeight);
  SetExitKey(KEY_NULL);
  SetTargetFPS(60);

  tmx_img_load_func = RaylibTexLoad;
  tmx_img_free_func = RaylibTexFree;

  tmx_map *map = tmx_load("assets/GameBoyTest.tmx");
  if( map == NULL )
  {
    tmx_perror( "Could not load GameBoyTest.tmx" );
    return 1;
  }

  // render texture
  RenderTexture2D targetTexture = LoadRenderTexture(windowWidth, windowHeight);
  SetTextureFilter(targetTexture.texture, TEXTURE_FILTER_BILINEAR);

  Rectangle mapRect = { .x = 0, .y = 0, .width = map->width * map->tile_width, .height = map->height * map->tile_height };
  Camera2D camera = { .target = (Vector2){ mapRect.width / 2, mapRect.height / 2 },
                      .offset = (Vector2){ (float)windowWidth / 2, (float)windowHeight / 2}, .rotation = 0.0f, .zoom = 5.0f };
  
  while( !WindowShouldClose() )
  {
    // window resizing scale factor
    float scale = MIN( (float)GetScreenWidth() / windowWidth, (float)GetScreenHeight() / windowHeight );

    // screen center point pos
    Vector2 centerPoint = GetScreenToWorld2D( (Vector2){ (float)windowWidth / 2, (float)windowHeight / 2}, camera );
    // boundary check points
    Vector2 topLeftPoint = GetScreenToWorld2D( (Vector2){0, 0}, camera);
    Vector2 bottomRightPoint = GetScreenToWorld2D( (Vector2){windowWidth, windowHeight}, camera);
    // camera input handling
    if( topLeftPoint.x > 0 )
    {
      if( IsKeyDown(KEY_LEFT) )
        camera.target.x -= 10; 
    }
    if( bottomRightPoint.x < (map->width * map->tile_width) )
    {
      if( IsKeyDown(KEY_RIGHT) )
        camera.target.x += 10;
    }
    if( topLeftPoint.y > 0 )
    {
      if( IsKeyDown(KEY_UP) )
        camera.target.y -= 10;
    }
    if( bottomRightPoint.y < (map->height * map->tile_height) )
    {
      if( IsKeyDown(KEY_DOWN) )
        camera.target.y += 10;
    }
    if( IsKeyPressed(KEY_R) )
      camera.target = (Vector2){ mapRect.width / 2, mapRect.height / 2 };

    // render tilemap to render texture
    BeginTextureMode(targetTexture);
      BeginMode2D(camera);
        RenderMap(map);
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
