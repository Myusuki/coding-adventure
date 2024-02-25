#include <stdio.h>
#include <string.h>

void NameCheckAndProcess(char name[]);

int main(void)
{
	// Player info
	long int player1Points = 0, player2Points = 0, player3Points = 0, player4Points = 0;
	int maxNameLength = 25;
	char player1Name[maxNameLength], player2Name[maxNameLength], player3Name[maxNameLength], player4Name[maxNameLength];

	// Game info
	long int startingScore = 0, targetScore = 0;

	printf( "What is the starting score: " );
	scanf( "%ld", &startingScore );
	printf( "What is the target score: " );
	scanf( "%ld", &targetScore );
	// get rid of newline character after inputting targetScore
	getchar();

	// Ask for player names if no name entered then just use Player 1, 2, etc
	printf( "Name for player 1 (press Enter for default name): " );
	fgets(player1Name, maxNameLength, stdin);
	if( strcmp(player1Name, "\n") == 0 )
		strncpy(player1Name, "Player 1", 25);
	printf( "Name for player 2 (press Enter for default name): " );
	fgets(player2Name, maxNameLength, stdin);
	if( strcmp(player2Name, "\n") == 0 )
		strncpy(player2Name, "Player 2", 25);
	printf( "Name for player 3 (press Enter for default name): " );
	fgets(player3Name, maxNameLength, stdin);
	if( strcmp(player3Name, "\n") == 0 )
		strncpy(player3Name, "Player 3", 25);
	printf( "Name for player 4 (press Enter for default name): " );
	fgets(player4Name, maxNameLength, stdin);
	if( strcmp(player4Name, "\n") == 0 )
		strncpy(player4Name, "Player 4", 25);

	// Assign starting score to players 
	player1Points = player2Points = player3Points = player4Points = startingScore;
	
	// get rid of newline character in names and replace with null byte
	if( player1Name[strlen(player1Name) - 1] == '\n' )
		player1Name[strlen(player1Name) - 1] = '\0';
	if( player2Name[strlen(player2Name) - 1] == '\n' )
		player2Name[strlen(player2Name) - 1] = '\0';
	if( player3Name[strlen(player3Name) - 1] == '\n' )
		player3Name[strlen(player3Name) - 1] = '\0';
	if( player4Name[strlen(player4Name) - 1] == '\n' )
		player4Name[strlen(player4Name) - 1] = '\0';

	// display name and score
	printf( "%s: %ld\n", player1Name, player1Points );
	printf( "%s: %ld\n", player2Name, player2Points );
	printf( "%s: %ld\n", player3Name, player3Points );
	printf( "%s: %ld\n", player4Name, player4Points );

	return 0;
}

