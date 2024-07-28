#include <stdio.h>
#include <stdbool.h>

bool VisitedHouse( FILE *houses, char *filename, long int posx, long int posy );
void AppendCoordinates( FILE *coordinates, char *filename, long int posx, long int posy );

int main()
{
  FILE *instructions;
  FILE *visitedCoordinates;

  char direction;

  long int posX = 0, posY = 0;
  int housesVisited = 1;

  instructions = fopen("Instructions.txt", "r");

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

    if( !VisitedHouse(visitedCoordinates, "Coordinates.txt",posX, posY) )
    {
      AppendCoordinates(visitedCoordinates, "Coordinates.txt",posX, posY);
      housesVisited++;
    }
    else 
      continue;   
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
