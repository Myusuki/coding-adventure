public class Add2 
{
	public static void main( String[] args )
	{
		StdOut.print( "Type an integer: " );
		int num1 = StdIn.readInt();
		StdOut.print( "Type an integer: " );
		int num2 = StdIn.readInt();

		int sum = num1 + num2;
		StdOut.println( "The sum is: " + sum );
	}
}
