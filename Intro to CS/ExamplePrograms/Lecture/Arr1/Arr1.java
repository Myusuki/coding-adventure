import java.util.Arrays;
public class Arr1
{
	public static void main(String[] args)
	{
		int[] arr = new int[args.length];

		for(int i = 0; i < args.length; i++)
		{
			arr[i] = Integer.parseInt(args[ i ]);
		}
		System.out.println(arr.length);
		for(int x: arr)
		{
			System.out.print(x + " ");
		}
		System.out.println();

		int large = arr[0];
		int small = arr[0];
		int largeIndex = 0;
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > large)
			{
				large = arr[i];
				largeIndex = i;
			}
		}
		for( int x: arr )
		{
			if( x < small )
			{
				small = x;
			}
		}

		int sum = 0;
		for( int x: arr )
		{
			sum += x;
		}
		double avg = (double)sum/arr.length;

		for( int i = arr.length - 1; i >= 0 ; i-- )
		{
			System.out.print( arr[ i ] + " " );
		}
		System.out.println();

		int len = arr.length;
		for(int i = 0; i < arr.length / 2; i++ )
		{
			int temp = arr[i];
			arr[i] = arr[len - 1 - i];
			arr[len - 1 - i] = temp;
		}

		for( int x: arr )
		{
			System.out.print( x + "" );
		}
		System.out.println();

		System.out.println( "Min Number = " + small );
		System.out.println( "Max Number = " + large + " at index " + largeIndex );
		System.out.println( "Average = " + avg);

	}
}
