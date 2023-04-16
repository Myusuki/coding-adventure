public class Point
{
	private double x;
	private double y;

	public Point()
	{
		x = 0;
		y = 0;
	}
	/* public Point( double xVal, double yVal )
	{
		x = xVal;
		y = yVal;
	} */
	public Point( double x, double y )
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return this.x; // or return x
	}
	public double getY()
	{
		return y; // or return this.y
	}

	public void sety( double yVal )
	{
		this.y = yVal;
	}
	public void setX( double xVal )
	{
		this.x = xVal;
	}

	public double findSlope( Point p )
	{
		double yDiff = this.y - p.getY();
		double xDiff = x - p.x;
		return yDiff / xDiff;
	}
	public Point findMidPoint( Point other )
	{
		double midX = ( this.x + other.getX() ) / 2;
		double midY = ( this.y + other.getY() ) / 2;

		return new Point( midX, midY );
	}
	public double findDistanceFromOrigin()
	{
		double distance = Math.sqrt( x*x + y*y);
		return distance;
	}
	public double findDistanceBetween( Point other )
	{
		double deltaXSquared = Math.pow( ( this.x - other.x), 2 );
		double deltaYSquared = Math.pow( ( this.y - other.y ), 2 );
		double distance = Math.sqrt( deltaXSquared + deltaYSquared );
		return distance;
	}
	
	public String toString()
	{
		String s = "";
		s += "(" + x + ", " + y + ")";
		return s;
	}

	public boolean equals( Object obj)
	{
		if( !( obj instanceof Point ) )
		{
			return false;
		}
		else
		{
			Point p = ( Point ) obj;
			return ( this.x == p.x && this.y == p.y );
		}
	}
}
