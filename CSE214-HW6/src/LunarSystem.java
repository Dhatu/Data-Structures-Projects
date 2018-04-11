import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class LunarSystem{
	/*Write a full-documented class named LunarSystem that will allow
	the user to interact with a database of Students. Provide the user
	with a menu-based interface that allows them to add, remove, and 
	edit Students, as well as their courses. You will need to be able 
	to serialize (save) the database at the end of the program and 
	deserialize (load) the database if a file containing the database
	already exists. The database will have a Student’s netID as the key 
	and the associated Student object as the value.
	*/
	/*On startup, the LunarSystem should check to see if the file 
	Lunar.ser exists in the current directory. If it does, then the file 
	should be loaded and deserialized into the database instance. If the
	file does not exist, a new HashMap should be created and used instead.
	In either case, the user should be allowed to fully interact with the 
	LunarSystem without issues.*/
	private static HashMap<String, Student> database;
		public static void main(String[] args) throws FileNotFoundException {
			Scanner input = new Scanner(System.in);
			
			 HashMap<String,Student> newmap = new HashMap<String,Student>();  			
FileInputStream fileLoad;

try{
	fileLoad = new FileInputStream("Lunar.ser");
	ObjectInputStream inStream = new ObjectInputStream(fileLoad);
	newmap = (HashMap<String, Student>) inStream.readObject();
	inStream.close();
}catch (FileNotFoundException e){
	
}catch (IOException e){
	
}catch (ClassNotFoundException e){
	
}

if ( newmap.isEmpty()){
	System.out.println("No previous data found.");
} else {
	System.out.println("Hash map found.");
}
/*
 * CHECK IF DATABASE IS EMPTY
 */
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			System.out.println("Welcome to the Lunar System, a second place course"
					+ " registration system for second rate courses at a second class "
					+ "school.");
			String option = "";
			
			while(!option.equals("Q")){
				System.out.println();
				System.out.println("Menu:" + "\n" +
			    "L) Login" + "\n" +
			    "X)Save state and quit" + "\n" +
			    "Q) Quit without saving state.");

				System.out.println("Please select an option:");
				option = input.next().toUpperCase();
				if(option.equals("L") ){
					System.out.println("Please enter webid:");
					String webid = input.next();
					System.out.println("Welcome " + webid);
					
					if ( webid.toUpperCase().equals("REGISTRAR")){
						String option1 = "";
						while(!option1.equals("L")){
							System.out.println();
							System.out.println("Options:" + "\n" +
						    "R) Register a student" + "\n" +
						    "D) De-register a student" + "\n" +
						    "E) View course enrollment" + "\n" +
						    "L) Logout"
						    );
							System.out.println("Please select an option:");
						    option1 = input.next().toUpperCase();
						    input.nextLine();
						if(option1.equals("R") ){
							System.out.println("Please enter a webid for the new student: ");
							String webid1 = input.next();
							Student newstudent = new Student();
							newstudent.setWebID(webid1);
							newmap.put(webid1, newstudent);
							System.out.println( webid1 + " registered.");
						}
						if(option1.equals("D") ){
							System.out.println("Please enter a webid for the student to be deregistered: ");
							String removeid = input.next();
							newmap.remove(removeid);
							System.out.println( removeid + " deregistered.");
						}
						if(option1.equals("E") ){
							System.out.println("Please enter course: ");
							String coursenum = input.nextLine();
							
							String[] dcoursearray = coursenum.split(" ");
							if(dcoursearray[1].length() > 3)
							{
							  throw new IllegalArgumentException();
							}
				        	int number = Integer.parseInt(dcoursearray[1]);
				        	if(number > 1000)
							{
							  throw new IllegalArgumentException();
							}
				        	System.out.println("Student    Semester");
				        	System.out.println("-------------------");
							for(Entry<String, Student> m:newmap.entrySet()){
								for ( int i = 0; i < m.getValue().getCourses().size(); i++){
								 if ( m.getValue().getCIndexval(i).getDepartment().equalsIgnoreCase(dcoursearray[0]) == true &&
										 m.getValue().getCIndexval(i).getNumber() == number){
								   System.out.println(m.getKey()+" "+m.getValue().getCIndexval(i).getSemester().toString());  
								  } 
							 }
						}
						if(option1.equals("L") ){
							System.out.println("Registrar logged out.");
						}

					}
					}} else if (!webid.toUpperCase().equals("REGISTRAR")){
						String option2 = "";
						while(!option2.equals("L")){
						System.out.println();
						System.out.println("Options:" + "\n" +
					    "A)Add a class" + "\n" +
					    "D)Drop a class" + "\n" +
					    "C)View your classes sorted by course name/department" + "\n" +
					    "S)View your courses sorted by semester"
					    );
						System.out.println("Please select an option:");
						option2 = input.next().toUpperCase();
						input.nextLine();
						if(option2.equals("A") ){
							int index = 0;
							if ( newmap.get(webid).getCourses() == null){
								List<Course> init = new ArrayList<Course>();
								newmap.get(webid).setCourses(init);	
							}
							System.out.println("Please enter course name: ");
							String course = input.nextLine();
							String[] coursearray = course.split(" ");
							if(coursearray[1].length() > 3)
							{
							  throw new IllegalArgumentException();
							}
				        	//newmap.get(webid).getCIndexval(index).setDepartment(coursearray[0]);
				        	int number = Integer.parseInt(coursearray[1]);
				        	if(number > 1000)
							{
							  throw new IllegalArgumentException();
							}
				        	//newmap.get(webid).getCIndexval(index).setNumber(number);
							System.out.println("Please select a semester: ");
							String semester = input.nextLine();
							if( semester.startsWith("s")){
								
							}
							//newmap.get(webid).getCIndexval(index).setSemester(semester);
							Course indexref = new Course(coursearray[0],number,semester);
							newmap.get(webid).getCourses().add(indexref);
							if( semester.startsWith("s")){
								System.out.println( course + " added in Spring " + semester.substring(1) );
							}
							if( semester.startsWith("f")){
								System.out.println( course + " added in Fall " + semester.substring(1) );
							}
						}
						if(option2.equals("D") ){
							
							System.out.println("Please enter course name: ");
							String course = input.nextLine();
							String[] dcoursearray = course.split(" ", 2);
							if(dcoursearray[1].length() > 3)
							{
							  throw new IllegalArgumentException();
							}
				        	int number = Integer.parseInt(dcoursearray[1]);
				        	if(number > 1000)
							{
							  throw new IllegalArgumentException();
							}
				        	int deleteindex = 0;
							for ( int i = 0; i < newmap.get(webid).getCourses().size(); i++){
								if ( newmap.get(webid).getCourses().get(i).getDepartment().equalsIgnoreCase(dcoursearray[0]) &&
										newmap.get(webid).getCourses().get(i).getNumber() ==  number){
									deleteindex = i;
								} 
								}
							if( newmap.get(webid).getCourses().get(deleteindex).getSemester().startsWith("s")){
								System.out.println(newmap.get(webid).getCourses().get(deleteindex).getDepartment().toString() +  
										newmap.get(webid).getCourses().get(deleteindex).getNumber() +
										" dropped from Spring " +  newmap.get(webid).getCourses().get(deleteindex).getSemester().substring(1).toString());}						
							if( newmap.get(webid).getCourses().get(deleteindex).getSemester().startsWith("f")){
								System.out.println(newmap.get(webid).getCourses().get(deleteindex).getDepartment().toString() +  
										newmap.get(webid).getCourses().get(deleteindex).getNumber() +
										" dropped from Fall " +  newmap.get(webid).getCourses().get(deleteindex).getSemester().substring(1).toString());}						
							
							
							
							
							newmap.get(webid).getCourses().remove(deleteindex);
							
						}
						if(option2.equals("C") ){
							System.out.println("Dept. Course Semester");
							System.out.println("-------------------------------");
							Course[] listarray =  newmap.get(webid).getCourses().toArray(new Course[newmap.get(webid).getCourses().size()]);
							Arrays.sort(listarray, new CourseNameComparator());
							for ( int i = 0; i < listarray.length; i++){
								System.out.println(listarray[i].getDepartment().toString() + "   " + listarray[i].getNumber()+ "    " +
										listarray[i].getSemester().toString());
								
							}
						}
						if(option2.equals("S") ){
							System.out.println("Dept. Course Semester");
							System.out.println("-------------------------------");
							Course[] listarray2 =  newmap.get(webid).getCourses().toArray(new Course[newmap.get(webid).getCourses().size()]);
						    /*for (int i =0; i < listarray2.length; i++){
							stringref[i] = listarray2[i].getSemester(); }
							*/
							Arrays.sort(listarray2, new SemesterComparator());
							
							for ( int i = 0; i < listarray2.length; i++){
								System.out.println(listarray2[i].getDepartment().toString() + "   " + listarray2[i].getNumber()+ "    " +
										listarray2[i].getSemester().toString());
								
							}
						}
						if(option2.equals("L") ){
							System.out.println( webid + " logged out.");
						}
						

					}
					  
				  }
				}
				if(option.equals("X") ){
					System.out.println( " ");
					
					FileOutputStream fileSave;
					String file = "Lunar.ser";

					try{
						fileSave = new FileOutputStream(file);
						ObjectOutputStream outStream = new ObjectOutputStream(fileSave);
						outStream.writeObject(newmap);
						outStream.close();
					}catch (FileNotFoundException e){
						
					}catch (IOException e){
						
					}
					
				}
				if(option.equals("Q") ){
					try { 
				         File file = new File("Lunar.ser");
				         if(file.delete()) { 
				            System.out.println(file.getName() + " is deleted!");
				         } else {
				            System.out.println("Delete operation has failed.");
				    		}
				      } catch(Exception e) {
				         e.printStackTrace();
				      }
					System.out.println("Good bye, please pick the right SUNY next time!");
					
				}

			}
	}
	public HashMap<String, Student> getDatabase() {
		return database;
	}
	public void setDatabase(HashMap<String, Student> database) {
		this.database = database;
	}
}
