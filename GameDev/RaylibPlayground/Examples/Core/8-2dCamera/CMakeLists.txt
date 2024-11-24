cmake_minimum_required(VERSION 3.11)
project(2DCamera)

add_executable(2DCamera "main.c")

find_package(raylib CONFIG REQUIRED)

target_link_libraries(2DCamera PRIVATE raylib)

if(UNIX)
  find_package(X11 REQUIRED)
  target_link_libraries(2DCamera PRIVATE X11:X11)
endif()
