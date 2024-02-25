package prereqchecker;

public class CourseNode {
    private String name;
    private CourseNode next;


    public CourseNode()
    {
        name = null;
        next = null;
    }
    public CourseNode( String courseName, CourseNode nextNode )
    {
        this.name = courseName;
        this.next = nextNode;
    }

    public String getCourseName()
    {
        return this.name;
    }
    public CourseNode getNextCourse()
    {
        return this.next;
    }
    public void setNextCourse( CourseNode nextCourse )
    {
        this.next = nextCourse;
    }
}
