#include <raylib.h>

// global variables
#define screenWidth 800
#define screenHeight 600
#define tileWidth 8
#define tileHeight 8
#define maxTextures 1
#define worldWidth 20
#define worldHeight 20

typedef enum{ TEXTURE_TILEMAP = 0 } texture_asset;
Texture2D textures[maxTextures];

typedef struct
{
  int x;
  int y;
} sTile;
sTile world[worldWidth][worldHeight];

// modular functions
void GameStartup();
void GameUpdate();
void GameRender();
void GameShutdown();

int main(void)
{
  InitWindow(screenWidth, screenHeight, "Raylib 2D RPG");
  SetTargetFPS(60);

  GameStartup();

  while( !WindowShouldClose() )
  {
    GameUpdate();

    BeginDrawing();
      ClearBackground(RAYWHITE);
      GameRender();

    EndDrawing();
  }
  return 0;
}

void GameStartup()
{
  InitAudioDevice();
  // load tileset
  Image image = LoadImage("assets/colored_tilemap_packed.png");
  textures[TEXTURE_TILEMAP] = LoadTextureFromImage(image);
  UnloadImage(image);

  for( int columns = 0; columns < worldWidth; columns++ )
  {
    for( int rows = 0; rows < worldHeight; rows++ )
    {
      world[columns][rows] = (sTile){ .x = columns, .y = rows };
    }
  }

}
void GameUpdate();
void GameRender()
{
  sTile tile;
  int texture_index_x = 0;
  int texture_index_y = 0;
  for( int columns = 0; columns < worldWidth; columns++ )
  {
    for( int rows = 0; rows < worldHeight; rows++ )
    {
      tile = world[columns][rows];
      texture_index_x = 4;
      texture_index_y = 4;

      Rectangle source = { (float)texture_index_x, (float)texture_index_y, (float)tileWidth, (float)tileHeight };
      Rectangle dest = { (float)(tile.x * tileWidth), (float)(tile.y * tileHeight), (float)tileWidth, (float)tileHeight };
      Vector2 origin = {0, 0};
      DrawTexturePro(textures[TEXTURE_TILEMAP], source, dest, origin, 0.0f, WHITE);
    }
  }
}
void GameShutdown()
{
  CloseAudioDevice();
}
