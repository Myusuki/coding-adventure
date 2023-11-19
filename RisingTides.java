package tides;

import java.util.ArrayList;

/**
 * This class contains methods that provide information about select terrains 
 * using 2D arrays. Uses floodfill to flood given maps and uses that 
 * information to understand the potential impacts. 
 * Instance Variables:
 *  - a double array for all the heights for each cell
 *  - a GridLocation array for the sources of water on empty terrain 
 * 
 * @author Original Creator Keith Scharz (NIFTY STANFORD) 
 * @author Vian Miranda (Rutgers University)
 */
public class RisingTides {

    // Instance variables
    private double[][] terrain;     // an array for all the heights for each cell
    private GridLocation[] sources; // an array for the sources of water on empty terrain 

    /**
     * DO NOT EDIT!
     * Constructor for RisingTides.
     * @param terrain passes in the selected terrain 
     */
    public RisingTides(Terrain terrain) {
        this.terrain = terrain.heights;
        this.sources = terrain.sources;
    }

    /**
     * Find the lowest and highest point of the terrain and output it.
     * 
     * @return double[][], with index 0 and index 1 being the lowest and 
     * highest points of the terrain, respectively
     */
    public double[] elevationExtrema() {

        /* WRITE YOUR CODE BELOW */
		double high = terrain[ 0 ][ 0 ];
		double low = terrain[ 0 ][ 0 ];
        double[] extremas = new double [2];
        for( int rows = 0; rows < terrain.length; rows++ )
        {
            for( int columns = 0; columns < terrain[ rows ].length; columns++ )
            {
							if( terrain[ rows ][ columns ] > high )
								high = terrain[ rows ][ columns ];

							if( terrain[ rows ][ columns ] < low ) 
								low = terrain[ rows ][ columns ];
            }
        }

				extremas[0] = low;
				extremas[1] = high;

        return extremas; // substitute this line. It is provided so that the code compiles.
    }

    /**
     * Implement the floodfill algorithm using the provided terrain and sources.
     * 
     * All water originates from the source GridLocation. If the height of the 
     * water is greater than that of the neighboring terrain, flood the cells. 
     * Repeat iteratively till the neighboring terrain is higher than the water 
     * height.
     * 
     * 
     * @param height of the water
     * @return boolean[][], where flooded cells are true, otherwise false
     */
    public boolean[][] floodedRegionsIn(double height) {
        
        /* WRITE YOUR CODE BELOW */
				boolean[][] resultingArray = new boolean[ terrain.length ][ terrain[0].length ];
				ArrayList<GridLocation> cell = new ArrayList<GridLocation>();
				for ( GridLocation x: sources )
				{
					cell.add(x);
					resultingArray[x.row][x.col] = true;
				}


				while( !cell.isEmpty() )
				{
					GridLocation checkCell = cell.get(0);
					int checkCellx = checkCell.col;
					int checkCelly = checkCell.row;
					cell.remove(0);
					
					// check if checkCellx is at a border index
					if( checkCellx == 0 )
					{
						// check if right neighbor is flooded 
						if( resultingArray[checkCelly][checkCellx + 1] == false )
						{
							// check height and flood 
							if( terrain[checkCelly][checkCellx + 1] <= height )
							{
								resultingArray[checkCelly][checkCellx + 1] = true;
								GridLocation floodtile = new GridLocation( checkCelly, (checkCellx + 1) );
								cell.add(floodtile);
							}
						}
					}
					// check if checkCellx is at a border index
					else if( checkCellx == (terrain[0].length - 1) )
					{
						// check if left neighbor is flooded 
						if( resultingArray[checkCelly][checkCellx - 1] == false )
						{
							// check height and flood 
							if( terrain[checkCelly][checkCellx - 1] <= height )
							{
								resultingArray[checkCelly][checkCellx - 1] = true;
								GridLocation floodtile = new GridLocation( checkCelly, (checkCellx - 1) );
								cell.add(floodtile);
							}
						}
					}
					else 
					{
						// check if right neighbor is flooded 
						if( resultingArray[checkCelly][checkCellx + 1] == false )
						{
							// check height and flood 
							if( terrain[checkCelly][checkCellx + 1] <= height )
							{
								resultingArray[checkCelly][checkCellx + 1] = true;
								GridLocation floodtile = new GridLocation( checkCelly, (checkCellx + 1) );
								cell.add(floodtile);
							}
						}
						// check if left neighbor is flooded 
						if( resultingArray[checkCelly][checkCellx - 1] == false )
						{
							// check height and flood 
							if( terrain[checkCelly][checkCellx - 1] <= height )
							{
								resultingArray[checkCelly][checkCellx - 1] = true;
								GridLocation floodtile = new GridLocation( checkCelly, (checkCellx - 1) );
								cell.add(floodtile);
							}
						}
					}

					// check if checkCelly is at a border index 
					if( checkCelly == 0 )
					{
						// check if bottom neighbor is flooded 
						if( resultingArray[checkCelly + 1][checkCellx] == false )
						{
							//check height and flood 
							if( terrain[checkCelly + 1][checkCellx] <= height )
							{
								resultingArray[checkCelly + 1][checkCellx] = true;
								GridLocation floodtile = new GridLocation( (checkCelly + 1), checkCellx );
								cell.add(floodtile);
							}
						}
					}
					else if( checkCelly == (terrain.length - 1) )
					{
						// check if top neighbor is flooded 
						if( resultingArray[checkCelly - 1][checkCellx] == false )
						{
							//check height and flood 
							if( terrain[checkCelly - 1][checkCellx] <= height )
							{
								resultingArray[checkCelly - 1][checkCellx] = true;
								GridLocation floodtile = new GridLocation( (checkCelly - 1), checkCellx );
								cell.add(floodtile);
							}
						}
					}
					else 
					{
						// check if bottom neighbor is flooded 
						if( resultingArray[checkCelly + 1][checkCellx] == false )
						{
							//check height and flood 
							if( terrain[checkCelly + 1][checkCellx] <= height )
							{
								resultingArray[checkCelly + 1][checkCellx] = true;
								GridLocation floodtile = new GridLocation( (checkCelly + 1), checkCellx );
								cell.add(floodtile);
							}
						}
						// check if top neighbor is flooded 
						if( resultingArray[checkCelly - 1][checkCellx] == false )
						{
							//check height and flood 
							if( terrain[checkCelly - 1][checkCellx] <= height )
							{
								resultingArray[checkCelly - 1][checkCellx] = true;
								GridLocation floodtile = new GridLocation( (checkCelly - 1), checkCellx );
								cell.add(floodtile);
							}
						}
					}
				}
				
			 	return resultingArray; // substitute this line. It is provided so that the code compiles.
    }

