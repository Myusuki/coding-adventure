#include <stdio.h>
#include <raylib.h>
#include <tmx.h>

#define windowWidth 800
#define windowHeight 600

int main(void)
{
  // InitWindow(windowWidth, windowHeight, "Tiled Playground");
  // SetTargetFPS(60);

  tmx_map *map = tmx_load("./assets/GameBoyTest.tmx");
  char *formatVersion = map->format_version;
  char *classString = map->class_type; // NULL if not user defined or found in tmx file
  int orientation = map->orient; // enums default to 0 for the first enum member
  unsigned int mapWidth = map->width; // width is in cells not px
  unsigned int mapHeight = map->height; // height is in cells not px
  unsigned int tileWidth = map->tile_width;
  unsigned int tileHeight = map->tile_height;
  int mapStaggerIndex = map->stagger_index;
  int mapStaggerAxis = map->stagger_axis;
  unsigned int backgroundColor = map->backgroundcolor;
  int renderOrder = map->renderorder;
  tmx_properties *mapProperties = map->properties;
  tmx_tileset_list *tilesetHead = map->ts_head;
  tmx_layer *layerHead = map->ly_head;
  unsigned int mapTilecount = map->tilecount;
  tmx_tile **mapTiles = map->tiles;



  while( tilesetHead != NULL )
  {
    printf( "%s\n", tilesetHead->source);
    tilesetHead = tilesetHead->next;
  }
  while( layerHead != NULL )
  {
    printf( "%s\n", layerHead->name );
    layerHead = layerHead->next;
  }
  printf("%d\n", mapTilecount );





  return 0;
}

