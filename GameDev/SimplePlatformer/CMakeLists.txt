cmake_minimum_required(VERSION 3.11)

set(CMAKE_C_STANDARD 11)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY "../")
project(SimplePlatformer VERSION 0.0.1 LANGUAGES C)

set(CMAKE_CXX_FLAGS_DEBUG_INIT "-Wall -g")
set(CMAKE_CXX_FLAGS_RELEASE_INIT "-Wall")

add_executable(SimplePlatformer "main.c")

find_package(raylib 5.5 REQUIRED)
find_package(tmx REQUIRED)

target_link_libraries(SimplePlatformer PRIVATE tmx raylib)

if(UNIX)
  find_package(X11 REQUIRED)
  target_link_libraries(SimplePlatformer PRIVATE X11)
endif()
