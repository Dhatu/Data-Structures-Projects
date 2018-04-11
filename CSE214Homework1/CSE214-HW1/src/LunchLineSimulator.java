import java.util.Scanner;

public class LunchLineSimulator {
	public static void main(String[]  args){
		Scanner input = new Scanner(System.in);
		
		String option = "X";
		StudentLine[] realitys = new StudentLine[2];
		int CurrentReality = 0;
		//0 = a and 1 == b
		realitys[0] = new StudentLine();
		realitys[1] = new StudentLine();
		
		while(!option.equals("Q")){
			
			System.out.println("Welcome to the Middle School where you are the master of the lunch line, "
					+ "and you may subject your angsty kids to whatever form of culinary torture best fits "
					+ "your mood." + "\n" + "You are in Reality" + (CurrentReality == 0 ? " A" : " B") + ".");
			
			System.out.println("Menu:" + "\n" + "A) Add a student to the line at the end" + "\n" + "C) Have a new student cut a friend" + "\n" +
					"T) Have two students trade places" + "\n" + "B) Have the bully remove a student" + "\n" + "U) Update a student's money amount"+
					"\n" + "S) Serve a student" + "\n" + "P) Print the current reality's lunch line" + "\n" 
					+ "O) Switch to the other reality" + "\n" + "E) Check if the realities are equal" + "\n" 
					+ "D) Duplicate this reality into the other reality" + "\n" + "Q) Quit middle school and move on to real life." );
	
			
			
			System.out.println("Please select an option:");
			option = input.next().toUpperCase();
			
			
			if(option.equals("A") ){
				
				if (realitys[CurrentReality].getStudentCount() == realitys[CurrentReality].getCapacity())	{
					System.out.println("Capacity reached.");
					continue;
				}
				
				System.out.println("Enter the name:");
				String name = input.next();
				input.nextLine();
				System.out.println("Enter the amount of money in format [0.00]");
				double money = input.nextDouble();
				
				int addIndex = realitys[CurrentReality].getStudentCount();
				Student s1 = new Student(name, money);
				
				realitys[CurrentReality].addStudent(addIndex, s1);
				
			}else if(option.equals("B")){
				System.out.print("Enter the index of Bully: ");
				int index = input.nextInt() - 1;
				System.out.print(realitys[CurrentReality].removeStudent(index).toString());
				System.out.println("The bully has stolen the student's lunch money, and it has left the poor kid feeling hangry and not in line.");

			}else if(option.equals("P")){
				System.out.println("Lunch Line in Current Reality:");
				System.out.println(realitys[CurrentReality].toString());
			}else if(option.equals("O")){
				if(CurrentReality == 0)
					CurrentReality = 1;
				else
					CurrentReality = 0;
				System.out.print("You are in Reality B. I reject your reality and substitute my own.");
			}else if(option.equals("D")){
				int otherReal = 0;
				if(CurrentReality == 0) 
					otherReal = 1;
				for(int x = 0; x < realitys[CurrentReality].getStudentCount(); x++){
					try {
						realitys[otherReal].addStudent(x, (Student)realitys[CurrentReality].getStudent(x).clone());
					} catch (ArrayIndexOutOfBoundsException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Reality A has been copied into Reality B.");
			}
			
			else if (option.equals("E"))	{
				boolean ret = realitys[0].equals(realitys[1]);
				System.out.println("Return is " + (ret ? "equal" : "not equal"));
			}
			
			else if (option.equals("C"))	{
				
				if (realitys[CurrentReality].getStudentCount() == realitys[CurrentReality].getCapacity())	{
					System.out.println("Capacity reached.");
					continue;
				}
				
				System.out.println("Please enter the index to cut: ");
				int index = input.nextInt() - 1;
				System.out.println("Enter the name of the student: ");
				String name = input.next();
				System.out.println("Enter the money of the student: ");
				double money = input.nextDouble();
				
				realitys[CurrentReality].addStudent(index, new Student(name, money));
				
				System.out.println("The realities are equal.");
			}
			
			else if (option.equals("T"))	{
				System.out.println("Enter the index of Student 1: ");
				int index1 = input.nextInt() - 1;
				System.out.println("Enter the index of Student 2: ");
				int index2 = input.nextInt() - 1;
				realitys[CurrentReality].swapStudents(index1, index2);
				
				System.out.println(" They has traded places.");
			}
			
			else if (option.equals("U"))	{
				System.out.println("Enter the index of the student to update: ");
				int index = input.nextInt() - 1;
				System.out.println("Enter the moolah");
				double moneys = input.nextDouble();
				
				realitys[CurrentReality].getStudent(index).setMoney(moneys);
				System.out.println("The transaction was successful.");
			}
			
			else if (option.equals("S"))	{
				Student served = realitys[CurrentReality].removeStudent(0);
				if (served != null)	{
					System.out.println(served.getName() + " has been served.");
				}
				else	{
					System.out.println("No student to serve.");
				}
			}
			
			else if(option.equals("Q")){
				System.out.println("You are now leaving the Middle School Lunch Line Simulator. "
				+ "We congratulate you on your decision to do something more productive with your time.");
				option = "Q";
			}
			
			else	{
				System.out.println("This is not an option.");
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
