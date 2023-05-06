public class RBS
{
	public static void main( String[] args )
	{
		
	}
}

public static int RecursiveSearch( int[] arr, int target, int l, int r )
{
	int mid = (r - l)/ 2;
	if( l == r && arr[ mid ] != target )
	{
		return -1; 
	}
	if( arr[ mid ] == target )
	{
		return mid;
	}
	if( arr[ mid ] > target )
	{
		r = m - 1;
		return RecursiveSearch( int[] arr, int target, int l , int r );
	}
	if( arr[ mid ] < target )
	{
		l = mid + 1;
		return RecursiveSearch( int[] arr, int target, int l, int r );
	}
	return -1;
}
