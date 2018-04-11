import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;


public class CourseNameComparator implements Comparator, Serializable{
	/*Write a fully-documented class named CourseNameComparator
	that allows us to compare two course names with the following 
	priority: department and then number. The CourseNameComparator 
	class should implement the Comparator interface and override
	the compare method.*/
	/*Should return: -1 if the left course name is “less” 
    than the right course name, 0 if they are equal, and 1 
    if the left course name is “greater” than the right course.*/

	@Override
	public int compare(Object arg0, Object arg1) {
		Course left = (Course) arg0 ;
		Course right = (Course) arg1 ;

		 String [] stringArray = {left.getDepartment(), right.getDepartment()};
		// Arrays.sort(stringArray);
		if (		 stringArray[0].compareTo(stringArray[1]) == 0) {
			int number1 = left.getNumber();
			int number2 = right.getNumber();
			if( number1 == number2){
				return 0;
			}else if(number1 > number2){
				return -1;
			}else if(number1 < number2){
				return 1;
			}
		}
		return stringArray[0].compareTo(stringArray[1]);
	}

	

}
