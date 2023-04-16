public class Student
{
	// belong to class 
	private static int id = 1001;
	// belong to object 
	private String lastName;
	private String firstName;
	private double gpa;
	private int studentID;
	private String email;

	public Student( String last, String first )
	{
		this.lastName = last;
		this.firstName = first;
		this.gpa = gpaGenerator();
		this.studentID = id;
		id++; 
		this.email = findEmail();
	}

	public String getName()
	{
		return this.firstName + " " + this.lastName;
	}
	public double getGpa()
	{
		return this.gpa;
	}
	public int getID()
	{
		return this.studentID;
	}
	public String getEmail()
	{
		return this.email;
	}

	public double gpaGenerator()
	{
		double rando = Math.random() * 3 + 1;
		return ( ( int )( rando * 100 ) ) / 100;
	}

	public String findEmail()
	{
		String s = "";
		s += this.firstName.charAt( 0 );

		if( this.lastName.length() <= 5 )
		{
			s += this.lastName;
		}
		else
		{
			s += this.lastName.substring( 0, 5 );
		}
		s += "@rutgers.edu";

		return s.toLowerCase();
	}

	public String toString()
	{
		String s = "";
		s += this.getName() + " ";
		s += "GPA: " + this.getGpa() + " ";
		s += "Student ID: " + this.getID() + " ";
		s += "Email: " + this.getEmail() + " ";
		return s;
	}
}
