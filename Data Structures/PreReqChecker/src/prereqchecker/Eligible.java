package prereqchecker;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
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
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
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

        // eligible code
        StdIn.setFile( args[1] );
        int coursesCompletedAmount = StdIn.readInt();
        String coursesCompleted[] = new String[coursesCompletedAmount];
        // store classes that have been taken
        for( int i = 0; i < coursesCompletedAmount; i++ )
        {
            if( !StdIn.hasNextLine() )
                break;
            else
            {
                String course = StdIn.readString();
                coursesCompleted[i] = course;
            }
        }
        
        // array of courses that have been taken directly or indirectly
        int coursesTaken[] = new int[courses.length];
        Arrays.fill(coursesTaken, 0);

        ArrayList<CourseNode> takenCourses = new ArrayList<CourseNode>();
        CourseNode node = null;
        for( int i = 0; i < coursesCompletedAmount; i++ )
        {
            node = courses[ findCourseIndex(courses, coursesCompleted[i] ) ];
            takenCourses.add(node);
            coursesTaken[ findCourseIndex(courses, coursesCompleted[i] ) ] = 1;
        }

        while( !takenCourses.isEmpty() )
        {
            node = takenCourses.get(0);
            while( node.getNextCourse() != null )
            {
                node = node.getNextCourse();
                takenCourses.add( courses[ findCourseIndex(courses, node.getCourseName() ) ] );
                coursesTaken[ findCourseIndex(courses, node.getCourseName() ) ] = 1;
            }
            takenCourses.remove(0);
        }
        
        for( int i = 0; i < courses.length; i++ )
        {
            node = courses[i];
            boolean qualified = true;
            while( node.getNextCourse() != null )
            {
                node = node.getNextCourse();
                if( coursesTaken[ findCourseIndex(courses, node.getCourseName() ) ] == 0 )
                {
                    qualified = false;
                }
            }
            if( qualified && coursesTaken[i] != 1 )
                StdOut.println( courses[i].getCourseName() );
        }

    }
}
