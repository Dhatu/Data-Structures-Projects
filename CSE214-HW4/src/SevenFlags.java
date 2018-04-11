import java.util.Scanner;


public class SevenFlags {
	public static void main(String[]  args) throws FullQueueException, EmptyQueueException, CloneNotSupportedException{
		Scanner input = new Scanner(System.in);
		
		int timecounter = 0;
		Ride[] Flagrides = new Ride[4];
		Flagrides[0] = new Ride();
		Flagrides[1] = new Ride();
		Flagrides[2] = new Ride();
		Flagrides[3] = new Ride();
		Flagrides[0].setName("Blue Scream");
		Flagrides[1].setName("Kingda Knuth");
		Flagrides[2].setName("i386 Tower of Terror");
		Flagrides[3].setName("GeForce");

		
		System.out.println("Welcome to Seven Flags!");
		

		System.out.println("Please enter the number of regular customers: ");
		int regularcount = input.nextInt();
		System.out.println("Please enter the number of silver customers: ");
		int silvercount = input.nextInt();
		System.out.println("Please enter the number of gold customers: ");
		int goldcount = input.nextInt();
		System.out.println("Please enter simulation length: ");
		int similength = input.nextInt();
		
		System.out.println("Please enter the duration of Blue Scream of Death (minutes): ");
		int duration1 = input.nextInt();
		 Flagrides[0].setduration(duration1);
 
		System.out.println("Please enter the capacity of Blue Scream of Death: ");
		Flagrides[0].setCapacity(input.nextInt());
		System.out.println("Please enter the holding queue size for Blue Scream of Death: ");
		int y = input.nextInt();
		Flagrides[0].getholdingQueue().setmaxSize(y);
		
		System.out.println("Please enter the duration of Kingda Knuth (minutes): ");
		int duration2 = input.nextInt();
		 Flagrides[1].setduration(duration2);
		System.out.println("Please enter the capacity of Kingda Knuth: ");
		Flagrides[1].setCapacity(input.nextInt());
		System.out.println("Please enter the holding queue size for Kingda Knuth: ");
		Flagrides[1].getholdingQueue().setmaxSize(input.nextInt());
		
		System.out.println("Please enter the duration of i386 Tower of Terror (minutes): ");
		int duration3 = input.nextInt();
		 Flagrides[2].setduration(duration3);
		System.out.println("Please enter the capacity of i386 Tower of Terror: ");
		Flagrides[2].setCapacity(input.nextInt());
		System.out.println("Please enter the holding queue size for i386 Tower of Terror: ");
		Flagrides[2].getholdingQueue().setmaxSize(input.nextInt());
		
		System.out.println("Please enter the duration of GeForce (minutes): ");
		int duration4 = input.nextInt();
		 Flagrides[3].setduration(duration4);

		System.out.println("Please enter the capacity of GeForce: ");
		Flagrides[3].setCapacity(input.nextInt());
		System.out.println("Please enter the holding queue size for GeForce: ");
		Flagrides[3].getholdingQueue().setmaxSize(input.nextInt());

		Person[] regulararray = new Person[regularcount];
		for ( int i = 0; i < regularcount;i++){
			regulararray[i] = new Person();
			regulararray[i].setnumber(i);
			regulararray[i].setname("Regular");
		}
		Person[] silverarray = new Person[silvercount*2];
		for ( int i = 0; i < (silvercount*2)- 1; i += 2){
			silverarray[i] = new Person();
			silverarray[i].setnumber(i);
			silverarray[i].setname("Silver");
			silverarray[i+1] = new Person();
			silverarray[i+1].setnumber(i);
			silverarray[i+1].setname("Silver");
		}
		Person[] goldarray = new Person[goldcount*3];
		for ( int i = 0; i < (goldcount*3)- 2; i += 3){
			goldarray[i] = new Person();
			goldarray[i].setnumber(i);
			goldarray[i].setname("Gold");
			goldarray[i+1] = new Person();
			goldarray[i+1].setnumber(i);
			goldarray[i+1].setname("Gold");
			goldarray[i+2] = new Person();
			goldarray[i+2].setnumber(i);
			goldarray[i+2].setname("Gold");
		}
		//making total with all person objects
		Person[] totalcustnum = new Person[silverarray.length + regulararray.length + goldarray.length];
		for ( int i = 0; i < totalcustnum.length;i++){
			if ( i < regulararray.length){
				totalcustnum[i] = regulararray[i];
			}
			int secondcountref = regulararray.length+silverarray.length;
			if ( i < secondcountref && i >= regulararray.length) {
				totalcustnum[i] = silverarray[i-regulararray.length];

			}
			if ( i < totalcustnum.length && i >= secondcountref) {
				totalcustnum[i] = goldarray[i-secondcountref];
			}	
		}
		//Randomize Person Objects from total to input in Rides
		for ( int i = 0; i < totalcustnum.length;i++){
			Ride  n;
			RandomGenerator random = new RandomGenerator();
			n = (Ride)random.selectRide(Flagrides);
			if( n.getOnridenum() != n.getCapacity()){		
				n.addtoonridearray(n.getpeopleOnRide(), totalcustnum[i]);
				totalcustnum[i].setRide(n);
				continue;
			}else if( n.getholdingQueue().size() != n.getholdingQueue().getmaxSize()){
			n.getholdingQueue().enqueue(totalcustnum[i]);
			totalcustnum[i].setRide(n);
			continue;
			}
			else{
		      n.getvirtualLine().enqueue(totalcustnum[i]);
		      totalcustnum[i].setRide(n);
			continue;
			}
		}
		while (Flagrides[0].getridecounter() != similength || Flagrides[1].getridecounter() != similength  || Flagrides[2].getridecounter() != similength
				 || Flagrides[3].getridecounter() != similength){
			System.out.println("At Time " + timecounter + ":");
			timecounter++;
			for ( int i = 0; i < Flagrides.length;i++){
				System.out.println(Flagrides[i].getName() + "-" + "Time remaining: " + Flagrides[i].getduration() + " min");
				Flagrides[i].setduration(Flagrides[i].getduration()- 1);
				
				System.out.println("On Ride: ");
				if (Flagrides[i].getarrayelement(Flagrides[i].peopleOnRide, 0) != null){
				for ( int r = 0; r < Flagrides[i].peopleOnRide.length; r++) {
					
					System.out.print("[" +  Flagrides[i].getarrayelement(Flagrides[i].getpeopleOnRide(),r).getname() + " " + Flagrides[i].getarrayelement(Flagrides[i].getpeopleOnRide(),r).getnumber()  + "]");
					
				}
				}
		
				System.out.println();
				System.out.println("Holding Queue: ");
				for ( int h = 0; h < Flagrides[i].getholdingQueue().size(); h++) {
					System.out.print("[" +  Flagrides[i].getholdingQueue().get(h).getname() + " " +  Flagrides[i].getholdingQueue().get(h).getnumber() + "]");
				}
				System.out.println();
				System.out.println("Virtual Queue: ");
				for ( int v = 0; v < Flagrides[i].getvirtualLine().size(); v++) {
					System.out.print("[" +  Flagrides[i].getvirtualLine().get(v).getname() + " " + Flagrides[i].getvirtualLine().get(v).getnumber() + "]");
				}
																	//Blue Scream of Death - Time remaining: 3 min	
			//On Ride: Gold 1, Silver 1, Silver 2
			//Holding Queue: Silver 5, Regular 1, Regular 3, Regular 4
			//Virtual Queue: Gold 2, Silver 4, Silver 5, Gold 1
			System.out.println();
			System.out.println("----------------");
			//----------------
			}
			
			System.out.println("Regular Customers: ");
			System.out.println("Num Line Status ");
			System.out.println("----------------");
			int n = 0;
			for ( int r = 0; r < regulararray.length;r++){
				System.out.println(n + ".  "  + totalcustnum[r].getRide().getName() +" " + totalcustnum[r].getstatus() + "]");
				n++;
			}
			/*
				1.  BSOD Holding
				2.  KK   OnRide
				3.  BSOD Holding
				4.  BSOD Holding
				5.  KK   Holding
				6.  KK   Holding
				7.  GF   Holding
				8.  ToT  Available
				9.  KK   Available
				10. GF   Available 
			*/
			System.out.println("Silver Customers:");
			System.out.println("Num Lineof2 Status");
			System.out.println("------------------------");
			int n1 = 0;
			for ( int r = 0; r < totalcustnum.length;r++){
				int secondcountref = regulararray.length+silverarray.length;
				if ( r < secondcountref && r >= regulararray.length) {
				System.out.println(n1 + ".  "  + totalcustnum[r].getRide().getName() +" " + totalcustnum[r].getstatus() + "]");
				}
				n1++;
			}
			/*
				1.  BSOD   GF     On Ride
				2.  BSOD   ToT    On Ride
				3.  KK     KK     On Ride
				4.  ToT    BSOD   Holding
				5.  GF     BSOD   Holding */
			System.out.println("Gold Customers:");
			System.out.println("Num Linesof3 Status");
			System.out.println("-------------------------------");
			int n2 = 0;
			for ( int r = 0; r < totalcustnum.length;r++){
				int secondcountref = regulararray.length+silverarray.length;
				if ( r < totalcustnum.length && r >= secondcountref) {
				System.out.println(n2 + ".  "  + totalcustnum[r].getRide().getName() +" " + totalcustnum[r].getstatus() + "]");
				}
				n2++;
			}
			/*
				1.  BSOD   KK     BSOD   OnRide
				2.  ToT    BSOD   GF     OnRide
				3.  GF     GF     ToT    OnRide */
			
			for ( int i = 0; i < Flagrides.length;i++){
			if(Flagrides[i].getOnridenum() == Flagrides[i].getCapacity() && Flagrides[i].getduration() == 0){
			   Flagrides[i].setnewoffride(Flagrides[i].getpeopleOnRide(),Flagrides[i].getpeopleOffRide());
			   if (i == 0) Flagrides[i].setduration(duration1);
			   if (i == 1) Flagrides[i].setduration(duration2);
			   if (i == 2) Flagrides[i].setduration(duration3);
			   if (i == 3) Flagrides[i].setduration(duration4);
			}
			if(Flagrides[i].getholdingQueue().isEmpty() == false && Flagrides[i].getduration() == 0 ){
				Flagrides[i].setnewOnRide(Flagrides[i].getpeopleOnRide());
				Flagrides[i].setnewHolding(Flagrides[i].getpeopleOnRide());
			}else if(Flagrides[i].getvirtualLine().isEmpty() == false && Flagrides[i].getduration() == 0){
				Flagrides[i].setnewHolding(Flagrides[i].getpeopleOnRide());
				Flagrides[i].setnewOnRide(Flagrides[i].getpeopleOnRide());
				if (i == 0) Flagrides[i].setduration(duration1);
				if (i == 1) Flagrides[i].setduration(duration2);
				if (i == 2) Flagrides[i].setduration(duration3);
				if (i == 3) Flagrides[i].setduration(duration4);
				} else {
					continue;
				}
				
			}
			System.out.println("------------------------------------------------------------------------------------------");
		
		}
		if (Flagrides[0].getridecounter() == similength || Flagrides[1].getridecounter() == similength  || Flagrides[2].getridecounter() == similength
				 || Flagrides[3].getridecounter() == similength){
			System.out.println("On average, Gold customers have taken "  +  (goldarray.length/3)  + "rides");
			System.out.println("On average, Silver customers have taken " +  ((silverarray.length))  + "rides.");
			System.out.println("On average, regular customers have taken " +  regulararray.length  +"rides.");
			System.out.println("BSOD has completed rides for " + Flagrides[0].getridecounter() + " people.");
			System.out.println("KK has completed rides for " + Flagrides[1].getridecounter() + " people.");
			System.out.println("ToT has completed rides for " + Flagrides[2].getridecounter() + " people.");
			System.out.println("GF has completed rides for " + Flagrides[3].getridecounter() + " people.");
				 }
	}
}
	



