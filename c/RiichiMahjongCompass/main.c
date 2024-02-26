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
	struct player players[4];

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
	fgets(players[0].name, maxNameLength, stdin);
	NameProcessor(players[0].name, 1);
	printf( "Name for player 2 (press Enter for default name): " );
	fgets(players[1].name, maxNameLength, stdin);
	NameProcessor(players[1].name, 2);
	printf( "Name for player 3 (press Enter for default name): " );
	fgets(players[2].name, maxNameLength, stdin);
	NameProcessor(players[2].name, 3);
	printf( "Name for player 4 (press Enter for default name): " );
	fgets(players[3].name, maxNameLength, stdin);
	NameProcessor(players[3].name, 4);

	// Assign starting score to players 
	players[0].points = players[1].points = players[2].points = players[3].points = startingScore;
	
	// display name and score
	printf( "%s: %ld\n", players[0].name, players[0].points );
	printf( "%s: %ld\n", players[1].name, players[1].points);
	printf( "%s: %ld\n", players[2].name, players[2].points );
	printf( "%s: %ld\n", players[3].name, players[3].points );

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
