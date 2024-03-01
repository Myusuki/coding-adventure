#include <stdio.h>
#include <string.h>
#include <stdbool.h>

struct player
{
	char name[27];
	long int points;
};


// players enter their names and leads to processing 
void EnterName( struct player playerArr[], int maxNameLength, int numOfPlayers );

// processes name of players
void NameProcessor( char name[], int playerNum );

// checks name of players against each other to prevent duplicates 
bool NameCheck( char name[], struct player playerArr[], int namesAvailable );


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
	EnterName(players, maxNameLength, 4);

	// Assign starting score to players 
	players[0].points = players[1].points = players[2].points = players[3].points = startingScore;
	
	// display name and score
	printf( "%s: %ld\n", players[0].name, players[0].points );
	printf( "%s: %ld\n", players[1].name, players[1].points);
	printf( "%s: %ld\n", players[2].name, players[2].points );
	printf( "%s: %ld\n", players[3].name, players[3].points );


	return 0;
}

void EnterName( struct player playerArr[], int maxNameLength, int numOfPlayers )
{
	for( int i = 0; i < numOfPlayers; i++ )
	{
		printf( "Name for player %d (press Enter for default name): ", (i + 1) );
		if( i == 0 )
		{
			fgets(playerArr[0].name, maxNameLength, stdin);
			NameProcessor(playerArr[0].name, (i + 1) );
		}
		else
		{
			bool namingConflict = false;

			do
			{
				fgets(playerArr[i].name, maxNameLength, stdin);
				NameProcessor(playerArr[i].name, (i + 1) );
				namingConflict = NameCheck(playerArr[i].name, playerArr, i);
				if( namingConflict == true )
				{
					printf( "Sorry you're name is already taken by another player. Please choose a different name: " );
					continue;
				}
			} while(  NameCheck(playerArr[i].name, playerArr, i) != false );
		} 
	}
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

bool NameCheck( char name[], struct player playerArr[], int namesAvailable)
{
	bool nameConflict = false;
	for( int i = 0; i < namesAvailable; i++ )
	{
		if( strcmp(name, playerArr[i].name) == 0 )
			nameConflict = true;
	}
	return nameConflict;
}
