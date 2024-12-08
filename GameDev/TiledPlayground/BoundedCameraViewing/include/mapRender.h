#ifndef MAPRENDER_H
#define MAPRENDER_H

#include <raylib.h>
#include <tmx.h>

// display dimensions
#define DISPLAY_H 600
#define DISPLAY_W 800

void render_map(tmx_map *map); // main render function to call
void draw_all_layers(tmx_map *map, tmx_layer *layers);

// draw tile layer
void draw_tile_layer(tmx_map *map, tmx_layer *layer);
void draw_tile(void *image, unsigned int sourceX, unsigned int sourceY, unsigned int sourceWidth, unsigned int sourceHeight,
               unsigned int destX, unsigned int destY, float opacity, unsigned int flags);

void draw_image_layer(tmx_image *image);

#define LINE_THICKNESS 2.5
// void draw_objects(tmx_object_group *objgr);
// void draw_polygon(double offset_x, double offset_y, double **points, int points_count, Color color);
// void draw_polyline(double offset_x, double offset_y, double **points, int points_count, Color color);

Color int_to_color(int color);

#endif
