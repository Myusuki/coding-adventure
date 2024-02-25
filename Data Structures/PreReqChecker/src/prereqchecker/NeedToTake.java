package prereqchecker;

import java.util.ArrayList;
import java.util.Arrays;

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
 * NeedToTakeInputFile name is passed through the command line as args[1]
 * Read from NeedToTakeInputFile with the format:
 * 1. One line, containing a course ID
 * 2. c (int): Number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2]
 * Output to NeedToTakeOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class NeedToTake {
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
            StdOut.println("Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
            return;
        }

        // WRITE YOUR CODE HERE
        StdIn.setFile( args[0] );
        StdOut.setFile( args[2] );

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

        StdIn.setFile( args[1] );
        String targetCourseID = StdIn.readString();
        CourseNode targetCourseNode = courses[ findCourseIndex(courses, targetCourseID) ];

        // read taken courses, mark them as taken, and add them to queue
        int amountOfCoursesTaken = StdIn.readInt();
        int coursesTaken[] = new int[courses.length];
        Arrays.fill(coursesTaken, 0);
        
        ArrayList<CourseNode> takenCourses = new ArrayList<CourseNode>();
        for( int i = 0; i < amountOfCoursesTaken; i++ )
        {
            if( StdIn.hasNextLine() )
            {
                CourseNode node = courses[ findCourseIndex(courses, StdIn.readString() ) ];
                coursesTaken[ findCourseIndex(courses, node.getCourseName() ) ] = 1;
                takenCourses.add(node);
            }
        }
        while( !takenCourses.isEmpty() )
        {
            CourseNode node = takenCourses.get(0);
            while( node.getNextCourse() != null )
            {
                node = node.getNextCourse();
                takenCourses.add( courses[ findCourseIndex(courses, node.getCourseName() ) ] );
                coursesTaken[ findCourseIndex(courses, node.getCourseName() ) ] = 1;
            }
            takenCourses.remove(0);
        }

        ArrayList<CourseNode> prereqCheck = new ArrayList<CourseNode>();
        prereqCheck.add(targetCourseNode);
        while( !prereqCheck.isEmpty() )
        {
            CourseNode node = prereqCheck.get(0);
            prereqCheck.remove(0);
            while( node.getNextCourse() != null )
            {
                node = node.getNextCourse();
                if( coursesTaken[ findCourseIndex(courses, node.getCourseName() ) ] == 0 )
                {
                    StdOut.println( node.getCourseName() );
                    prereqCheck.add( courses[ findCourseIndex(courses, node.getCourseName() ) ] );
                }
            }
        }
    }
}
