import java.awt.Color;

public class Triangle
{
	public static void main( String[] args )
	{
		double c = Math.sqrt( 3.0 ) / 2.0;
		
		StdDraw.setPenRadius( 0.02 );
		StdDraw.setPenColor( Color.GREEN );
		StdDraw.setScale( 0, 1 ); 

		StdDraw.line(0, 0, 1, 0);
		StdDraw.line(1, 0, 0.5, c);
		StdDraw.line(0.5, c, 0, 0);

		StdDraw.setPenColor( Color.BLUE );
		StdDraw.line( 0, c, 1, c );
		StdDraw.line( 1, c, 0.5, 0 );
		StdDraw.line( 0.5, 0, 0, c );

		StdDraw.point( 0.5, c/3 );
		StdDraw.text( 0.5, 0.5, "Hello, World" );
	}
}
