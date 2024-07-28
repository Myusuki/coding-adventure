#include <SDL2/SDL.h>
#include <stdio.h>

const int screenWidth = 640;
const int screenHeight = 480;

int main( int argc, char *argv[] )
{
  // window to be rendered to 
  SDL_Window* window = NULL;
  // surface contained by the window 
  SDL_Surface* screenSurface = NULL;

  if( SDL_Init(SDL_INIT_VIDEO) < 0 )
    printf( "SDL could not be initialized! SDL Error: %s\n", SDL_GetError() );

  

  return 0;
}
