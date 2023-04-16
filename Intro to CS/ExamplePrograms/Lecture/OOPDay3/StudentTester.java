

public class StudentTester {
  
public static void main(String[] args) {
	
  	Student[] studs = new Student[5];
  	for (int i = 0; i < studs.length; i++){
  		String fname = StdIn.readString();
  		String lname = StdIn.readString();
			studs[i] = new Student(lname,fname);			  	
	}
	
	System.out.println("Students are:");
	printArray(studs);
	Student highStudent = getHighest(studs);
	System.out.println("highest GPA belongs to: " + highStudent);
}

public static void printArray(Student[] students){
	for(Student s : students){
		System.out.println(s);
	}	 
}	
	// Who has highest gpa:
public static Student getHighest(Student[] students){
	double highGpa = students[0].getGpa();
	Student highStudent = students[0];
	for (int i = 1; i < students.length; i++){
		if (students[i].getGpa() > highGpa){
			highGpa = students[i].getGpa();
			highStudent = students[i];
		}
	}
	return highStudent;
	}
/*	
public static void selection(Student[] a){
	int n = a.length;
	for (int i= 0; i < n; i++){
		int minPos = i;
		for (int j = i+1; j < n; j++){
			if (a[j].compareTo(a[minPos])  < 0) {
				 minPos = j;
				}
		}
		Student temp = a[i];
		a[i] = a[minPos];
		a[minPos] = temp;
		}
	}

	public static void insertionSort(Student[] A){
		int itemsSorted;
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++){
			Student temp = A[itemsSorted];
			int loc = itemsSorted - 1;
			while (loc >= 0 && A[loc].compareTo(temp) < 0){
				A[loc + 1] = A[loc];
				loc = loc - 1;
			}
			A[loc + 1] = temp;
		}
	}
	*/
}


  
    

