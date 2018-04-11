import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

class Deck {
	private static Card crowncard = new Card("C");
	private Card[] carddeck = new Card[25];

	Deck(/*Card[] carddeck */){
	this.carddeck = (Card[]) carddeck;
	
		
	for (int a = 0 ; a <= 4; a++){
	Card daggercard = new Card("D");
	carddeck[a]= daggercard;
	}
	
	for (int b = 0; b <= 4; b++){
		Card swordcard = new Card("s"); 
		carddeck[5 + b]= swordcard;
	}
	for (int c = 0; c <= 2; c++){
		Card morningstarcard = new Card("M"); 
		carddeck[10 + c]= morningstarcard;
	}
	for (int d = 0; d <= 2; d++){
		Card waxaxecard = new Card("W"); 
		carddeck[13 + d]= waxaxecard;
	}
	for (int e = 0; e <= 1; e++){
		Card halberdcard = new Card("H"); 
		carddeck[16 + e]= halberdcard;
	}
	for (int f = 0; f <= 1; f++){
		Card longswordcard = new Card("L"); 
		carddeck[18 + f]= longswordcard;
	}
	for (int g = 0; g <= 1; g++){
		Card archercard = new Card("A"); 
		carddeck[20 + g]= archercard;
	}
	for (int h = 0; h <= 1; h++){
		Card shieldcard = new Card("S"); 
		carddeck[22 + h]= shieldcard;
	}
	Card crowncard = new Card("C");
	carddeck[24]= crowncard;
	//int daggercount = 5;
	//int swordcount = 5;
	//int morningstarcount = 3;
	//int waraxecount = 3;
	//int halberdcount =2;
	//int longswordcount =2;
	//int archercount = 2;
	//int shieldcount = 2;
	//int crowncount = 1;	
	
	}
	
	public ArrayList<Card[]> getHumanDeck(){
		  
		
		  Card[] cardPile1 = new Card[5];
		  Card[] cardPile2 = new Card[5];
		  Card[] cardPile3 = new Card[5];
		  Card[] cardPile4 = new Card[5];
		  Card[] cardPile5 = new Card[5];
		  
		  
		  for (int a = 0 ; a <= 4; a++){
				Card daggercard = new Card("D");
				carddeck[a]= daggercard;
				}
				
				for (int b = 0; b <= 4; b++){
					Card swordcard = new Card("s"); 
					carddeck[5 + b]= swordcard;
				}
				for (int c = 0; c <= 2; c++){
					Card morningstarcard = new Card("M"); 
					carddeck[10 + c]= morningstarcard;
				}
				for (int d = 0; d <= 2; d++){
					Card waxaxecard = new Card("W"); 
					carddeck[13 + d]= waxaxecard;
				}
				for (int e = 0; e <= 1; e++){
					Card halberdcard = new Card("H"); 
					carddeck[16 + e]= halberdcard;
				}
				for (int f = 0; f <= 1; f++){
					Card longswordcard = new Card("L"); 
					carddeck[18 + f]= longswordcard;
				}
				for (int g = 0; g <= 1; g++){
					Card archercard = new Card("A"); 
					carddeck[20 + g]= archercard;
				}
				for (int h = 0; h <= 1; h++){
					Card shieldcard = new Card("S"); 
					carddeck[22 + h]= shieldcard;
				}
				Card crowncard = new Card("C");
				carddeck[24]= crowncard;
				
				for ( int i1=0; i1 <= 4;i1++){
					cardPile1[i1] = carddeck[i1];
						if (cardPile1[i1] == crowncard)
							cardPile1[0]=cardPile1[i1];
					}
					for ( int i1=5; i1 <= 9;i1++){
					cardPile2[i1 - 5] = carddeck[i1];
						if (cardPile2[i1-5] == crowncard)
						cardPile2[0]=cardPile2[i1-5];
					}
					for ( int i1=10; i1 <= 14;i1++){
					cardPile3[i1 - 10] = carddeck[i1];
						if (cardPile3[i1-10] == crowncard)
						cardPile3[0]=cardPile3[i1-10];
					}
					for ( int i1=15; i1 <= 19;i1++){
					cardPile4[i1 - 15] = carddeck[i1];
						if (cardPile4[i1-15] == crowncard)
						cardPile4[0]=cardPile4[i1-15];
					}
					for ( int i1=20; i1 <= 24;i1++){
					cardPile5[i1 - 20] = carddeck[i1];
						if (cardPile5[i1-20]== crowncard){
						cardPile5[0]=cardPile5[i1-20];}
					}
						
		ArrayList<Card[]> cardPiles = new ArrayList<Card[]>();
			cardPiles.add(cardPile1);
			cardPiles.add(cardPile2);
			cardPiles.add(cardPile3);
			cardPiles.add(cardPile4);
			cardPiles.add(cardPile5);
			
			return cardPiles;
					
	}
	
