import java.util.LinkedList;


public class Ride {
	//Write a fully-documented Ride object which will contain the duration of the ride in minutes,
	//an instance of the VirtualLine Object, an instance of the HoldingQueue Object, a list 
	//or an array of all the people on the ride and methods to manipulate these methods (getters,
	//setters, enqueue, dequeue)
	private int Capacity;
	private int ridecounter = 0;
	private int Onridenum = 0;
	Person[] peopleOffRide = new Person[30];
	
	private int duration;
	//How many time steps the ride takes up.
	private int timeLeft;
	//How many minutes are left until the end of the ride cycle
	private String Name;
	//The name of the ride; used for printing
	VirtualLine virtualLine = new VirtualLine();
	//The Queue of people waiting for the ride.
	HoldingQueue holdingQueue = new HoldingQueue();
	//The Queue of people who are next for the ride.
	Person[] peopleOnRide;

	public void addtoonridearray(Person[] peopleOnRide, Person p){
		int counter = 1 ;
		if( peopleOnRide[0] == null){
			peopleOnRide[0] = p;
		}else {
		while (peopleOnRide[counter] != null & counter < (peopleOnRide.length)){
			counter++;			
		}
		peopleOnRide[counter] = p;
		}
		Onridenum++;
	}
	public Person getarrayelement(Person[] peopleOnRide, int index){
		return peopleOnRide[index];
	}
	
	public void setnewoffride(Person[] peopleOnRide,Person [] peopleOffRide) {
	for(int i = 0; i < peopleOnRide.length; i++){
		peopleOnRide[i].setstatus(Status.Available);
		peopleOffRide[i] = peopleOnRide[i];
		ridecounter++;
	}
	Onridenum = 0;
	}
	public void setnewOnRide(Person[] peopleOnRide){
		for(int i = 0; i < peopleOnRide.length; i++){
			if(holdingQueue.getmaxSize()-1 >= i && holdingQueue.peek() != null){
				Person deqref = holdingQueue.peek();
				deqref.setstatus(Status.OnRide);
				peopleOnRide[i] = deqref;
				holdingQueue.dequeue();
				Onridenum++;
		}else {
			Person deqref = virtualLine.peek();
			deqref.setstatus(Status.OnRide);
			peopleOnRide[i] = deqref;
			virtualLine.dequeue();
			Onridenum++;
		}	
	}
	}
	public void setnewHolding(Person[] peopleOnRide){
	for(int i = 0; i < holdingQueue.getmaxSize(); i++){
		if( holdingQueue.isEmpty() == true && virtualLine.isEmpty() == true){
			continue;
		}else {
		Person deqref = virtualLine.peek();
		deqref.setstatus(Status.Holding);
		holdingQueue.enqueue(deqref);
		virtualLine.dequeue();
		}
	}
	}
	public VirtualLine getvirtualLine(){
		return virtualLine;
	}
	public HoldingQueue getholdingQueue(){
		return holdingQueue;
	}
	public String getName(){
		return Name;
	}
	public Person[] getpeopleOnRide(){
		return peopleOnRide;
	}
	public Person[] getpeopleOffRide(){
		return peopleOffRide;
	}
	public void setName(String Name){
		  this.Name = Name;
	}
	public int getridecounter(){
		return ridecounter;
	}
	public int getOnridenum(){
		return Onridenum;
	}
	public void setridecounter(int ridecounter){
		  this.ridecounter = ridecounter;
	}
	public int getCapacity(){
		return Capacity;
	}
	public void setCapacity(int Capacity){
		  this.Capacity = Capacity;
		  peopleOnRide = new Person[Capacity];
	}
	public int getduration(){
		return duration;
	}
	public void setduration(int duration){
		  this.duration = duration;
	}
	public int gettimeLeft(){
		return timeLeft;
	}
	public void settimeLeft(int timeLeft){
		  this.timeLeft = timeLeft;
	}
	
	//Changes person’s status to “onRide”, and “Available” after the ride is over.
	//Has a capacity specified at the start of of the simulation
	
}