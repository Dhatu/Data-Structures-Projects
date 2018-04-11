import java.util.List;
import java.io.Serializable;

public class Student implements Serializable{
	/*Write a fully-documented class named Student that will serve 
	as the stored element of the Lunar System database. Each Student 
	object includes a webID and a list of courses the student has taken,
	and getters and setters for each. Must implement the Serializable interface.*/
	private String webID;
	private List<Course> courses;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String webID,List<Course> courses) {
		this.webID = webID;
		this.courses = courses;

	}
	// Can be Array, ArrayList, LinkedList
	public List<Course> getCourses() {
		return courses;
	} 
	public Course getCIndexval(int index) {
		return courses.get(index);
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getWebID() {
		return webID;
	}
	public void setWebID(String webID) {
		this.webID = webID;
	}

}

