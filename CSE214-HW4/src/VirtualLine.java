import java.util.LinkedList;

public class VirtualLine extends LinkedList<Person>{
	private int peoplecounter;
	
	
	public void enqueue(Person p){
		this.add(p);
		setPeoplecounter(getPeoplecounter() + 1);
		}
	//Adds the specified Person to the rear of the VirtualLine

	public Person dequeue(){
		setPeoplecounter(getPeoplecounter() - 1);
		return this.pollFirst();
	//Removes the Person at the front of the VirtualLine.
	}
	public Person peek() {

		Person item = this.peekFirst();
		return item;
	//Returns the student at the front of the VirtualLine without removing them from the Queue.
	}
	

	//THIS MUST BE INHERITED FROM THE JAVA API. DO NOT WRITE IT YOURSELF!
	//Returns true if the VirtualLine contains no people, returns false otherwise.
	public int getPeoplecounter() {
		return peoplecounter;
	}
	public int setPeoplecounter(int peoplecounter) {
		this.peoplecounter = peoplecounter;
		return peoplecounter;
		}


		
	}

