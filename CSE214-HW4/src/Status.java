
public enum Status {
    Available(1), Holding(2), OnRide(3) ;
	private final int value;
	
	private Status (int value) { this.value = value; }
   public static Status getTypeByOrdinal(int ordinal) {
       for(Status  t : Status.values()) {
           if(t.ordinal() == ordinal) {
               return t;
           }
       }

       return null;
}
}

