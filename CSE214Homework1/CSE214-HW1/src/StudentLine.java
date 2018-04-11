
public class StudentLine {
	private Student [] students;
	private int studentCount = 0;
	private final int CAPACITY = 19;
	
	public int numStudents(){
		return studentCount;
	}
	
	public StudentLine(){
		students = new Student[CAPACITY + 1];
//		for(int i = 0; i < students.length; i++){
//			students[i] = new Student();
//		}
	}
	public int getStudentCount(){
		return studentCount;
	}
	
	public int getCapacity()	{
		return CAPACITY;
	}
	
	public Student[] getStudentsarray(){
		return students;
	}
	
	public Student getStudent(int index) throws ArrayIndexOutOfBoundsException{
		if (index > CAPACITY || index < 0){
			 throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
		}
		return students[index];
	}
	
	public Student removeStudent(int index) throws ArrayIndexOutOfBoundsException{
		if (index > CAPACITY || index < 0){
			 throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
		}
		Student removedref = students[index];
		//students[index] = removedref;

		for ( int j = index; j < studentCount; j++){
			students[j] = students[j+1];
		}
		students[studentCount] = null;
		studentCount--;
		return removedref;
		
		
	//Gets the reference to the Student at the given index
	//Throws an ArrayIndexOutOfBoundsException if the index is invalid
	//Throws an EmptyLineException (you must write this, an empty class extending Exception is the best way to do this) if there is no student on the line.
	//Removes the given student and moves all students behind this student forward by one index
	}
	public void addStudent(int index, Student student) throws ArrayIndexOutOfBoundsException{
		if (index > CAPACITY || index < 0){
				 throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
		}
		if(students[index] != null){
			for ( int j = studentCount; j > index; j--){
				students[j] = students[j-1];
			}
			students[index] = student;	
		}
		else{
			students[index] = student;
		}
		studentCount++;
		
		//Adds a student at the given index, moving all other students behind the current student back one index.
		//Throws an InvalidArgumentException (custom class) or Illegal Argument Exception if the index is too high and would create a hole in the array
		//Throws a DeanException (you must write this, just make an empty class that extends Exception) if the array is full.
	}
	
	public void swapStudents(int index1, int index2) throws ArrayIndexOutOfBoundsException{
		if (index1 > CAPACITY || index1 < 0){
				 throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
		}	
		if (index2 > CAPACITY || index2 < 0){
				 throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
		}
		Student tmp = students[index1];
		students[index1] = students[index2];
		students[index2] = tmp;
		//If the indices are valid, the two students are swapped.
		//Throws an ArrayIndexOutOfBoundsException if either index is invalid
		//The list should be unchanged if either index was invalid
	}
	
	public StudentLine clone(){
		Student [] temp = students;
		return null;
		
	//Creates a deep copy of this StudentLine object
	//If the copy is modified, this object should remain unmodified.
	//All the students inside should be deep copied as well.
	}
	public boolean equals(Object o){
		
		if (studentCount != ((StudentLine)o).getStudentCount())
			return false;
		
		for ( int i=0; i < studentCount;i++){
			if(!students[i].equals(((StudentLine)o).getStudent(i))){
				return false;
			}
		}
		return true;
	//Checks if this student line is equal to another object
	//The other object must be of type StudentLine, and contain students with the same names in the same order with the same balances for this method to return true.
	}
	public String toString(){
		String lunchline = "";
		System.out.println();
		for(int n = 0; n < studentCount; ++n){
			lunchline += String.format("%-21d%-26s%20f\n",n+1, students[n].getName(),students[n].getMoney());
		}
		return lunchline;
		
	//You must write a toString() method. You can use this method to help you with printing the StudentList for the output.
	}
	}
	
	
