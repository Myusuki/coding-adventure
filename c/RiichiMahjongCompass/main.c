#include <stdio.h>
#include <string.h>
#include <stdbool.h>

struct player
{
	char name[27];
	long int points;
};

// processes name of players
void NameProcessor( char name[], int playerNum );

// checks name of players against each other to prevent duplicates 
bool NameCheck( char name[], char playerArr );

int main(void)
{
	// Players 
	struct player player1, player2, player3, player4;

	int maxNameLength = 27;

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
	fgets(player1.name, maxNameLength, stdin);
	NameProcessor(player1.name, 1);
	printf( "Name for player 2 (press Enter for default name): " );
	fgets(player2.name, maxNameLength, stdin);
	NameProcessor(player2.name, 2);
	printf( "Name for player 3 (press Enter for default name): " );
	fgets(player3.name, maxNameLength, stdin);
	NameProcessor(player3.name, 3);
	printf( "Name for player 4 (press Enter for default name): " );
	fgets(player4.name, maxNameLength, stdin);
	NameProcessor(player4.name, 4);

	// Assign starting score to players 
	player1.points = player2.points = player3.points = player4.points = startingScore;
	
	// display name and score
	printf( "%s: %ld\n", player1.name, player1.points );
	printf( "%s: %ld\n", player2.name, player2.points);
	printf( "%s: %ld\n", player3.name, player3.points );
	printf( "%s: %ld\n", player4.name, player4.points );

	return 0;
}

void NameProcessor(char name[], int playerNum )
{
	// Check if player wants default name
	if( strncmp(name, "\n", 1) == 0 )
	{
		switch( playerNum )
		{
			case 1:
				strcpy(name, "Player 1");
			break;
			case 2:
				strcpy(name, "Player 2");
			break;
			case 3:
				strcpy(name, "Player 3");
			break;
			case 4:
				strcpy(name, "Player 4");
			break;
		}
	}
	// Change newline byte at end of string to null byte
	if( name[strlen(name) - 1] == '\n' )
		name[strlen(name) - 1] = '\0';
}
