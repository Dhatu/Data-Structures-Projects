
public class CarList {
	public CarListNode head;
	public CarListNode tail;
	private CarListNode cursor;
	private int ownerCount = 0;
	public CarList(){
		head = null;
		tail = null;
		cursor = null;
	}
	
	
	
	public void setHead(CarListNode head) {
		this.head = head;
	}



	public void setTail(CarListNode tail) {
		this.tail = tail;
	}



	public void setCursor(CarListNode cursor) {
		this.cursor = cursor;
	}



	public void setOwnerCount(int ownerCount) {
		this.ownerCount = ownerCount;
	}

	

	public CarListNode getHead() {
		return head;
	}



	public CarListNode getTail() {
		return tail;
	}



	public CarListNode getCursor() {
		return cursor;
	}



	public int getOwnerCount() {
		return ownerCount;
	}



	//Default constructor which initializes this object to an empty list of Cars.
	//Postconditions:
	//This CarList has been initialized with head, tail, and cursor all set to null.
	public int numCars(){
		{
			CarListNode cursor1 = head;
			CarListNode cursor2 = tail;
			int answer = 0;
			while (cursor1 != null ) {
			answer++;
			cursor1 = cursor1.getnextLink();
			}
			int answer1 = 0;
			while (cursor1 == null || cursor2 != null ) {
				answer1++;
				cursor2 = cursor2.getnextLink();
				}
			return answer;
			
			}	
	//Returns the total number of Cars in the list.
	//This method should run in O(1) time.
	}
	public Car getCursorCar(){
		Car cursorref = cursor.getData();
		if (cursorref == null){
			return null;
		}else {
			return cursorref;
		}	
	//Gets the reference to the Car wrapped by the CarListNode currently referenced by cursor.
	//Returns the reference by the Car wrapped by the CarListNode currently referenced by cursor. If the cursor is null, then this method should return null as well (i.e. the cursor does not reference an Car).
	}
	public void resetCursorToHead(){ //H
		if (head != null){
			cursor = head;
		} else {
			cursor = null;
		}
				
	//Returns the cursor to the start of the list.
	//Postconditions:
	//If head is not null, the cursor now references the first CarListNode in this list.
	//If head is null, the cursor is set to null as well (there are no Cars in this list).
	}
	public void resetCursorToTail() { //T
		if (tail != null){
			cursor = tail;
		} else {
			cursor = null;
		}
		
		//Returns the cursor to the start of the list.
		//Postconditions:
		//If tail is not null, the cursor now references the last CarListNode in this list.
		//If tail is null, the cursor is set to null as well (there are no Cars in this list).
		}
	public void cursorForward() throws EndofListException{ //F
		if (cursor != tail ){
		cursor = cursor.getnextLink();
		} else {
			throw new EndofListException("Cursor is at the tail of the list");
		}
	//Moves the cursor to select the next CarListNode in the list. If the cursor is at the tail of the list, this method throws an exception (this includes the case where cursor and tail are both null).
	//Throws:
	//EndOfListException if cursor is at the tail of the list.
	}
	public void cursorBackward() throws EndofListException { //B
		if (cursor != head ){
			cursor = cursor.getprevLink();
			} else {
				throw new EndofListException("Cursor is at the head of the list");
				
				}
			}
	//Moves the cursor to select the previous CarListNode in the list. If the cursor is at the head of the list, this method throws an exception (this includes the case where cursor and head are both null).
	//Throws:
	//EndOfListException if cursor is at the head of the list.
	
