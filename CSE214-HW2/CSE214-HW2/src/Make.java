
public enum  Make {
	     FORD(0), GMC(1), CHEVY(2),JEEP(3), DODGE(4), CHRYSLER(5) , LINCOLN(6) ;
		private final int value;
		
		private Make(int value) { this.value = value; }
	    public static Make getTypeByOrdinal(int ordinal) {
	        for(Make t : Make.values()) {
	            if(t.ordinal() == ordinal) {
	                return t;
	            }
	        }

	        return null;
	    }

	}
	




/*
public enum  Make {
	
	private int brand;
     
	FORD(0), GMC(1), CHEVY(2), JEEP(3), DODGE(4), CHRYSLER(5) , LINCOLN(6);


private Make(int brand) { this.brand = brand; }
     

public int getValue() { 
    	return this.brand;
}
}
*/