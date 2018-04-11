
public class FXTreeNode {
	/*Write a fully documented class called FXTreeNode which holds the type of component 
	being represented, an array of children (null if this will be a Control), and string 
	for the text (null if this is a Container). Be sure to include all getters and setters.
	You may find it helpful to write helper methods, especially to check input before adding
	a child to the tree. Defining custom exceptions for actions like trying to add too many 
	children to a node, or adding a child in an invalid position may also be desirable. */
	private String text ;
	private ComponentType type;
	private FXTreeNode parent;
	final int maxChildren=10;
	private FXTreeNode[] children =  new FXTreeNode[maxChildren] ; //Just like in hw 1, there should be no holes in the array.
	   //A full node exception may be desirable.
	private int childrencount = 0;
	public FXTreeNode() {
		// TODO Auto-generated constructor stub
	}
	public FXTreeNode(String text,ComponentType type,FXTreeNode parent, FXTreeNode[] children) {
		this.type = type;
		this.text = text;
		this.parent = parent;
		this.children = children;
	}
	public ComponentType getType() {
		return type;
	}
	public void setType(ComponentType type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public FXTreeNode getParent() {
		return parent;
	}
	public void setParent(FXTreeNode parent) {
		this.parent = parent;
	}
	public FXTreeNode[] getChildren() {
		return children;
	}
	public void setChildren(FXTreeNode[] children) {
		this.children = children;
	}
	public FXTreeNode getChildrennode2( int index){
		return children[index];
	}
	public 	FXTreeNode getChildrennode( FXTreeNode[] children ,int index){
		return children[index];
	}
	
	public void setnewChildrenindex( int index , int newindex){
		index = newindex;
	}
	public void setnewChildrennode( int index , FXTreeNode newvalue){
		children[index] = newvalue;
	}
	public int getChildrencount() {
		return childrencount;
	}
	public void setChildrencount(int childrencount) {
		this.childrencount = childrencount;
	} 
}
