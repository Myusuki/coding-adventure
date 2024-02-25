#include <stdio.h>
#include <string.h>
#include <strings.h>
#define Q "His Hamlet was funny without being vulgar."

int main(void)
{
	printf( "%s\nhas %lu characters.\n", Q, strlen(Q) );
	return 0;
}