	public void insertBeforeCursor(Car newCar){ //V
		if(newCar == null){
			throw new IllegalArgumentException("Try again with proper argument.");
		}
		CarListNode ncarNode =
				new CarListNode (newCar);
				if (cursor == null)
				{
				head = ncarNode;
				tail = ncarNode;
				cursor = ncarNode;
				}
				else {
				if (cursor != head){
					cursor.getprevLink().setnextLink(ncarNode);
					ncarNode.setnextLink(cursor);
					ncarNode.setprevLink(cursor.getprevLink());
					cursor.setprevLink(ncarNode);
				} else {
					ncarNode.setnextLink(head);
					head.setprevLink(ncarNode);
					head= ncarNode;
				}
				//ncarNode.setprevLink
				//cursor.getprevLink());
				//cursor.setprevLink(ncarNode);
				//cursor = ncarNode;
				//if (cursor.getprevLink() == null)
				//tail = cursor;
				}
				
				 ownerCount++;
	//Inserts the indicated Car before the cursor.
	//Preconditions:
	//newCar is not null.
	//Postconditions:
	//newCar has been wrapped in a new CarListNode object.
	//If cursor was previously not null, the newly created CarListNode has been inserted into the list before the cursor.
	//If cursor was previously null, the newly created CarListNode has been set as the new head of the list (as well as the tail).
	//The cursor remains unchanged.
	//Throws:
	//IllegalArgumentException if newCar is null.
	//Warning:
	//You should NOT move data references around between CarListNodes to accomplish this method. Instead, you should wrap the newCar object in a new CarListNode object, and insert this object into the list before the cursor.
	}
	public void appendToTail(Car newCar){ //A
		if(newCar == null){
			throw new IllegalArgumentException(" Try again with proper argument.");
		} else {
		CarListNode ncarNode =
				new CarListNode (newCar);
				if (head == null && tail == null)
				{
				head = ncarNode;
				tail = ncarNode;
				cursor = ncarNode;
				}
				else {
					ncarNode.setprevLink(tail);
					tail.setnextLink(ncarNode);	
					tail = ncarNode;
					
				}
		}
	//Inserts the indicated Car after the tail of the list.
	//Preconditions:
	//newCar is not null.
	//Postconditions:
	//newCar has been wrapped in a new CarListNode object.
	//If tail was previously not null, the newly created CarListNode has been inserted into the list after the tail.
	//If tail was previously null, the newly created CarListNode has been set as the new head of the list (as well as the tail and the cursor).
	//The tail now references the newly created CarListNode.
	//Throws:
	//IllegalArgumentException if newCar is null.
	//Note:
	//This insertion method does not affect the cursor, unless the list was previously empty. In that case, head, tail, and cursor should all reference the new CarListNode.
	}
		public void removeCursor() throws EndofListException { //R
			if (cursor != null){
						if (cursor != head && cursor != tail){
							cursor.getnextLink().setprevLink(cursor.getprevLink());
							cursor.getprevLink().setnextLink(cursor.getnextLink());
							cursor = cursor.getprevLink();
							//maybe make the removed null?
						} else if (cursor == head){
							 head = cursor.getnextLink();
							 cursor.setnextLink(null);
							 head.setprevLink(null);
							 cursor = head;
							//maybe make the removed null?
						}if (cursor == tail){
							 tail = cursor.getprevLink();
							 cursor.setprevLink(null);
							 tail.setnextLink(null);
							 cursor = tail;
							//maybe make the removed null?
						}	
			}else {
				throw new EndofListException("Cursor is null...so it doesn't exist");
			}
			ownerCount--;
	//Removes the CarListNode referenced by cursor and returns the Car inside.
	//Preconditions:
	//cursor is not null.
	//Postconditions:
	//The CarListNode referenced by cursor has been removed from the list.
	//All other CarListNodes in the list exist in the same Car as before.
	//The cursor now references the previous CarListNode (or the head, if the cursor previously referenced the head of the list).
	//Throws:
	//EndOfListException if cursor is null.
	}
		public CarListNode removeCursor2() throws EndofListException { //R
			CarListNode cursorref = cursor;

			if (cursor != null){
						if (cursor != head && cursor != tail){
							cursor.getnextLink().setprevLink(cursor.getprevLink());
							cursor.getprevLink().setnextLink(cursor.getnextLink());
							cursorref = cursor;
							cursor = cursor.getprevLink();
							//maybe make the removed null?
						} else if (cursor == head){
							 head = cursor.getnextLink();
							 cursor.setnextLink(null);
							 head.setprevLink(null);
							 cursorref = cursor;
							 cursor = head;
							//maybe make the removed null?
						}if (cursor == tail){
							 tail = cursor.getprevLink();
							 cursor.setprevLink(null);
							 tail.setnextLink(null);
							 cursorref = cursor;
							 cursor = tail;
							//maybe make the removed null?
						}	
			}else {
				throw new EndofListException("Cursor is null...so it doesn't exist");
			}
			ownerCount--;
			return cursorref;
	//Removes the CarListNode referenced by cursor and returns the Car inside.
	//Preconditions:
	//cursor is not null.
	//Postconditions:
	//The CarListNode referenced by cursor has been removed from the list.
	//All other CarListNodes in the list exist in the same Car as before.
	//The cursor now references the previous CarListNode (or the head, if the cursor previously referenced the head of the list).
	//Throws:
	//EndOfListException if cursor is null.
	}
	public static CarList mergeLists (CarList list1, CarList list2){
		if(list1 == null){
			list1 = list2;
			list1.setHead(list2.getHead());
			list1.setTail(list2.getTail());
			list1.setCursor(list2.getCursor());
			list2.setTail(null);
			list2.setHead(null);
			list2.setCursor(null);
			return list1;
		}
		if(list2 == null){
			return list1;
		}
		
		list1.getTail().setnextLink(list2.getHead());
		list2.getHead().setprevLink(list1.getTail());
		list1.setTail(list2.getTail());
		list2.setTail(null);
		list2.setHead(null);
		list2.setCursor(null);		
		return list1;
	}
		
	public String toString(){
				CarListNode nodepointer = head;
				CarListNode tailref = tail;
				int n = 0;
				String OwnerList = "";
				System.out.println();
				while (nodepointer != null ){
				//for(int n = 0; n < ownerCount ; ++n){
					if (nodepointer == cursor){
						System.out.print("C => ");
					}
					
					System.out.println(nodepointer.getData().getName() + "        " + nodepointer.getData().getMake());
					
					nodepointer = nodepointer.getnextLink();
					
					
			
					
				
			//You must write a toString() method. You can use this method to help you with printing the StudentList for the output.
			
				}
				return OwnerList;
				}
}