	public ArrayList<Card[]> getComputerDeck(){
		 for (int a = 0 ; a <= 4; a++){
				Card daggercard = new Card("D");
				carddeck[a]= daggercard;
				}
				
				for (int b = 0; b <= 4; b++){
					Card swordcard = new Card("s"); 
					carddeck[5 + b]= swordcard;
				}
				for (int c = 0; c <= 2; c++){
					Card morningstarcard = new Card("M"); 
					carddeck[10 + c]= morningstarcard;
				}
				for (int d = 0; d <= 2; d++){
					Card waxaxecard = new Card("W"); 
					carddeck[13 + d]= waxaxecard;
				}
				for (int e = 0; e <= 1; e++){
					Card halberdcard = new Card("H"); 
					carddeck[16 + e]= halberdcard;
				}
				for (int f = 0; f <= 1; f++){
					Card longswordcard = new Card("L"); 
					carddeck[18 + f]= longswordcard;
				}
				for (int g = 0; g <= 1; g++){
					Card archercard = new Card("A"); 
					carddeck[20 + g]= archercard;
				}
				for (int h = 0; h <= 1; h++){
					Card shieldcard = new Card("S"); 
					carddeck[22 + h]= shieldcard;
				}
				Card crowncard = new Card("C");
				carddeck[24]= crowncard;
		
		List<Object> list = new ArrayList<>();
			  for (Card i1 : carddeck) {
			    list.add(i1);
			  }

			  Collections.shuffle(list);

			  for (int i = 0; i < list.size(); i++) {
			    carddeck[i] = (Card) list.get(i);
			  } 
			  Card[] ccardPile1 = new Card[5];
			  Card[] ccardPile2 = new Card[5];
			  Card[] ccardPile3 = new Card[5];
			  Card[] ccardPile4 = new Card[5];
			  Card[] ccardPile5 = new Card[5];
			for ( int i1=0; i1 <= 4;i1++){
			ccardPile1[i1] = carddeck[i1];
				if (ccardPile1[i1] == crowncard){
					ccardPile1[i1] = ccardPile1[0];
					ccardPile1[0] = crowncard;
				}
			}
			for ( int i1=5; i1 <= 9;i1++){
			ccardPile2[i1 - 5] = carddeck[i1];
				if (ccardPile2[i1-5] == crowncard){
					ccardPile2[i1-5] = ccardPile2[0];
				ccardPile2[0] = crowncard;
			}
			}
			for ( int i1=10; i1 <= 14;i1++){
			ccardPile3[i1 - 10] = carddeck[i1];
				if (ccardPile3[i1-10] == crowncard){
					ccardPile3[i1-10] = ccardPile3[0];
				ccardPile3[0] = crowncard;
				}
			}
			for ( int i1=15; i1 <= 19;i1++){
			ccardPile4[i1 - 15] = carddeck[i1];
				if (ccardPile4[i1-15] == crowncard){
					ccardPile4[i1-15] = ccardPile4[0];
				ccardPile4[0] = crowncard;
				}}
			for ( int i1=20; i1 <= 24;i1++){
			ccardPile5[i1 - 20] = carddeck[i1];
				if (ccardPile5[i1-20]== crowncard){
					ccardPile5[i1-20] = ccardPile5[0];
				ccardPile5[0] = crowncard;
				
				}}
			
			ArrayList<Card[]> ccardPiles = new ArrayList<Card[]>(); 
			ccardPiles.add(ccardPile1);
			ccardPiles.add(ccardPile2);
			ccardPiles.add(ccardPile3);
			ccardPiles.add(ccardPile4);
			ccardPiles.add(ccardPile5);
			
			return ccardPiles;
		}
			
}

