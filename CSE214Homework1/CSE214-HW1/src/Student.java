
public class Student implements Cloneable{
  private String name;
  private double money;
  public Student(String n, double dollars){
	  name= n;
	  money= dollars;
  }
  public Student(){  
  }
  public String getName(){
	  return name;
  }
  public double getMoney(){
	  return money;
  }
  public void setName(String name){
	  this.name = name;
  }
  public void setMoney(double money){
	  this.money = money;
  }
  public Object clone()throws CloneNotSupportedException{  
	  return new Student(name, money);
 } 
  public void main(String args[]){  
	  try{  
	  Student s1 =new Student(name,money);  
	    
	  Student s2=(Student)s1.clone();  
	    
	  System.out.println(s1.name+" "+s1.money);  
	  System.out.println(s2.name+" "+s2.money);  
	    
	  }catch(CloneNotSupportedException c){}  
	    
	  }  

  public boolean equals(Object obj){
	  Student stud = (Student) obj;
	  if(this.name.equals(stud.name) && this.money == stud.money){
		  return true;
	  }
	  else{
		  return false;
	  }
		      
  }
  
//  public boolean isEmpty(int n){
//	  if()
//  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
