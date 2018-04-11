
public enum ComponentType {
	Button(1), Label(2), TextArea(3),HBox(4), VBox(5), AnchorPane(6) ;
	private final int value;
	
	private ComponentType(int value) { this.value = value; }
    public static ComponentType getTypeByOrdinal(int ordinal) {
        for(ComponentType t : ComponentType.values()) {
            if(t.ordinal() == ordinal) {
                return t;
            }
        }

        return null;
    }	
	
	/*Write a fully documented enum called ComponentType. It should contain 
	the values Button, Label, TextArea, HBox, VBox, and AnchorPane. 
	This will help your program operate as desired (as Containers have no text,
	 and Controls have no children). A toString() method may be helpful. */
}
