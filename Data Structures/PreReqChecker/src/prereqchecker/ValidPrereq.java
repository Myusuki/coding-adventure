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
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {
// course2 os checkcourse
    public static boolean Valid( String startingCourse, String checkCourse, CourseNode[] list )
    {
        boolean found = false;
        CourseNode node = null;
        int i;
        for( i = 0; i < list.length; i++ )
        {
            if( list[i].getCourseName().equals(startingCourse) )
            {
                node = list[i];
                break;
            }
        }

        while( node != null )
        {
            if( node.getCourseName().equals(checkCourse) )
                return true;
            
            node = node.getNextCourse();
        }

        node = list[i];
        while( found == false && node.getNextCourse() != null )
        {
            found = Valid(node.getNextCourse().getCourseName(), checkCourse, list);
            node = node.getNextCourse();
        }

	    return found;
    }
    public static int findCourseIndex( CourseNode[] courseList, String courseID )
    {
        int index = -1;
        for( int i = 0; i < courseList.length; i++ )
        {
            if( courseList[i].getCourseName().equals(courseID) )
            {
                index = i;
                break;
            }
        }

        return index;
    }
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }
        // WRITE YOUR CODE HERE
        StdIn.setFile( args[0] );
        StdOut.setFile( args[2] );

        // adjlist code
        int courseAmount = StdIn.readInt();
        CourseNode courses[] = new CourseNode[courseAmount];
        for( int i = 0; i < courseAmount; i++ )
        {
            String courseName = StdIn.readString();
            CourseNode newCourse = new CourseNode(courseName, null);
            courses[i] = newCourse;
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

        StdIn.setFile( args[1] );
	    String firstCourse = StdIn.readString();
        String secondCourse = StdIn.readString();
        CourseNode course1 = null;
        CourseNode course2 = null;
        
        for( int i = 0; i < courseAmount; i++ )
        {
            if( courses[i].getCourseName().equals(firstCourse) )
                course1 = courses[i];
            
            if( courses[i].getCourseName().equals(secondCourse) )
                course2 = courses[i];
        }
        if( course1 == null || course2 == null )
        {
            StdOut.println( "NO" );
            return;
        }
        if( firstCourse.charAt(0) == secondCourse.charAt(0) )
        {
            if( firstCourse.charAt(0) == 'c' )
            {
                for( int i = 2; i < 5; i++ )
                {
                    if( firstCourse.charAt(i) < secondCourse.charAt(i) )
                    {
                        StdOut.println( "NO" );
                        return;
                    }
                    else if( firstCourse.charAt(i) > secondCourse.charAt(i) )
                    {
                        StdOut.println( "Yes" );
                        return;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
            else if( firstCourse.charAt(0) == 'm' )
            {
                for( int i = 3; i < 6; i++ )
                {
                    if( firstCourse.charAt(i) < secondCourse.charAt(i) )
                    {
                        StdOut.println( "NO" );
                        return;
                    }
                    else if( firstCourse.charAt(i) > secondCourse.charAt(i) )
                    {
                        StdOut.println( "Yes" );
                        return;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
        else
        {
            boolean valid = Valid( firstCourse, secondCourse, courses );
            if( valid == true )
                StdOut.println( "YES" );
            else
                StdOut.println( "NO" );
        }
        // boolean valid = false;


    }
}

