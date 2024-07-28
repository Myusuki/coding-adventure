#include <stdio.h>
#include <stdbool.h>

struct Santa
{
  long int posx;
  long int posy;
};

struct RoboSanta
{
  long int posx;
  long int posy;
};

// check if house has been visited before and append coordinates if haven't visited before
bool VisitedHouse( FILE *houses, char *filename, long int posx, long int posy );
void AppendCoordinates( FILE *coordinates, char *filename, long int posx, long int posy );

int main()
{
  // declare structs
  FILE *instructions;
  FILE *visitedCoordinates;
  struct Santa santa = {0};
  struct RoboSanta roboSanta = {0};

  // init structs
  instructions = fopen("Instructions.txt", "r");

  // coordinates
  long int posX = 0, posY = 0;
  santa.posx = posX;
  santa.posy = posY;
  roboSanta.posx = posX;
  roboSanta.posy = posY;

  int housesVisited = 1;
  int turn = 0;
  char direction;


  while( !feof(instructions) )
  {
    fscanf(instructions, "%c", &direction);

    switch( direction )
    {
      case '^':
        posY++;
      break;
      case 'v':
        posY--;
      break;
      case '>':
        posX++;
      break;
      case '<':
        posX--;
      break;
    }

    if( turn == 0 )
    {
      santa.posx += posX;
      santa.posy += posY;

      if( !VisitedHouse(visitedCoordinates, "Coordinates.txt", santa.posx, santa.posy) )
      {
        AppendCoordinates(visitedCoordinates, "Coordinates.txt", santa.posx, santa.posy);
        housesVisited++;
      }
      turn = 1;
    }
    else if( turn == 1 )
    {
      roboSanta.posx += posX;
      roboSanta.posy += posY;

      if( !VisitedHouse(visitedCoordinates, "Coordinates.txt", roboSanta.posx, roboSanta.posy) )
      {
        AppendCoordinates(visitedCoordinates, "Coordinates.txt", roboSanta.posx, roboSanta.posy);
        housesVisited++;
      }
      turn = 0;
    }

    posX = 0;
    posY = 0;
  }

  printf( "Houses visited: %d\n", housesVisited );

  fclose(instructions);
  return 0;
}

bool VisitedHouse( FILE *houses, char *filename, long int posx, long int posy )
{
  long int x = 0, y = 0;
  bool visited = false;
  houses = fopen(filename, "r");
  while( !feof(houses) )
  {
    fscanf(houses, "%ld %ld", &x, &y);
    if( x == posx && y == posy )
      visited = true;
  }
  fclose(houses);
  return visited;
}

void AppendCoordinates( FILE *coordinates, char *filename,long int posx, long int posy )
{
  coordinates = fopen(filename, "a");
  fprintf(coordinates, "%ld %ld\n", posx, posy);
  fclose(coordinates);
}
