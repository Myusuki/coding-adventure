public class FindRingArea
{
	public static void main( String[] args )
	{
		double radius1 = 0;
		double radius2 = 0;

		do 
		{
			System.out.print( "Enter radius 1: " );
			radius1 = StdIn.readDouble();

			System.out.print( "Enter radius 2: " );
			radius2 = StdIn.readDouble();

			if( radius1 < 0 || radius2 < 0 )
			{
				System.out.println( "Invalid radius!!" );
			}
		} while( radius1 < 0 || radius2 < 0 );
		double area1 = FindArea( radius1 );
		double area2 = FindArea( radius2 );

		double areaRing = Math.abs( area1 - area2 );
		System.out.println( "The area of the ring is: " + areaRing );
	}

	public static double FindArea( double r )
	{
		return Math.PI * r * r;
	}
}
