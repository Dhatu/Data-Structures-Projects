

public class PackageStack{

	public int packnum = 0;
	private final int CAPACITY = 7;
	public PackageNode head;
	public PackageNode tail;
	private PackageNode cursor = head;
	private int ownerCount = 0;
	public PackageStack(){
		head = null;
		tail = null;
		cursor = head;
	}
	
	
	public void setHead(PackageNode head) {
		this.head = head;
	}



	public void setTail(PackageNode tail) {
		this.tail = tail;
	}



	public void setCursor(PackageNode cursor) {
		this.cursor = cursor;
	}



	public void setpackCount(int packnum ) {
		this.packnum  = packnum ;
	}

	

	public PackageNode getHead() {
		return head;
	}



	public PackageNode getTail() {
		return tail;
	}



	public PackageNode getCursor() {
		return cursor;
	}



	public int getOwnerCount() {
		return ownerCount;
	}
    public String toString(){

		PackageNode nodepointer = head;
		PackageNode tailref = tail;
		int n = 0;
		String OwnerList = "";
		while (nodepointer != null ){
		//for(int n = 0; n < ownerCount ; ++n){
			//if (nodepointer == cursor){
			//	System.out.print("C => ");
			//}
			
			System.out.print("[" + nodepointer.getData().getrecipient() + " " + nodepointer.getData().getarrivalDate()+ "]");
			
			nodepointer = nodepointer.getnextLink();
			
			
	
			
		
	//You must write a toString() method. You can use this method to help you with printing the StudentList for the output.
	
		}
		return OwnerList;
		
			}
    
	public void pushPackage(Package x) throws FullStackException{
		if( isFull() == false){
		PackageNode npackNode = new PackageNode (x);
	    //temp.getnextLink() = tail;
	    //tail = temp;
		if (head == null && tail == null)
				{
				head = npackNode;
				tail = npackNode;
				cursor = npackNode;
				}
				else {
					tail.setnextLink(npackNode);	
					tail = npackNode;
	    packnum++;
		}}
		else {
			throw new FullStackException("Package stack is Full...move to next stack or change places");
		}
	    
		/*Pushes x onto the top of the backing data structure.
			Throws:
			FullStackException if the stack is at capacity.
			If you are extending LinkedList, you may rename this pushPackage(Package x) if your IDE is complaining about throwing a FullStackException
		*/
	}
	public Package popPackage() throws  EmptyStackException{
		
		if ( isEmpty() == false){
				Package returnValue ;
				if (head == tail){
				    returnValue =head.getData() ;
					head = null;
					tail = null;
					packnum--;//Decrement count
				    return  returnValue;
				}
				if ( head.getnextLink() == tail  ){
					  returnValue =tail.getData() ;
					    tail= head;
					    packnum--;//Decrement count
					    return  returnValue;
				}
			while (cursor.getnextLink() != tail){
				cursor.getnextLink();
			}
			returnValue = tail.getData();
			tail = cursor;
			cursor = head;
	
			//	tail = cursor.getprevLink();
			//	 cursor.setprevLink (null);
			//	 tail.setnextLink(null);
			//	 cursor = tail;
			
			//tail=tail.getnextLink();
			//Package returnValue =(Package)tail.getData() ;
		   // tail=tail.getnextLink();
		    packnum--;//Decrement count
		    return  returnValue;
			} else {
				throw new EmptyStackException("Package stack is empty... nothing to remove!");
			}
		/*Removes the topmost package from the stack and returns it.
			Throws:
			EmptyStackException if the stack was empty.
			If you are extending LinkedList, you may rename this popPackage() if your IDE is complaining about throwing a EmptyStackException
		*/

	}
	public Package peek() throws EmptyStackException{
		Package answer;
		if (isEmpty() == true){ // isEmpty()
			throw new EmptyStackException("Package stack is empty... nothing to remove!");
		}
		answer = tail.getData();
		return answer;

			/*Returns the topmost Package from the stack without removing it. The stack should be unchanged as a result of this method.
			Throws:
			EmptyStackException if the stack was empty */
	}
	public boolean isFull(){
		if (packnum > 7){
			return true;
		}else {
			return false;
		}
	}
			//Returns true if the stack is full, false otherwise.
	public boolean isEmpty(){
		if (tail != null){
				return false;
		}else {
			return true;
		}
		
	}
			//Returns true if the stack is empty, false otherwise.
}

