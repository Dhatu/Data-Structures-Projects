//Sudhin Domala 
//110475495
// CSE 214 HW 3 Recitation 4 (Wed 4-5 pm)
//parts of code doesn't work due to going to Null pointer Exceptions in my if statements on options: G,T,F,L
//please check the code for those for partial credit

import java.util.Scanner;



public class MailroomManager {

		private static int dateref = 0;
		private static PackageNode copycursor;

		public static void main(String[]  args) throws FullStackException, EmptyStackException, NullPointerException{
			int daynum = 0;
			Scanner input = new Scanner(System.in);
			
			Package ReceivedPackage;
			Package ReceivedPackage2;
			Package ReceivedPackage3;
			
			
			
			String option = "";
			PackageStack[] stacks = new PackageStack[7];
			stacks[0] = new PackageStack();
			stacks[1] = new PackageStack();
			stacks[2] = new PackageStack();
			stacks[3] = new PackageStack();
			stacks[4] = new PackageStack();
			stacks[5] = new PackageStack();
			stacks[6] = new PackageStack();


			int stackcount = 6;
			int Currentstack = 0;
			//0 = a and 1 == b

			System.out.println("Welcome to the Irving Mailroom Manager. "
					+ "You can try to make it better, but the odds are stacked against you."
					+ " It is day" + daynum + ".");
			
			while(!option.equals("Q")){
				System.out.println("Menu:" + "\n" + 
						  		"D) Deliver a package" + "\n" + 
						        "G) Get someone's package " + "\n" + 
						        "T) Make it tomorrow" + "\n" + 
								"P) Print the stacks "  + "\n" +
						    	"M) Move a package from one stack to another" + "\n" +
						    	"F) Find packages in the wrong stack and move to floor"  + "\n" +
						    	"L) List all packages awaiting a user"  + "\n" +
						    	"E) Empty the floor"  + "\n" +
						    	"Q) Quit.");

						System.out.println("Please select an option:");
						option = input.next().toUpperCase();
				if(option.equals("D") ){
					System.out.println("Please enter the weight (lbs):");
					double weight = input.nextDouble();
					
					System.out.println("Please enter the recipient name:");
					String newname= input.next();
					Package newshipment = new Package(newname,daynum,weight);				
					newname.toUpperCase();

					//newshipment.setrecipient(newname);
					//newshipment.setarrivalDate(daynum);
					
					if( newname.charAt(0) == 'A' || newname.charAt(0) == 'B' || newname.charAt(0) == 'C' || newname.charAt(0) == 'D' || newname.charAt(0) == 'E' || newname.charAt(0) == 'F' || newname.charAt(0) == 'G'){
						Currentstack = 0;
					}
					if( newname.charAt(0) == 'H' || newname.charAt(0) == 'I' || newname.charAt(0) == 'J' ){
						Currentstack = 1;
					}
					if( newname.charAt(0) == 'K' || newname.charAt(0) == 'L' || newname.charAt(0) == 'M' ){
						Currentstack = 2;
					}
					if( newname.charAt(0) == 'N' || newname.charAt(0) == 'O' || newname.charAt(0) == 'P' || newname.charAt(0) == 'Q' || newname.charAt(0) == 'R' ){
						Currentstack = 3;
					}
					if( newname.charAt(0) == 'S' || newname.charAt(0) == 'T' || newname.charAt(0) == 'U' || newname.charAt(0) == 'V' || newname.charAt(0) == 'W' || newname.charAt(0) == 'X'|| newname.charAt(0) == 'Y' || newname.charAt(0) == 'Z'){
						Currentstack = 4;
					}
					try {
						stacks[Currentstack].pushPackage(newshipment);
					} catch (FullStackException e) {
						e.printStackTrace();
					}
					System.out.println("A" + weight + " lbs package is awaiting pickup by " + newname );
									

				}
				else if(option.equals("G") ){
					System.out.println("Please enter the recipient name: ");
					String newname= input.next();
					
						if (stacks[0].peek().getrecipient().contentEquals(newname)){
						ReceivedPackage = stacks[0].popPackage();
						System.out.println(" You recieved " + newname + "'s package on the top of a stack.");
						}
						
						if (stacks[1].peek().getrecipient().contentEquals(newname)){
								ReceivedPackage = stacks[1].popPackage();
								System.out.println(" You recieved " + newname + "'s package on the top of a stack.");
						}	
						if (stacks[2].peek().getrecipient().contentEquals(newname) ){
								ReceivedPackage = stacks[2].popPackage();
								System.out.println(" You recieved " + newname + "'s package on the top of a stack.");
						}
								
						if (stacks[3].peek().getrecipient().contentEquals(newname)){
								ReceivedPackage = stacks[3].popPackage();
								System.out.println(" You recieved " + newname + "'s package on the top of a stack.");
						}if (stacks[4].peek().getrecipient().contentEquals(newname)){
									ReceivedPackage = stacks[4].popPackage();
									System.out.println(" You recieved" + newname + "'s package on the top of a stack.");
						}if (stacks[5].peek().getrecipient().contentEquals(newname) ){
							ReceivedPackage = stacks[5].popPackage();
							System.out.println(" You recieved " + newname + "'s package on the top of a stack.");							
						
						}
									
			}else if(option.equals("T") ){
					daynum++;
					System.out.println("It is now day " +daynum + ".");
					int senderpack = 0;

					for (int i = 0; i <= 5;i++){
						copycursor = stacks[i].getHead();

						if (copycursor == stacks[i].getTail()){
							int temp = stacks[i].getTail().getData().getarrivalDate();
							stacks[i].getTail().getData().setarrivalDate(temp + 1 );
							}
						while (copycursor != stacks[i].getTail()){
								copycursor.getData().setarrivalDate(copycursor.getData().getarrivalDate() + 1 );
								copycursor.getnextLink();
							}
						//packages to the trash
						if ( stacks[i].getTail() == stacks[i].getHead()){
						if (stacks[i].getTail().getData().getarrivalDate() == 4 || 
								stacks[i].getTail().getData().getarrivalDate() == 9 ){
							stacks[6].pushPackage(stacks[i].getTail().getData());
							stacks[i].popPackage();
							senderpack++;
						}
						}
						
						if ( stacks[i].getTail() != stacks[i].getHead()){
								if (stacks[i].getHead().getData().getarrivalDate() == 4 || 
										stacks[i].getHead().getData().getarrivalDate() == 9 ){
									stacks[6].pushPackage(stacks[i].getHead().getData());
									stacks[i].setHead(stacks[i].getHead().getnextLink());
									
									senderpack++;
								}
							}
					
					
					}
						System.out.println( senderpack + "packages have been returned to sender");
						
					
					
			}else if(option.equals("P") ){
					System.out.println("Current Packages:");
					System.out.println("----------------------");
					System.out.println("Stack 1 (A-G):|");
					System.out.println(stacks[0].toString());
					System.out.println("Stack 2 (H-J):|");
					System.out.println(stacks[1].toString());
					System.out.println("Stack 3 (K-M):|");
					System.out.println(stacks[2].toString());
					System.out.println("Stack 4 (N-R):|");
					System.out.println(stacks[3].toString());
					System.out.println("Stack 5 (S-Z):|");
					System.out.println(stacks[4].toString());
					System.out.println("Floor: |");
					System.out.println(stacks[5].toString());
				}
				if(option.equals("M") ){
					System.out.println("Please enter the source stack (enter 6 for floor):");
					int currentstack = input.nextInt(); 
					Package movinpack = stacks[currentstack - 1].getTail().getData();
					stacks[currentstack - 1].popPackage();
					System.out.println("Please enter the destination stack:");
					int newstack = input.nextInt(); 
					stacks[newstack - 1].pushPackage(movinpack);

				}
				else if(option.equals("F") ){
					
						
						if( stacks[0].getTail().getData().getrecipient().charAt(0) != 'A' || stacks[0].getTail().getData().getrecipient().charAt(0) != 'B' || stacks[0].getTail().getData().getrecipient().charAt(0) != 'C' || stacks[0].getTail().getData().getrecipient().charAt(0) != 'D' || stacks[0].getTail().getData().getrecipient().charAt(0) != 'E' || stacks[0].getTail().getData().getrecipient().charAt(0) != 'F' || stacks[0].getTail().getData().getrecipient().charAt(0) !=  'G'){
							stacks[5].pushPackage(stacks[0].getTail().getData());
							stacks[0].popPackage();
						}
	
					
						if( stacks[1].getTail().getData().getrecipient().charAt(0) != 'H' || stacks[1].getTail().getData().getrecipient().charAt(0) != 'I' || stacks[1].getTail().getData().getrecipient().charAt(0) != 'J' ){
							stacks[5].pushPackage(stacks[1].getTail().getData());
							stacks[1].popPackage();
						}

						if( stacks[2].getTail().getData().getrecipient().charAt(0) != 'K' || stacks[2].getTail().getData().getrecipient().charAt(0) != 'L' || stacks[2].getTail().getData().getrecipient().charAt(0) != 'M' ){
							stacks[5].pushPackage(stacks[2].getTail().getData());
							stacks[2].popPackage();
						}
				
						if( stacks[3].getTail().getData().getrecipient().charAt(0) != 'N' || stacks[3].getTail().getData().getrecipient().charAt(0) != 'O' || stacks[3].getTail().getData().getrecipient().charAt(0) != 'P' || stacks[3].getTail().getData().getrecipient().charAt(0) != 'Q' || stacks[3].getTail().getData().getrecipient().charAt(0) != 'R' ){
							stacks[5].pushPackage(stacks[3].getTail().getData());
							stacks[3].popPackage();
						}
			
		
						if( stacks[4].getTail().getData().getrecipient().charAt(0) != 'S' || stacks[4].getTail().getData().getrecipient().charAt(0) != 'T' || stacks[4].getTail().getData().getrecipient().charAt(0) != 'U' || stacks[4].getTail().getData().getrecipient().charAt(0) != 'V' || stacks[4].getTail().getData().getrecipient().charAt(0) != 'W' || stacks[4].getTail().getData().getrecipient().charAt(0) != 'X'|| stacks[4].getTail().getData().getrecipient().charAt(0) != 'Y' || stacks[4].getTail().getData().getrecipient().charAt(0) != 'Z'){
							stacks[5].pushPackage(stacks[4].getTail().getData());
							stacks[4].popPackage();;
						}
					
						
					System.out.println("Misplaced Packages moved to Floor.");
						
			}else if(option.equals("L") ){
					System.out.println("Please enter the recipient name:");
					String listname= input.next();
				
				for ( int x = 0; x < 6 ; x++){
					int listnum = 0;
					copycursor = stacks[x].getCursor();
					if (copycursor == stacks[x].getTail()){
						if (stacks[x].peek().getrecipient().contentEquals(listname));
							System.out.println("Package " + listname + " is in Stack " + x + ", it was delivered on day " + stacks[x].getTail().getData().getarrivalDate() + ", and weighs " + stacks[x].getTail().getData().getweight() +"lbs.");
							listnum++;
					}else {
							continue;
						
					}
					while (copycursor != stacks[x].getTail()){
						if (copycursor.getData().getrecipient().contentEquals(listname)){
						System.out.println("Package" + listname + " is in Stack " + x + ", it was delivered on day " + copycursor.getData().getarrivalDate() + ", and weighs " + copycursor.getData().getweight() +"lbs.");
						copycursor.getnextLink();
						listnum++;
						}
						else {
							copycursor.getnextLink();
							listnum++;
						}
						
					}
				}
					
					

//Jones has 2 packages total.
//Package 1 is in Stack 2, it was delivered on day 0, and weighs 2 lbs.
//Package 2 is in Stack 2, it was delivered on day 1, and weighs 3 lbs.
					
					
				}
				else if(option.equals("E") ){
					//The floor has been emptied. Mr. Trash Can is no longer hungry.
					stacks[5].setTail(null);
					stacks[5].setHead(null);
					System.out.println("The floor has been emptied. Mr. Trash Can is no longer hungry.");
					

				}
				else if(option.equals("Q")){
					System.out.println("Use Amazon Locker next time.");
					option = "Q";
				}
				
			}
}
			}
