import java.util.LinkedList;


public class Person implements Cloneable{
	//array or a list of the current lines that they are on and 
	//the current status of the person (an enum). This class must 
	//contain methods that allow the user to manipulate the instance 
	//variables (getters, setters, etc.)
	private String name;
	private int number;
	private int maxLines;
	private Status status1 = Status.Available;
	//The maximum number of lines the Person can be on.
	private Ride line;
	//Holds an instance of each ride the person is on.
	//enum Status
	
	public Person(int number){
		this.number = number;
		if (number < 0){
			throw new IllegalArgumentException();
		}
	}
	public Person(int number,int maxLines, Status status1){
			this.maxLines = maxLines;
			this.status1 = status1;
			this.number = number;
			this.name = name;
			if (number < 0){
				throw new IllegalArgumentException();
			}
	//Default constructor of the Person class.
	//Preconditions
	//The number must be positive.
	//Throws
	//IllegalArgumentException if the number is not positive	
	}
	public Person(){
		
	}
	  public String getname(){
		  return name;
	  }
	  public int getnumber(){
		  return number;
	  }
	  public int getmaxLines(){
		  return maxLines;
	  }
	  public Status getstatus(){

		  return status1;
	  }
	  public Ride getRide(){
		  return line;
	  }
	  public void setRide(Ride line){
		  this.line = line;
	  }
	  public void setname(String name){
		  this.name = name;
	  }
	  public void setnumber(int number){
		  this.number = number;
	  }
	  public void setmaxLines(int maxLines){
		  this.maxLines = maxLines;
	  }
	  public void setstatus(Status status){
		  this.status1 = status;
	  }
	 public Person clone()throws CloneNotSupportedException{  
		  return new Person(number,maxLines,status1);
	 }
}
	
