public class Package {
	private String recipient;
	private int arrivalDate;
	//The arrival date will start at day 0 (see sample IO).
	private double weight;
	public Package(String recipient, int arrivalDate, double weight){
		this.recipient = recipient;
		this.arrivalDate = arrivalDate;
		this.weight = weight;
	}
	//Default constructor of the Package class
	//Postconditions:
	//This object has been initialized to a package object with specified recipient, arrival date and weight.

	  public String getrecipient(){
		  return recipient;
	  }
	  public int getarrivalDate(){
		  return arrivalDate;
	  }
	  public double getweight(){
		  return weight;
	  }
	  public void setrecipient(String recipient){
		  this.recipient = recipient;
	  }
	  public void setarrivalDate( int arrivalDate){
		  this.arrivalDate = arrivalDate;
	  }
	  public void setweight(double weight){
		  this.weight = weight;
	  }
}
