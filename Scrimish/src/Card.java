public class Card {
	private String cardtype;
	private int attackvalue;
	private boolean isArcher = false;
	private boolean isShield = false;
	private boolean isCrown = false;
	
	
	public Card(String cardtype ){
		
		this.cardtype = cardtype;
		
		switch (cardtype){
		    case "D":
		    	attackvalue = 1;
		    	break;
		    case "s":
		    	attackvalue = 2;
		    	break;
		    case "M":
		    	attackvalue = 3;
		    	break;
		    case "W":
		    	attackvalue = 4;
		    	break;
		    case "H":
		    	attackvalue = 5;
		    	break;	
		    case "L":
		    	attackvalue = 6;
		    	break;
		    case "A":
		    	isArcher = true;
		    	break;
		    case "S":
		    
		    	isShield = true;
		    	break;
		    case "C":
		    	isCrown = true;
		    	break;
		    case "X":
		    	break;
		    
	}
	
	}
	public int getcardattackvalue(){
		return attackvalue;
	}

	public String getCardtype() {
		return cardtype;
	}


	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}


	public int getAttackvalue() {
		return attackvalue;
	}


	public void setAttackvalue(int attackvalue) {
		this.attackvalue = attackvalue;
	}


	public boolean isArcher() {
		return isArcher;
	}


	public void setArcher(boolean isArcher) {
		this.isArcher = isArcher;
	}


	public boolean isShield() {
		return isShield;
	}


	public void setShield(boolean isShield) {
		this.isShield = isShield;
	}


	public boolean isCrown() {
		return isCrown;
	}


	public void setCrown(boolean isCrown) {
		this.isCrown = isCrown;
	}	
}
