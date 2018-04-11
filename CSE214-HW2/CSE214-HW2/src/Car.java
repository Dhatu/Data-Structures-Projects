
public class Car {
	 private String Owner;
	  private Make make1;
	private int ownerCount = 2;
	  public Car(String name, Make make){
		  make1 = make;
		  Owner= name;
	  }
	  public Car(){  
	  }
	  public String getName(){
		  return Owner;
	  }
	  public Make getMake(){
		  return make1;
	  }
	  public void setName(String name){
		  this.Owner = name;
	  }
	  public void setMake(Make make){
		  this.make1 = make;
	  }
	 
}
