import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class SemesterComparator implements Comparator, Serializable{
	/*Write a fully-documented class named Semester that allows
	us to compare two courses based on the semester they were 
	offered. The SemesterComparator class should implement the 
	Comparator interface and override the compare method.*/
	public int compare(Object arg0, Object arg1) {
		Course left = (Course) arg0 ;
		Course right = (Course) arg1 ;

		
		if (left.getSemester() == right.getSemester()) {
			return 0;
		}
		 String [] stringArray = {left.getSemester(), right.getSemester()};
		// Arrays.sort(stringArray);
		 stringArray[0].compareTo(stringArray[1]);
		/*if (stringArray[1] == right.getSemester()) {
			return -1;
		}
		if (stringArray[1] == left.getSemester()) {
			return 1;
		}*/
		return stringArray[0].compareTo(stringArray[1]);
	}

	

}
