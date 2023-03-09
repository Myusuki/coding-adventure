import java.awt.Color;

public class Square
{
	public static void main( String[] args )
	{
		StdDraw.setPenRadius( 0.02 );
		StdDraw.setScale( 0, 2 );
		StdDraw.setPenColor( Color.BLUE );
		
		double halfLength = 0.7;
		/* for( int i = 0; i < 5; i++ )
		{
			int r = ( int ) (Math.random() * 255);
			int g = ( int ) (Math.random() * 255);
			int b = ( int ) (Math.random() * 255);
			StdDraw.setPenColor( r, g, b );
			StdDraw.square( 1, 1, halfLength - 0.15 * i );
		} */ 
		double x = 0.5;
		double y = 1.5;
		for( int i = 0; i < 5; i++ )
		{
			int r = ( int ) (Math.random() * 255);
			int g = ( int ) (Math.random() * 255);
			int b = ( int ) (Math.random() * 255);
			StdDraw.setPenColor( r, g, b );
			StdDraw.square( x, y, halfLength );
			x = x + 0.25;
			y = y - 0.25;
		} 

	}
}
