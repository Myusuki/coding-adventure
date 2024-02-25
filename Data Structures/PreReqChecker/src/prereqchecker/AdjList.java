package prereqchecker;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }

        // WRITE YOUR CODE HERE
        StdIn.setFile( args[0] );
        StdOut.setFile( args[1] );

        int courseAmount = StdIn.readInt();
        CourseNode courses[] = new CourseNode[courseAmount];
        for( int i = 0; i < courseAmount; i++ )
        {
            String courseName = StdIn.readString();
            CourseNode newCourse = new CourseNode(courseName, null);
            courses[i] = newCourse;
            // StdOut.println( courses.get(i).getCourseName() );
        }

        int connections = StdIn.readInt();

        for( int i = 0; i < connections; i++ )
        {
            String targetCourse = StdIn.readString();
            String prereqCourse = StdIn.readString();

            for( int j = 0; j < courseAmount; j++ )
            {
                if( courses[j].getCourseName().equals(targetCourse) )
                {
                    CourseNode node = courses[j];
                    CourseNode newEdge = new CourseNode(prereqCourse, null);
                    while( node.getNextCourse() != null )
                    {
                        node = node.getNextCourse();
                    }

                    node.setNextCourse(newEdge);
                    break;
                }
            }
        }

        for( int i = 0; i < courseAmount; i++ )
        {
            CourseNode node = courses[i];
            do
            {
                StdOut.print( node.getCourseName() + " " );
                node = node.getNextCourse();
            } while( node != null );
            StdOut.print("\n");
        }

    }
}