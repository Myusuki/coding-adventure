public class Classroom{
    public static void main(String[] args){
        int numRows = Integer.parseInt (args[0] );
        int numCols = Integer.parseInt(args[1]);

        String[] studentLine = new String[numRows * numCols];
        String[][] classroom = new String[numRows][numCols];

        int numStudents = numRows * numCols;

        for(int i = 0; i < numStudents; i++){
            studentLine[i]  = args[i + 2];
        }
        System.out.print("Student line:");
        for (String elt : studentLine){
            System.out.print(elt + " ");
        }
        System.out.println();

        int count = 0;
        for(int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                classroom[row][col]= studentLine[count];
                count++;
            }
        }

        System.out.println("Classroom");
        for (int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                System.out.print (classroom[row][col] + "\t");
            }
            System.out.println();
        }

        System.out.println("Student line leaving class");
        count = 0;
        for(int col = 0; col < numCols; col++){
            for(int row = 0; row < numRows; row++){
                studentLine[count] = classroom[row][col];
                count++;
            }
        }

        for (String elt : studentLine){
            System.out.print(elt + " ");
        }
        System.out.println();
    }
}
