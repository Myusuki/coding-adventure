public class BankTester
{
	public static void main( String[] args )
	{
		Bank user1 = new Bank( 100, "Rad", "Red" );

		System.out.println( user1.getBalance() );
		user1.deposit( 20 );
		System.out.println( user1.getBalance() );
		System.out.println( user1.getFname() );
	}
}