public class scrimish {
	private static int count;
	public static void main (String [] args){
		 Card[] deckarray = new Card[25];
		Deck carddeck = new Deck();
		 boolean gameover = false;
		 boolean attackerwon = false;
		Scanner input = new Scanner(System.in);
		ArrayList<Card[]> cardPiles = new ArrayList<Card[]>();
		ArrayList<Card[]> ccardPiles = carddeck.getComputerDeck();
		 String newLine = System.getProperty("line.separator");
		
		for (int j=0; j<=4; j++){
			Card[] array = new Card[5];
			System.out.println("Enter user pile number " +(j+1)+":");
			for (int i=0; i<=4; i++){
			 String x = input.next();
			 Card cx = new Card(x);
			 array[i] = cx;
				 
		 }		cardPiles.add(array);
		}
		
		while (gameover == false) {
		//human turn
		printinfo(cardPiles, ccardPiles);
		System.out.println(newLine + "Pick a pile (1 to 5) with the top card you want to attack the opponent:");
		int humanchpile = input.nextInt();
		humanchpile = humanchpile - 1;
		System.out.println("Pick which of the Opponent's Piles to attack:");
		int computerchpile = input.nextInt();
		computerchpile = computerchpile - 1;
		Card [] shieldattackpile = cardPiles.get(humanchpile);
		if (shieldattackpile[shieldattackpile.length -1 ].getCardtype().equals("S")){
			System.out.print("Cannot Attack with Shield");
			System.out.println(newLine + "Pick a pile (1 to 5) with the top card you want to attack the opponent:");
			int humanchpile2 = input.nextInt();
			humanchpile2 = humanchpile2 - 1;
			boolean[] bol = conflict(cardPiles.get(humanchpile), ccardPiles.get(computerchpile));
		}
		boolean[] bol = conflict(cardPiles.get(humanchpile), ccardPiles.get(computerchpile));
		
		gameover = bol[0];
		attackerwon = bol[1];
		printinfo(cardPiles, ccardPiles);
		
		if (gameover == false){
		
			// computer turn
			
		System.out.println(newLine + "Computer's turn:");
		System.out.println("Opponent's Pile attack:");
		conflict(getrandompile(ccardPiles), getrandompile(cardPiles));
		printinfo(cardPiles, ccardPiles);
		} 
		
		//conflict()
		
				//endgame(Player comp/human)
				// if crown is null in arraylist
		// Find top card for each chosen pile
		//		have index
		// Compare values
		// Set top card of losing pile to null
		}
		
		if (gameover = true && count % 2 == 0){
			System.out.println("Winner: Computer");
		} else 
				System.out.println("Winner: YOU");
	}
	
	public static boolean[] conflict(Card[] AttackPile, Card[] DefendPile) {
		boolean gameover = false;
		boolean attackerwon = false;
		int i = AttackPile.length;
		int j = DefendPile.length;
		do {
			i--;			
		} while ( AttackPile[i].getCardtype().equals("X") && i > 0) ;
		

		do {
			j--;
		} while (DefendPile[j].getCardtype().equals("X") && j > 0);
		
		
		if (DefendPile[j].getCardtype().equals("C")){
			gameover = true;
			attackerwon = true; 
		}
		if ((AttackPile[i].getCardtype().equals("C")) && !(DefendPile[j].getCardtype().equals("C"))) {
			gameover = true;
			attackerwon = false;
		}
		
		if (AttackPile[i].getCardtype().equals("A")){
			AttackPile[i].setCardtype("A");
			DefendPile[j].setCardtype("X");
			attackerwon = true;
			}else if (DefendPile[j].getCardtype().equals("S")){
				attackerwon = true;
			
		}
		
		

		
		if (!(AttackPile[i].getCardtype().equals("S")) && DefendPile[j].getCardtype().equals("A")){
			DefendPile[j].setCardtype("X");
			attackerwon = true;
		}
		if ((DefendPile[j].getCardtype().equals("S"))){
			AttackPile[i].setCardtype("X");
			DefendPile[j].setCardtype("X");
			attackerwon = true;
		}
		if (AttackPile[i].getAttackvalue() > DefendPile[j].getAttackvalue()){
			
			DefendPile[j].setCardtype("X");
			attackerwon = true;
		}
		
		if (AttackPile[i].getAttackvalue() == DefendPile[j].getAttackvalue()){
			DefendPile[j].setCardtype("X");
			AttackPile[i].setCardtype("X");
			attackerwon = true;
		}
		if (AttackPile[i].getAttackvalue() < DefendPile[j].getAttackvalue()){
			AttackPile[i].setCardtype("X");
			attackerwon = false;
		}
		
		boolean[] output = { gameover , attackerwon };
		count++;
		return output;
			}	
	
	
	public static void printinfo(ArrayList<Card[]> humanpiles , ArrayList<Card[]> computerpiles){
		String newLine = System.getProperty("line.separator");
		System.out.println(newLine + "Your Deck:");
		for (int i = 0; i <= 4; i++){
			 Card[] selectpile;
			 selectpile = humanpiles.get(i);
			 int x = i+1;
			 System.out.println(newLine + "Pile: " + x);
			for (int j = 0; j<= 4 ; j++){
				System.out.print(selectpile[j].getCardtype() + " ");
				
			}
		}
		System.out.println(newLine + "Computer Deck:");
		for (int j = 0; j <= 4; j++){
			Card[] cselectpile;
			cselectpile = computerpiles.get(j);
			int x = j+1;
			System.out.println(newLine + "Pile: " + x);
			for (int i=0; i <= 4; i++){

				System.out.print(cselectpile[i].getCardtype()+ " ");
			}
		}
	}
	public static Card[] getrandompile(ArrayList<Card[]> piles ){
		int randomNum = (int)(Math.random()* 4);
		return piles.get(randomNum);
		
	}
}
		
	


