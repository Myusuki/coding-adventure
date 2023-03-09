//PROBLEM FROM CLASS

 public class ExamAvg
{
    public static void main( String[] args )
		{
        int[][] arr2D = { {56, 78, 67}, {79, 92, 83}, {90, 89, 79}, {51, 67, 84} };
        for( int row = 0; row < arr2D.length; row++ )
				{
            for( int col =0; col < arr2D[row].length; col++ )
						{
                System.out.print( arr2D[ row ][ col ] + "\t" );
            }
            System.out.println();
        }

        //finding the exam average
        double[] examAvgs = new double[ arr2D.length ];
        
        for( int row = 0; row < arr2D.length; row++ )
				{
            double sum = 0.0;
            for( int col = 0; col < arr2D[ row ].length; col++ )
						{ 
                sum += arr2D[ row ][ col ];
            }
            examAvgs[row] = sum/arr2D[row].length;
        }
        System.out.println("Exam Averages");
        for( int i = 0; i < examAvgs.length; i++ )
				{
            System.out.print( examAvgs[ i ] + " " );
        }
        System.out.println();

        //finding student averages
        double[] studentAvgs = new double[ arr2D[ 0 ].length ];

        for( int col = 0; col <arr2D[0].length; col++ )
				{
            double sum = 0;
            for(int row = 0; row < arr2D.length; row++){
                sum += arr2D[row][col];
            }
            studentAvgs[col] = sum/arr2D.length;
        }

        System.out.println("Student Averages");
        for(int i = 0; i < studentAvgs.length; i++){
            System.out.print(studentAvgs[i]+ " ");
        }
        System.out.println();


    }
}
