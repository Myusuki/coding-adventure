public class NumProbs {
   /*
   Method code not included here. 
   */
	public static void main(String[] args){
        System.out.print ("Enter positive integer to check factorial: ");
        int number= StdIn.readInt();
        //call factorial method
        long result = factorial(number);
        System.out.println(number + "! is: " + result);

        System.out.print ("Enter integer base: ");
        int base = StdIn.readInt();
        System.out.print ("Enter integer exponent: ");
        int exp = StdIn.readInt();
        result = pow(base,exp);
        System.out.println(base + " to the power of " + exp + " = " + result);
        
        System.out.print ("Enter positive integer to check digits and proper factors: ");
        int n = StdIn.readInt();
        System.out.println("The number of digits in " + n + " is " + numDigs(n) );
        System.out.println("The number of proper factors of " + n + " is " + numProperFactors(n));
        System.out.println("The proper factors of " + n + ": " + properFactors(n));
        
        System.out.print("Enter number to check prime: ");
        int num = StdIn.readInt();
        System.out.println("is prime: " + isPrime(num));
      }

    /* method to find factorial of n
       returns the factorial of its int parameter n
    */
    public static long factorial(int n){
      long product = 1; 
			for( int i = 1; i <= n; i++ )
			 {
				 product *= i;
			 }
       return product;
    }
    

    /* method to find x ^ nth power
       returns the value of x^n where x and n are int parameters
    */
    public static long pow( int x, int n){
			long product = 1;
			for( long i = 1; i <= n; i++ )
			{
				product *= x;
			}
       return product;
    }
    

    /* method to find number of digits in n
       returns the number of digits in its int parameter n
		  Precondition: n > 0
    */
    public static int numDigs(int n){
 			int count = 0;
			while( n > 0 )
			{
				count++;
				n /= 10;
			}
      return count;
    }


   /*
      returns the number of proper factors of its positive integer parameter, n
      factors of n not including 1 or n
   */
   public static int numProperFactors(int n){
		int count = 0;
		for( int i = 2; i < n; i++ )
		{
			if( n % i == 0 )
			{
				count++;
			}
		}
      
      return count;
   }
   /*
    * return a String representation of proper factors of n
    */
    public static String properFactors(int n){
      String s = "";
			for( int i = 2; i < n; i++ )
			{
				if( n % i == 0)
				{
					s = s + i + " ";
				}
			}
      return s;
    
    }

    public static boolean isPrime(int n){
			if( n == 1 )
			{
				return false;
			}
			
			for( int i = 2; i < n; i++ )
			{
				if( n % i == 0 )
				{
					return false;
				}
			}
			return true;
    }
}

	 
   	  

