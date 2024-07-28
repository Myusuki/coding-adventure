#include <stdio.h>
#include <stdbool.h>

int main(void)
{
  bool valid = true;
  bool invalid = false;

  if( valid )
    printf( "I'm valid!\n" );
  if( invalid )
    printf( "I'm invalid!\n" );

  if( !valid )
    printf( "I was valid but am now invalid\n" );
  if( !invalid )
    printf( "I was invalid but am now valid\n" );
  return 0;
}
