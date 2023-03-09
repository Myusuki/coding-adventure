public class Methods {
   public static void main(String[] args){
    System.out.print("How many items in array?" );
    int n = StdIn.readInt();
    //create array
    double[] a = create(n);
    double[] b = {9,8,7,6};

    //print array elements
    System.out.println("Array a");
    printArray(a);
    System.out.println("Array b");
    printArray(b);
    
     
    double sum = findSum(a);
    System.out.println("Sum of values in the array is: " + sum);
    //add method findAverage
    System.out.println("The average of values in array is: " + findAverage(a));
    
    //Shuffle values in array - add method shuffleArray
    shuffleArray(a);
    System.out.println("The array shuffled is: ");
    printArray(a);
    

    //add method findLargest
    System.out.println("The largest value in the array is: " + findLargest(b));
     //add method findSmallest
    System.out.println("The smallest value in the array is: " + findSmallest(b));
  
    //add method copyArray
    double[] aCopy = copyArray(a);
    System.out.print("The copy is ");
    printArray(aCopy); 

     //add method findLargestIndex
    System.out.println("The index of the largest value in the array is: " + findLargestIndex(a));
       
    //add method reverseArray
    double[] reversed = reverseArray(a);
    System.out.println ("reversed array");
    printArray(reversed); 
  }
   //Precondition: n > 0
   //Returns array of length n
  public static double[] create(int n){
		double[] arr = new double[n];
		for (int i = 0; i < n; i++){
			 arr[i] = i;
		}
		return arr; 
  }

   //Prints contents of an array
  public static void printArray(double[] arr){
		for (double elt : arr){
			 System.out.print(elt + "   ");
		}
    System.out.println();
   }

	public static double findSum( double[] x )
	{
		double sum = 0.0;
		for( double y: x )
		{
			sum += y;
		}
		return sum;
	}

	public static double findAverage( double[] x )
	{
		double avg = findSum( x ) / x.length;
		return avg;
	}
   //Shuffles elements in an array
  public static void shuffleArray(double[] arr){
		for( int i = 0; i < arr.length; i++ )
		{
			int rando = ( int )( Math.random() * arr.length );
			double tempNum = arr[ i ];
			arr[ i ] = arr[ rando ];
			arr[ rando ] = tempNum;
		}
  }

	public static double findLargest( double[] arr )
	{
		double large = arr[ 0 ];
		for( double x: arr )
		{
			if( x > large)
				large = x;
		}
		return large;
	}

	public static double findSmallest( double[] arr )
	{
		double small = arr[ 0 ];
		for( double x: arr )
		{
			if( x < small )
				small = x;
		}
		return small;
	}

	public static double[] copyArray( double[] arr ) 
	{
		double[] copy = new double[ arr.length ];
		for( int i = 0; i < arr.length; i++ )
		{
			copy[ i ] = arr[ i ];
		}

		return copy;
	}

	public static int findLargestIndex( double[] arr )
	{
		double large = arr[ 0 ];
		int index = 0;
		for( int i = 0; i < arr.length; i++ )
		{
			if( arr[ i ] > large)
			{
				large = arr[ i ];
				index = i;
			}
		}
		return index;
	}

	public static double[] reverseArray( double[] arr )
	{
		double[] reversed = new double[ arr.length ];
		int position = 0;
		for( int i = arr.length - 1; i >= 0; i-- )
		{
			reversed[ position ] = arr[ i ];
			position++;
		}
		return reversed;
	}

}
