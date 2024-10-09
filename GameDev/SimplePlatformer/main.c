#include <raylib.h>
#include <stdio.h>
#include <stdbool.h>

#define screenWidth 800
#define screenHeight 600

int main(void)
{
  SetConfigFlags(FLAG_VSYNC_HINT);
  InitWindow(screenWidth, screenHeight, "Simple Platformer");
  SetTargetFPS(60);

  bool showText = false;
  while( !WindowShouldClose() || IsKeyPressed(KEY_ESCAPE) )
  {
    if( IsKeyPressed(KEY_ESCAPE) )
      showText = true;

    BeginDrawing();
      ClearBackground(WHITE);
      if( showText )
        DrawText("Hello, World!", (screenWidth - MeasureText("Hello, World!", 50) ) / 2 , (screenHeight / 2), 50, GRAY);
    EndDrawing();
  }

  return 0;
}
