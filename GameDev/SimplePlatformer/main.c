#include <stdio.h>
#include <stdlib.h>
#include <raylib.h>
#include <tmx.h>
#include "include/mapRender.h"

// macro funcs
#define MAX( a, b ) ( (a) > (b) ? (a) : (b) )
#define MIN( a, b ) ( (a) < (b) ? (a) : (b) )

// player
typedef struct Player
{
  Vector2 position;
  Rectangle hurtbox;
  float speed;
  bool canJump;
} Player;

// modular functions
void UpdatePlayer( Player *player, Rectangle *mapRect );
void UpdatePlayerCamera( Camera2D *camera, Player *player, float deltaTime, int screenWidth, int screenHeight, Rectangle mapRect );

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

  Player player = { .position = (Vector2){800, 800}, .hurtbox = {player.position.x - 8, player.position.y - 8, 16, 16}, .speed = 16, .canJump = false };

  Rectangle mapRect = { .x = 0, .y = 0, .width = map->width * map->tile_width, .height = map->height * map->tile_height };
  Camera2D camera = { .target = player.position,
                      .offset = (Vector2){ (float)windowWidth / 2, (float)windowHeight / 2}, .rotation = 0.0f, .zoom = 5.0f };

  while( !WindowShouldClose() )
  {
    float scale = MIN( (float)GetScreenWidth() / windowWidth, (float)GetScreenHeight() / windowHeight );
    // screen center point pos
    // Vector2 centerPoint = GetScreenToWorld2D( (Vector2){ (float)windowWidth / 2, (float)windowHeight / 2}, camera );
    // Vector2 centerPoint = GetScreenToWorld2D( player.position, camera );
    // printf( "Center Point X: %f, Y: %f\n", centerPoint.x, centerPoint.y );
    // printf( "Delta Time: %lf\n", GetFrameTime() );
    // // boundary check points
    // Vector2 topLeftPoint = GetScreenToWorld2D( (Vector2){0, 0}, camera);
    // Vector2 bottomRightPoint = GetScreenToWorld2D( (Vector2){windowWidth, windowHeight}, camera);
    //
    // // player input handling
    // if( topLeftPoint.x > 0 )
    // {
    //   if( IsKeyDown(KEY_LEFT) )
    //     player.position.x -= player.speed;
    // }
    // if( bottomRightPoint.x < mapRect.width )
    // {
    //   if( IsKeyDown(KEY_RIGHT) )
    //     player.position.x += player.speed;
    // }
    // if( topLeftPoint.y > 0 )
    // {
    //   if( IsKeyDown(KEY_UP) )
    //     player.position.y -= player.speed;
    // }
    // if( bottomRightPoint.y < mapRect.height )
    // {
    //   if( IsKeyDown(KEY_DOWN) )
    //     player.position.y += player.speed;
    // }
    // player.hurtbox.x = player.position.x - 8;
    // player.hurtbox.y = player.position.y - 8;
    //
    // camera.target = player.position;
    // if( IsKeyPressed(KEY_R) )
    //   camera.target = (Vector2){ mapRect.width / 2, mapRect.height / 2 };

    UpdatePlayer(&player, &mapRect);
    UpdatePlayerCamera(&camera, &player, GetFrameTime(), windowWidth, windowHeight, mapRect);

    // render tilemap to render texture
    BeginTextureMode(targetTexture);
      BeginMode2D(camera);
        RenderMap(map);
        DrawRectangle(player.hurtbox.x, player.hurtbox.y, player.hurtbox.width, player.hurtbox.height, BLACK);
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

void UpdatePlayer( Player *player, Rectangle *mapRect )
{ 
  if( player->position.x == mapRect->x )
    player->position.x = mapRect->x;
  else if( player->position.x + player->hurtbox.width == mapRect->width )
    player->position.x = mapRect->width - player->hurtbox.width;
  if( player->position.y == mapRect->y )
    player->position.y = mapRect->y;
  else if( player->position.y + player->hurtbox.height == mapRect->height )
    player->position.y = mapRect->height - player->hurtbox.height;

  if( IsKeyDown(KEY_LEFT) )
    player->position.x -= player->speed;
  else if( IsKeyDown(KEY_RIGHT) )
    player->position.x += player->speed;
  if( IsKeyDown(KEY_UP) )
    player->position.y -= player->speed;
  else if( IsKeyDown(KEY_DOWN) )
    player->position.y += player->speed;

  player->hurtbox.x = player->position.x - 8;
  player->hurtbox.y = player->position.y - 8;
}

void UpdatePlayerCamera( Camera2D *camera, Player *player, float deltaTime, int screenWidth, int screenHeight, Rectangle mapRect )
{
  // if( topLeftPoint.x > mapRect.x && topLeftPoint.y > mapRect.y && bottomRightPoint.x < mapRect.width && bottomRightPoint.y < mapRect.height )
  // {
    // bounding box logic
    static Vector2 boundingBox = { 0.4f, 0.4f };

    Vector2 boundingBoxWorldMin = GetScreenToWorld2D( (Vector2){ (1 - boundingBox.x) * 0.5f * windowWidth, (1 - boundingBox.y ) * 0.5f * screenHeight }, *camera);
    Vector2 boundingBoxWorldMax = GetScreenToWorld2D( (Vector2){ (1 + boundingBox.x) * 0.5f * screenWidth, (1 + boundingBox.y) * 0.5f * screenHeight }, *camera);

    camera->offset = (Vector2){ (1 - boundingBox.x) * 0.5f * screenWidth, ( 1 - boundingBox.y) * 0.5f * screenHeight };

    if( player->position.x < boundingBoxWorldMin.x )
      camera->target.x = player->position.x;
    else if( player->position.x > boundingBoxWorldMax.x )
      camera->target.x = boundingBoxWorldMin.x + (player->position.x - boundingBoxWorldMax.x);
    if( player->position.y < boundingBoxWorldMin.y )
      camera->target.y = player->position.y;
    else if( player->position.y > boundingBoxWorldMax.y )
      camera->target.y = boundingBoxWorldMin.y + (player->position.y - boundingBoxWorldMax.y);
  // }
  // camera boundaries logic
  Vector2 centerPoint = GetScreenToWorld2D( (Vector2){ (float)windowWidth / 2, (float)windowHeight / 2}, *camera );
  printf( "Center Point X: %f, Y: %f\n", centerPoint.x, centerPoint.y );
  // boundary check points
  Vector2 topLeftPoint = GetScreenToWorld2D( (Vector2){0, 0}, *camera);
  Vector2 bottomRightPoint = GetScreenToWorld2D( (Vector2){windowWidth, windowHeight}, *camera);
  if( topLeftPoint.x == mapRect.x )
    camera->target.x = mapRect.x + centerPoint.x;
  else if( bottomRightPoint.x == mapRect.width )
    camera->target.x = mapRect.width - centerPoint.x;
  if( topLeftPoint.y == mapRect.y )
    camera->target.y = mapRect.y + centerPoint.y;
  else if( bottomRightPoint.y == mapRect.height )
    camera->target.y = mapRect.height - centerPoint.y;
}
