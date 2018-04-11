
public class FXComponentTree {
	/*Write a fully documented class called FXComponentTree which will 
	serve as the tree manager for your FXComponentTree. This must hold 
	references into a tree (the root and cursor), as well as be able to 
	generate and save the tree to and from a file. Again, defining some 
	custom exceptions may be helpful for code readability.
	 */
	private FXTreeNode root;
	private FXTreeNode cursor;
	public void cursorToRoot(){
		setCursor(root);
	//Sets the cursor to the root of the FXComponentTree
	}
	public FXComponentTree(){
//		FXTreeNode temp = new FXTreeNode();
//		temp.setType(ComponentType.AnchorPane);
//		root = temp;
//		cursor = root;
	}
	public void deleteChild(int index) throws ElementNotFoundException{

		      FXTreeNode result = null;
		      boolean found = false;
		if( cursor.getChildrennode2( index) != null)
	         {
	            found = true;
	            result = cursor.getChildrennode2( index);   
	            FXTreeNode[] temp = new FXTreeNode[cursor.getChildren().length];
	            int j = 0;
	            for(int i = 0; i<cursor.getChildren().length; i++) {
	                if(i != index)
	                {
	                    temp[j] = cursor.getChildrennode2( i);
	                    j++;
	                }
	            }
	            //studentNamesArray[nameArrayCount-1] = studentName
	            temp[cursor.getChildren().length-1] = null;
	            cursor.setChildren(temp);
	        }


	      if (!found)
	         throw new ElementNotFoundException("element not found in the binary tree");
	      
	      int temp = cursor.getChildrencount();
	      cursor.setChildrencount(-1);
	      for (int i = 0; i <= temp; i++)
	         if (cursor.getChildrennode(cursor.getChildren(), index) != null)
	        	 cursor.setChildrencount(i);
				
	//Removes the child at the specified index oftheFXComponentTree, as well as all of its children.
	}
	public void addChild(int index, FXTreeNode node){
		if( index > 9){
			return;
		}
		FXTreeNode newNode;
		boolean done = false;
		if (root == null) {
			newNode = new FXTreeNode();
			newNode = node;
			root = newNode;
			cursor= root;
		}
		else {
		         boolean added = false;

		        if(cursor.getChildrennode2(index) != null ){
		        	FXTreeNode replacednode = cursor.getChildrennode2( index);
		            for(int i=0; i< cursor.getChildren().length-1; i++) {

		                if (i == index){

		                    for (int j = cursor.getChildren().length-1; j >= index; j-- ){
		                    	cursor.setnewChildrenindex( j , j-1);
		                    }
		                    cursor.setnewChildrennode( index, node);
		                }

		            }
		        } else {
		        	cursor.setnewChildrennode( index, node);
		        	//find holes
		        	//if statement of hole exists
		        	//shift left...
		        	for (int j = index; j > 0; j-- ){
		        		if (cursor.getChildrennode2( j) == null && cursor.getChildrennode2( j-1) != null){
		        			cursor.setnewChildrennode( j, node);
		        			cursor.setnewChildrennode( index, null);
		        			//delete index node or change to null
		        		}
		        		if (cursor.getChildrennode2( j) == null){
		        			break; }
		        		
		        		
		        		}
		        	}
		        	
		        }
		      }//else
	//Adds the given node to the corresponding index of the children array.
	//Should throw an exception if adding the node at the specified index makes a hole in the array.

	public void setTextAtCursor(String text){
		this.cursor.setText(text);
	//Sets the current node’s text to the specified text.
	}
	public void cursorToChild(int index){
		this.setCursor(cursor.getChildrennode2(index));

	//Moves the cursor to the child node of the of the cursor corresponding to the specified index.
	}
	public void cursorToParent(){
		this.setCursor(cursor.getParent());

	//Moves the cursor to the parent of the curresnt node.
	}
	public static FXComponentTree readFromFile(String filename){
		return null;
	//Generates the FXComponentTree based on the file name that is passed in.
	}
	public static void writeToFile(FXComponentTree tree, String filename){
	//Generates a text file that reflects the structure of the FXComponentTree.
	//The format of the tree of the file should match the format of the input file.
	}

	public FXTreeNode getCursor() {
		return cursor;
	}
	public void setCursor(FXTreeNode cursor) {
		this.cursor = cursor;
	}
	public FXTreeNode getroot() {
		return root;
	}
	public void setroot(FXTreeNode root) {
		this.root = root;
	}
}
