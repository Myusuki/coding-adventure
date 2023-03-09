/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author:
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {
		// WRITE YOUR CODE HERE
		int reviewerNum = Integer.parseInt( args[ 0 ] );
		int movieNum = Integer.parseInt( args[ 1 ] );

		int[] ratings = new int[ args.length - 2 ]; 
		for( int i = 0; i < args.length - 2; i++ )
		{
			ratings[ i ] = Integer.parseInt( args[ i + 2 ] );
		}

		int[][] ratingsTable = new int[ reviewerNum ][ movieNum ];

		int ratingIndex = 0;
		for( int rows = 0; rows < ratingsTable.length; rows++ )
		{
			for( int columns = 0; columns < ratingsTable[ rows ].length; columns++ )
			{
				ratingsTable[ rows ][ columns ] = ratings[ ratingIndex ];
				ratingIndex++;
			}
		}
		
		int[] movieRatingSum = new int[ movieNum ];
		for( int columns = 0; columns < movieNum; columns++ )
		{
			for( int rows = 0; rows < reviewerNum; rows++ )
			{
				movieRatingSum[ columns ] += ratingsTable[ rows ][ columns ];
			}
		}
		
		int large = movieRatingSum[ 0 ];
		int performantMovieIndexNum = 0;
		for( int sumIndex = 0; sumIndex < movieRatingSum.length; sumIndex++ )
		{
			if( movieRatingSum[ sumIndex ] > large)
			{
				large = movieRatingSum[ sumIndex];
				performantMovieIndexNum = sumIndex;
			}
		}

		System.out.println( performantMovieIndexNum );
		
	}
}
