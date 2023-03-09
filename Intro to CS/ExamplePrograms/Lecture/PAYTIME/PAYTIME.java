public class PAYTIME
{
	public static void main( String[] args )
	{
		double hoursWorked = Double.parseDouble( args[ 0 ] );
		double ratePerHour = Double.parseDouble( args [ 1 ] );

		if ( hoursWorked < 0 || ratePerHour < 0 )
		{
			System.out.println( "Error!" );
		}
		else
		{
			double totalPay = hoursWorked * ratePerHour;
			System.out.println( "Your total pay is: $ " + totalPay );
		}
	}
}