    /**
     * Checks if a given cell is flooded at a certain water height.
     * 
     * @param height of the water
     * @param cell location 
     * @return boolean, true if cell is flooded, otherwise false
     */
    public boolean isFlooded(double height, GridLocation cell) {
        
        /* WRITE YOUR CODE BELOW */
				
        return floodedRegionsIn(height)[cell.row][cell.col]; // substitute this line. It is provided so that the code compiles.
    }

    /**
     * Given the water height and a GridLocation find the difference between 
     * the chosen cells height and the water height.
     * 
     * If the return value is negative, the Driver will display "meters below"
     * If the return value is positive, the Driver will display "meters above"
     * The value displayed will be positive.
     * 
     * @param height of the water
     * @param cell location
     * @return double, representing how high/deep a cell is above/below water
     */
    public double heightAboveWater(double height, GridLocation cell) {
        
        /* WRITE YOUR CODE BELOW */
        return (terrain[cell.row][cell.col] - height); // substitute this line. It is provided so that the code compiles.
    }

    /**
     * Total land available (not underwater) given a certain water height.
     * 
     * @param height of the water
     * @return int, representing every cell above water
     */
    public int totalVisibleLand(double height) {
        
        /* WRITE YOUR CODE BELOW */
				int totalLand = 0;
				boolean landGrid[][] = new boolean[terrain.length][terrain[0].length];
				landGrid = floodedRegionsIn(height);
				for( int rows = 0; rows < terrain.length; rows++ )
				{
					for( int columns = 0; columns < terrain[0].length; columns++ )
					{
						if( landGrid[rows][columns] == false )
							totalLand++;
					}
				}
        return totalLand; // substitute this line. It is provided so that the code compiles.
    } 


    /**
     * Given 2 heights, find the difference in land available at each height. 
     * 
     * If the return value is negative, the Driver will display "Will gain"
     * If the return value is positive, the Driver will display "Will lose"
     * The value displayed will be positive.
     * 
     * @param height of the water
     * @param newHeight the future height of the water
     * @return int, representing the amount of land lost or gained
     */
    public int landLost(double height, double newHeight) {
        
        /* WRITE YOUR CODE BELOW */
				boolean oldLandGrid[][] = floodedRegionsIn(height);
				boolean newLandGrid[][] = floodedRegionsIn(newHeight);
				int totalOldLand = 0;
				int totalNewLand = 0;
				
				for( int rows = 0; rows < terrain.length; rows++ )
				{
					for( int columns = 0; columns < terrain[0].length; columns++ )
					{
						if( oldLandGrid[rows][columns] == false )
							totalOldLand++;
						if( newLandGrid[rows][columns] == false )
							totalNewLand++;
					}
				}
				
        return (totalNewLand - totalOldLand); // substitute this line. It is provided so that the code compiles.
    }

    /**
     * Count the total number of islands on the flooded terrain.
     * 
     * Parts of the terrain are considered "islands" if they are completely 
     * surround by water in all 8-directions. Should there be a direction (ie. 
     * left corner) where a certain piece of land is connected to another 
     * landmass, this should be considered as one island. A better example 
     * would be if there were two landmasses connected by one cell. Although 
     * seemingly two islands, after further inspection it should be realized 
     * this is one single island. Only if this connection were to be removed 
     * (height of water increased) should these two landmasses be considered 
     * two separate islands.
     * 
     * @param height of the water
     * @return int, representing the total number of islands
     */
    public int numOfIslands(double height) {
        
        /* WRITE YOUR CODE BELOW */
		
        return -1; // substitute this line. It is provided so that the code compiles.
    }
}
