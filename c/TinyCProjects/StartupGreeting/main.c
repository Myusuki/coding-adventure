#include <stdio.h>
#include <time.h>


int main( int argc, char *argv[] )
{
  // a long int containing the amount of seconds since Jan 1, 1970 midnight UTC
  time_t now;
  time(&now);

  printf( "The computer thinks the time is %ld, but it's actually %s", now, ctime(&now) );

  struct tm *clock;
  time(&now);
  clock = localtime(&now);
  // printf( "Day of the year: %d\n", clock -> tm_yday );
  // printf( "Day of the week: %d\n", clock -> tm_wday );
  // printf( "Year: %d\n", clock -> tm_year + 1900 );
  // printf( "Month: %d\n", clock -> tm_mon + 1 );
  // printf( "Day of the month: %d\n", clock -> tm_mday );
  // printf( "Hour: %d\n", clock -> tm_hour );
  // printf( "Minute: %d\n", clock -> tm_min );
  // printf( "Second: %d\n", clock -> tm_sec );

  char time_string[64];
  int hour = clock -> tm_hour;
  printf( "Good " );
  if( hour < 12 )
    printf( "morning" );
  else if( hour < 17 )
    printf( "afternoon" );
  else 
    printf( "evening" );

  if( argc < 2 )
    printf( ", sexy~\n" );
  else
    printf( ", %s!\n", argv[1] );

  strftime( time_string, 64, "Today is %a, %b %d, %Y%nIt is %R%n", clock );
  printf( "%s", time_string );

  return 0;
}
