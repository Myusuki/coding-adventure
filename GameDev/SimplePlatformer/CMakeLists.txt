cmake_minimum_required(VERSION 3.11)

set(CMAKE_C_STANDARD 11)

project(SimplePlatformer VERSION 0.0.1 LANGUAGES C)

add_executable(SimplePlatformer "main.c")

find_package(tmx REQUIRED)
find_package(raylib 5.5 REQUIRED)

target_link_libraries(SimplePlatformer PRIVATE tmx raylib)

# The following libs should be transitively imported by raylib...
find_package(Threads REQUIRED)
target_link_libraries(SimplePlatformer PRIVATE Threads::Threads)
if(UNIX)
  find_package(X11 REQUIRED)
  target_link_libraries(SimplePlatformer PRIVATE X11::X11)
endif()
