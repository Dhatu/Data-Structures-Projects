import java.util.Scanner;


public class OilChangeManager {
	private static CarListNode copycursor;

	public static void main(String[]  args){
		Scanner input = new Scanner(System.in);
		
		String option = "";
		CarList[] Owners = new CarList[3];
		Owners[0] = new CarList();
		Owners[1] = new CarList();
		Owners[2] = new CarList();
		
		int ownercount = 3;
		int CurrentOwner = 0;
		//0 = a and 1 == b

		System.out.println("Welcome to Tony's Discount Oil Change Computer Management System! "
				+ "It's way better than a rolodex, cork board, post-its,"
				+ "and pre-chewed bubblegum!");
		
		while(!option.equals("Q")){
			
			System.out.println("Options:" + "\n" + 
			  "L - Edit Job Lists for Joe and Donny" + "\n" + 
			        "A - Add a car to the end " + "\n" + 
					"F - Cursor Forward " + "\n" + 
					"H - Cursor to Head "  + "\n" +
			    	"T - Cursor to Tail " + "\n" +
			    	"B - Cursor Backward "  + "\n" +
			    	"I - Insert car before cursor "  + "\n" +
			    	"X - Cut car at cursor "  + "\n" +
			    	"V - Paste car before cursor "  + "\n" +
			    	"R - Remove car at cursor "  + "\n" +
			    	"M - Merge Lists "  + "\n" +
			    	"P - Print Lists" + "\n" + 
			    	"FL) Paste car to end of finished car list" + "\n" +
			    	"Q) Quit.");

			System.out.println("Please select an option:");
			option = input.next().toUpperCase();

			if(option.equals("L") ){
				System.out.println("Please select a list - Joe (J) or Donny (D):");
			}
			else if(option.equals("J") ){
					CurrentOwner = 0;
					System.out.println(" You are currently in Joe's List");
				}
				else if(option.equals("D") ){
					CurrentOwner = 1;
					System.out.println(" You are currently in Donny's List");
				}
				
				else if(option.equals("P") ){
				System.out.println("Joe's List:");
				System.out.println("Owner        Make");
				System.out.println("----------------------");
				System.out.print(Owners[0].toString());
				System.out.println("");
				System.out.println("Donny's List:");
				System.out.println("Make        Owner");
				System.out.println("----------------------");
				System.out.print(Owners[1].toString());
				System.out.println("");
				System.out.println("Finished List:");
				System.out.println("Make        Owner");
				System.out.print("----------------------");
				System.out.println(Owners[2].toString());

			}
				
			
			else if(option.equals("A") ){
				 
				Car newCar = new Car();				
				System.out.println("Please enter vehicle make (FORD(0), GMC(1), CHEVY(2),JEEP(3), DODGE(4), CHRYSLER(5) , LINCOLN(6)): ");
				int newmake = input.nextInt(); 
				Make t1 = Make.getTypeByOrdinal(newmake);
				newCar.setMake(t1);
				
				System.out.println("Please enter owner's name: "); 
				String newname= input.next();
				
				newCar.setName(newname);
				Owners[CurrentOwner].appendToTail(newCar);
				System.out.println(newname +"'s" + t1 + " has been scheduled for an oil change with Current Owner and has been added to his/her list.");

			}
			else if(option.equals("F") ){
				try {
					Owners[CurrentOwner].cursorForward();
					System.out.println("Cursor Moved Forward in the List.");
				} catch (EndofListException e) {
					e.printStackTrace();
				}
				
			}
			else if(option.equals("H") ){
				Owners[CurrentOwner].resetCursorToHead();
				System.out.println("Cursor Moved To Head in the List.");
			}
			else if(option.equals("T") ){
				Owners[CurrentOwner].resetCursorToTail();
				System.out.println("Cursor Moved To Tail in the List.");
			}
			else if(option.equals("B") ){
				try {
					Owners[CurrentOwner].cursorBackward();
					System.out.println("Cursor Moved Backward in the List.");

				} catch (EndofListException e) {
					e.printStackTrace();
				}
			}
			else if(option.equals("I") ){
				Car newCar = new Car();				
				System.out.println("Please enter vehicle make (FORD(0), GMC(1), CHEVY(2),JEEP(3), DODGE(4), CHRYSLER(5) , LINCOLN(6)): ");
				int newmake = input.nextInt(); 
				Make t1 = Make.getTypeByOrdinal(newmake);
				newCar.setMake(t1);
				
				System.out.println("Please enter owner's name: "); 
				String newname= input.next();
				newCar.setName(newname);
				
				Owners[CurrentOwner].insertBeforeCursor(newCar);
				
				System.out.print( newname + "'s" + newmake + " has been scheduled for an oil change with Donny and has been added to his list before the cursor.");
				
			}
			else if(option.equals("X") || option.equals("R")){
				try {
					if(option.equals("X")) {
					copycursor = Owners[CurrentOwner].removeCursor2();
					System.out.println("Cursor cut in the List.");
					}
					if(option.equals("R")) {
					Owners[CurrentOwner].removeCursor();
					System.out.println("Cursor removed in the List.");
					}
				} catch (EndofListException e) {
					e.printStackTrace();
				}
				
			}
			else if(option.equals("M") ){
				System.out.print("Please select a destination list - Joe (J) or Donny (D):");
				String mergeowner= input.next().toUpperCase();
				if ( mergeowner == "D"){
					Owners[1].setHead(CarList.mergeLists(Owners[1],Owners[0]).getHead());
					Owners[1].setTail(CarList.mergeLists(Owners[1],Owners[0]).getTail());
					Owners[1].setCursor(CarList.mergeLists(Owners[1],Owners[0]).getHead());
					Owners[0].setHead(null);
					Owners[0].setTail(null);
					Owners[0].setCursor(null);
					System.out.print("Joe's list merged into Donny's.");
				}
				if ( mergeowner == "J"){
					Owners[0].setHead(CarList.mergeLists(Owners[0],Owners[1]).getHead());
					Owners[0].setTail(CarList.mergeLists(Owners[0],Owners[1]).getTail());
					Owners[0].setCursor(CarList.mergeLists(Owners[0],Owners[1]).getHead());
					Owners[1].setHead(null);
					Owners[1].setTail(null);
					Owners[1].setCursor(null);
					System.out.print("Donny's list merged into Joe's.");
				}
			}
			else if(option.equals("V") ){
				if (copycursor != null){
				Owners[CurrentOwner].appendToTail(copycursor.getData());
				System.out.print("Cursor pasted in the List.");
				} else {
					System.out.print("Nothing to paste.");
				}
			}
			else if(option.equals("FL") ){
				
				Owners[2].appendToTail(Owners[CurrentOwner].getCursorCar());
				System.out.println("Car pasted in finished list.");
			}
			else if(option.equals("Q")){
				System.out.println("Enjoy your retirement!");
				option = "Q";
			}
			else {
				System.out.println("This is not an option.");
			}
		}
	}
}	
	
	

