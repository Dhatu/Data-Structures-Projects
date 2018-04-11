
public class HoldingQueue extends VirtualLine{

	
	//This class will serve as the group of people who are up next for a ride. 
	//The difference between it and VirtualLine is that there is a limit to how 
	//many People can be in the HoldingQueue (maxSize). Your class should extend VirtualLine,
	/*which extends a class from the Java API (preferably LinkedList but anything can be used
	as long as it works). This class should contain the basic methods that allow you to enqueue 
	or dequeue onto the line. Also there should be some sort of peek and isEmpty method that 
	can tell other parts of the program if the queue is empty and tell what the top element is. 
	There must be getters and setters for any instance variables that are required.*/
	private int maxSize = 0;
	//This is the max size of the line at once.
	//Methods inherited from VirtualLine
	
 
	public void enqueue(Person p) {
		if (this.size() > maxSize){
			return;
		}
		this.add(p);
	}	
	public Person dequeue() {
		return this.pollFirst();
		
	}
	
	public Person peek(){
		return this.peekFirst();
		
	}
	
	public boolean isEmpty(){
		return super.isEmpty();
		
	}
	public int getmaxSize(){
		return maxSize;
		
	}
	public void setmaxSize(int maxSize){
		  this.maxSize = maxSize;
	 }
	
}
