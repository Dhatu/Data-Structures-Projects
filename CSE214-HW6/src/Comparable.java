import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public interface Comparable {
	/*
	    * An example of type abstraction that implements the Comparator interface.
	    *
	    * The Comparator interfaces allows you to compare two different objects
	    * (as opposed to another object with yourself).
	    */
	    public class CollectionsTester {
	        public static void main(String[] args) {
	            ArrayList<Employee> staff = new ArrayList<Employee>();
	            staff.add(new Employee("Joe",100000, 177700010));
	            staff.add(new Employee("Jane",200000, 111100010));
	            staff.add(new Employee("Bob",66666, 1999000010));
	            staff.add(new Employee("Andy",77777, 188800010));
	            System.out.println("Lowest paid employee: "+staff.get(0));    // Prints Bob
	            Collections.sort(staff, new NameComparator());                // Sort by alphabetical order
	            System.out.println("First employee in list: "+staff.get(0));  // Prints Andy
	            Collections.sort(staff, new IdComparator());                  // Sort by ID number
	            System.out.println("Employee with lowest ID: "+staff.get(0)); // Prints Jane
	        }
	    }
	    public class Employee {
	        private String name;
	        private int salary;
	        private int id;
	        public Employee(String initName, int initSal, int initId) {
	            id     = initId;
	            name = initName;
	            salary = initSal;
	        }
	        public String getName(){ return name; }
	        public int getSalary() { return salary; }
	        public int getId(){ return id; }
	        public void setSalary(int newSalary) {
	            salary = newSalary;
	        }
	        public String toString() {
	            return name + ", $" + salary + ", "+ id;
	        }
	    }
	    public class NameComparator implements Comparator {
	        public int compare(Object o1, Object o2) {
	            Employee e1 = (Employee) o1;
	            Employee e2 = (Employee) o2;
	            return (e1.getName().compareTo(e2.getName()));
	        }
	    }
	    public class IdComparator implements Comparator {
	        public int compare(Object o1, Object o2) {
	            Employee e1 = (Employee) o1;
	            Employee e2 = (Employee) o2;
	            if (e1.getId() == e2.getId())
	                return 0;
	            else if (e1.getId() > e2.getId())
	                return 1;
	            else
	                return -1;
	        }
	    }

}
