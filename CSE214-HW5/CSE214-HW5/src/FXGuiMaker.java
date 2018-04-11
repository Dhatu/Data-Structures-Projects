import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FXGuiMaker {
	//Write a fully-documented class named FXGuiMaker that takes in a text file, generates a FXComponentTree and provides an interface for a user to manipulate the tree. Please see the UI required functions for the required functionality
	public static void main(String[] args) throws FileNotFoundException, ElementNotFoundException{
		Scanner input = new Scanner(System.in);
		
		FXComponentTree GuiTree = new FXComponentTree();
		
		
		
		System.out.println("Welcome to counterfeit SceneBuilder.");
		String option = "";
		
		while(!option.equals("Q")){
			System.out.println();
			System.out.println("Menu:" + "\n" +
		    "L) Load from file" + "\n" +
		    "P) Print tree" + "\n" +
		    "C) Move cursor to a child node" + "\n" +
		    "R) Move cursor to root" + "\n" +
		    "A) Add a child"+ "\n" +
		    "E) Edit text of cursor"+ "\n" +
		    "D) Delete child"+ "\n" +
		    "S) Save to file"+ "\n" +
		    "Q) Quit");

			System.out.println("Please select an option:");
			option = input.next().toUpperCase();
			if(option.equals("L") ){
				System.out.print("Please enter filename:");
				String filename = input.next();
				File file= new File("C:\\Users\\sudhi\\workspace\\CSE214-HW5\\" + filename);
				Scanner sc = new Scanner(file);
				//System.out.println( filename + " not found.");
			
					

			        while ( sc.hasNextLine()){
			        	ComponentType enumref = null;
						String textref = null;
			        	// limit space to 2
			        	//limit - to 4
			        	// numbers 0-10 represents child and postion
			        	// - represents new dash 
			        	// 0-0-2-3-2 --> s.split("-")
			        	String[] splitarray = sc.nextLine().split(" ",3);
			        	System.out.println(splitarray[0].toString() +" " + splitarray[1].toString());
			        	switch(splitarray[1]){
		        		case "Button":
		        				enumref = ComponentType.Button;
		        				textref = splitarray[2];
		        				break;
		        		case "AnchorPane" :
		        				enumref = ComponentType.AnchorPane;
		        				
		        				break;
		        		case "VBox": 
		        				enumref = ComponentType.VBox;
		        				break;
		        		case "TextArea" :
	        					enumref = ComponentType.TextArea;
	        					textref = splitarray[2];
		        				break;
		        		case "Label":
        						enumref = ComponentType.Label;
        						textref = splitarray[2];
		        				break;
		        		case "HBox":
        						enumref = ComponentType.HBox;
		        				break;
			        	}
			        	
		        		FXTreeNode cursortemp = new FXTreeNode();
			        	String[] splitindex = splitarray[0].split("-");
			        	int[] splitint = new int[splitindex.length];
			        	
			        	for ( int n = 0; n < splitindex.length; n++) {
			        		splitint[n] = Integer.parseInt(splitindex[n]);
			        	}
			        	for ( int i = 0; i < splitint.length-1; i++){
			        		
			        		if (i == 0){
			        				GuiTree.setCursor(GuiTree.getroot());
			        		}else {
			        				 GuiTree.cursorToChild(splitint[i]);
			        				 
			        		}
			        	}
			        	
			        FXTreeNode temp1 = new FXTreeNode();
			        temp1.setType(enumref);
			        if ( enumref == ComponentType.TextArea || enumref == ComponentType.Label || enumref == ComponentType.Button ){
			        temp1.setText(textref);
			        }
			        //GuiTree.getCursor().setnewChildrennode(splitint[splitint.length-1], temp1);
			        GuiTree.addChild(splitint[splitint.length-1], temp1);
			        }
			        System.out.println( filename + "loaded");
			        }
			
	

			if(option.equals("P") ){
        		FXTreeNode cursortemp2 = new FXTreeNode();
				System.out.println(GuiTree.getroot().getType().toString());
				FXTreeNode cursorref = GuiTree.getCursor();
				GuiTree.setCursor(GuiTree.getroot());
				GuiTree.cursorToChild(0);
				if (cursorref == GuiTree.getroot().getChildrennode2(0)){
				System.out.println( "==>" + GuiTree.getCursor().getType());
				} else {
					System.out.println("--+" + GuiTree.getCursor().getType());
				}
				System.out.println("\t" + "--+" + GuiTree.getCursor().getChildrennode2(2).getType().toString());
				System.out.println("\t" + "--+" + GuiTree.getCursor().getChildrennode2(2).getChildrennode2(0).getType().toString());
				for ( int i = 0;  GuiTree.getCursor().getChildrennode2(i) != null ; i++){
					if (GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.AnchorPane || 
							GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.HBox || 
							GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.VBox) 
					{
						if (cursorref == GuiTree.getCursor().getChildrennode2( i)){ ///BOIIII
						System.out.println( "\t" + "\t" + "==>" + GuiTree.getCursor().getChildrennode2( i).getType().toString());
						} else {
						System.out.println( "\t" + "\t" + "--+" + GuiTree.getCursor().getChildrennode2( i).getType().toString());
						}
					}
					if (GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.TextArea || 
							GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.Label || 
							GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.Button)
					{
						if (cursorref == GuiTree.getCursor().getChildrennode2( i)){ ///BOIIII
					
					System.out.println("\t" + "\t" + "==>" + GuiTree.getCursor().getChildrennode2(i).getType().toString() + ":" + 
							GuiTree.getCursor().getChildrennode2( i).getText().toString() );
					} else {
						System.out.println("\t" + "\t" + "--+" + GuiTree.getCursor().getChildrennode2( i).getType().toString() + ":" + 
								GuiTree.getCursor().getChildrennode2(i).getText().toString() );

					}
					}
					for ( int j = 0; GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j) != null ; j++){
						
						if (GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.AnchorPane || 
							GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.HBox || 
							GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.VBox)
						{	
							if (cursorref == GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j)){ ///BOIII
							System.out.println( "\t" + "\t" + "\t" + "==>" + 
							GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString());
							} else {
								System.out.println( "\t" + "\t" + "\t" + "--+" + 
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString());	
							}
						}
						if (GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.TextArea || 
								GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType() == ComponentType.Label || 
								GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType() == ComponentType.Button)
						{	
							if (cursorref == GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j)){ ///BOIII
								System.out.println( "\t" + "\t" + "\t" + "==>" + 
										GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getType().toString() + ":" + 
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getText().toString());
							} else {
								System.out.println( "\t" + "\t" + "\t" + "--+" + 
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString() + ":" + 
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getText().toString());
							}
						}
						for ( int g = 0; GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g) != null ; g++){
							if (GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.AnchorPane || 
									GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2(g).getType() == ComponentType.HBox || 
									GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getChildrennode2( g).getType() == ComponentType.VBox)
							{	
								if (cursorref == GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getChildrennode2( g)){ ///BOIII	
								System.out.println( "\t" + "\t" + "\t" + "\t" + "==>" + 
									GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString());
								} else {
									System.out.println( "\t" + "\t" + "\t" + "\t" + "--+" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString());
								}
							}
								if (    GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.TextArea ||
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.Label ||												
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.Button)
								{	
									if (cursorref == GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getChildrennode2( g)){ ///BOIII	
										System.out.println( "\t" + "\t" + "\t" + "\t" + "==>" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString() + ":" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getText().toString());
										} else {
											System.out.println( "\t" + "\t" + "\t" + "\t" + "--+" + 
													GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString() + ":" + 
													GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getText().toString());
										}
								}
							}
						}
				}
				GuiTree.setCursor(cursorref);
			}
			if(option.equals("C") ){
				System.out.println("Please enter number of child (starting with 0): ");
				int index = input.nextInt();
				GuiTree.cursorToChild(index);
				System.out.print("Cursor Moved to desired Child.");
			}
			
			if(option.equals("R") ){
				GuiTree.cursorToRoot();
				System.out.print("Cursor is at root.");
			}
			
			if(option.equals("A") ){
				System.out.println("Select component type (1 - Button, 2 - Label, 3 - TextArea, 4 - HBox, 5 - VBox):");
				int component = input.nextInt();
				if ( component == 4 || component == 5 ){
					FXTreeNode newnode = new FXTreeNode();
					ComponentType c1 = ComponentType.getTypeByOrdinal(component);
					newnode.setType(c1);
					System.out.println("Please enter an index: ");
					int index = input.nextInt();
					GuiTree.addChild(index, newnode);
					
				}
				if ( component == 1 || component == 2 || component == 3){
				FXTreeNode newnode = new FXTreeNode();
				ComponentType c2 = ComponentType.getTypeByOrdinal(component);
				newnode.setType(c2);
				
				System.out.println("Please enter text: ");
				String text = input.next();
				newnode.setText(text);
				System.out.println("Please enter an index: ");
				int index = input.nextInt();
				GuiTree.addChild(index, newnode);
				}
			}
			
			if(option.equals("E") ){
				System.out.println("Please enter new text:"); 
				String newtext = input.next();
				GuiTree.setTextAtCursor(newtext);
				System.out.println("Text Edited.");
			}
			
			if(option.equals("D") ){
				System.out.println("Please enter number of child (starting with 0):");
				int index = input.nextInt();
				GuiTree.deleteChild(index);
				System.out.print("Child removed");
			}
			
			if(option.equals("S") ){
				System.out.println("Please enter a filename:");
				String savename = input.nextLine();
				 File Fileright = new File( savename);

	             PrintWriter pw = new PrintWriter(Fileright);

	             FXTreeNode cursortemp2 = new FXTreeNode();
					System.out.println(GuiTree.getroot().getType().toString());
					FXTreeNode cursorref = GuiTree.getCursor();
					GuiTree.setCursor(GuiTree.getroot());
					GuiTree.cursorToChild(0);
					if (cursorref == GuiTree.getroot().getChildrennode2(0)){
					pw.println("==>" + GuiTree.getCursor().getType());
					System.out.println( "==>" + GuiTree.getCursor().getType());
					} else {
						pw.println("--+" + GuiTree.getCursor().getType());
						System.out.println("--+" + GuiTree.getCursor().getType());
					}
					
					for ( int i = 0;  GuiTree.getCursor().getChildrennode2(i) != null ; i++){
						if (GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.AnchorPane || 
								GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.HBox || 
								GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.VBox) 
						{
							if (cursorref == GuiTree.getCursor().getChildrennode2( i)){ ///BOIIII
							System.out.println( "\t" + "\t" + "==>" + GuiTree.getCursor().getChildrennode2( i).getType().toString());
							} else {
							pw.println("\t" + "\t" + "--+" + GuiTree.getCursor().getChildrennode2( i).getType().toString());
							System.out.println( "\t" + "\t" + "--+" + GuiTree.getCursor().getChildrennode2( i).getType().toString());
							}
						}
						if (GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.TextArea || 
								GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.Label || 
								GuiTree.getCursor().getChildrennode2( i).getType() == ComponentType.Button)
						{
							if (cursorref == GuiTree.getCursor().getChildrennode2( i)){ ///BOIIII
						pw.println("\t" + "\t" + "==>" + GuiTree.getCursor().getChildrennode2(i).getType().toString() + ":" + 
								GuiTree.getCursor().getChildrennode2( i).getText().toString() );
						System.out.println("\t" + "\t" + "==>" + GuiTree.getCursor().getChildrennode2(i).getType().toString() + ":" + 
								GuiTree.getCursor().getChildrennode2( i).getText().toString() );
						} else {
							pw.println("\t" + "\t" + "--+" + GuiTree.getCursor().getChildrennode2( i).getType().toString() + ":" + 
									GuiTree.getCursor().getChildrennode2(i).getText().toString() );
							System.out.println("\t" + "\t" + "--+" + GuiTree.getCursor().getChildrennode2( i).getType().toString() + ":" + 
									GuiTree.getCursor().getChildrennode2(i).getText().toString() );

						}
						}
						for ( int j = 0; GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j) != null ; j++){
							
							if (GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.AnchorPane || 
								GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.HBox || 
								GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.VBox)
							{	
								if (cursorref == GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j)){ ///BOIII
									pw.println("\t" + "\t" + "\t" + "==>" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString());
								System.out.println( "\t" + "\t" + "\t" + "==>" + 
								GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString());
								} else {
									pw.println("\t" + "\t" + "\t" + "--+" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString());	
									System.out.println( "\t" + "\t" + "\t" + "--+" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString());	
								}
							}
							if (GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getType() == ComponentType.TextArea || 
									GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType() == ComponentType.Label || 
									GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType() == ComponentType.Button)
							{	
								if (cursorref == GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j)){ ///BOIII
									pw.println( "\t" + "\t" + "\t" + "==>" + 
									GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getType().toString() + ":" + 
									GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getText().toString());
									System.out.println( "\t" + "\t" + "\t" + "==>" + 
											GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getType().toString() + ":" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getText().toString());
								} else {
									pw.println( "\t" + "\t" + "\t" + "--+" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString() + ":" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getText().toString());
									System.out.println( "\t" + "\t" + "\t" + "--+" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getType().toString() + ":" + 
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getText().toString());
								}
							}
							for ( int g = 0; GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g) != null ; g++){
								if (GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.AnchorPane || 
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2(g).getType() == ComponentType.HBox || 
										GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getChildrennode2( g).getType() == ComponentType.VBox)
								{	
									if (cursorref == GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getChildrennode2( g)){ ///BOIII	
										pw.println("\t" + "\t" + "\t" + "\t" + "==>" + 
												GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString());
									System.out.println( "\t" + "\t" + "\t" + "\t" + "==>" + 
										GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString());
									} else {
										 pw.println( "\t" + "\t" + "\t" + "\t" + "--+" + 
													GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString());
										System.out.println( "\t" + "\t" + "\t" + "\t" + "--+" + 
												GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString());
									}
								}
									if (    GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.TextArea ||
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.Label ||												
											GuiTree.getCursor().getChildrennode2(i).getChildrennode2( j).getChildrennode2(g).getType() == ComponentType.Button)
									{	
										if (cursorref == GuiTree.getCursor().getChildrennode2( i).getChildrennode2(j).getChildrennode2( g)){ ///BOIII	
											pw.println( "\t" + "\t" + "\t" + "\t" + "==>" + 
													GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString() + ":" + 
													GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getText().toString());
											System.out.println( "\t" + "\t" + "\t" + "\t" + "==>" + 
												GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString() + ":" + 
												GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getText().toString());
											} else {
												pw.println( "\t" + "\t" + "\t" + "\t" + "--+" + 
														GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString() + ":" + 
														GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getText().toString());
												System.out.println( "\t" + "\t" + "\t" + "\t" + "--+" + 
														GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getType().toString() + ":" + 
														GuiTree.getCursor().getChildrennode2(i).getChildrennode2(j).getChildrennode2( g).getText().toString());
											}
									}
								}
							}
					}
					GuiTree.setCursor(cursorref);
	             
	            /* for (int i = 0; i <= 3; i++) {
	                pw.println(i);
	                System.out.println(i);

	             }*/

	            
	             pw.close();
	     
				System.out.println("File saved.");
			}
			
			if(option.equals("Q") ){
				System.out.println("Make like a tree and leave!");
				option = "Q";
			}
			

	//The main method runs a menu driven application which first creates an FXComponentTree based on the passed in file and then prompts the user for a menu command selecting the operation. The required information is then requested from the user based on the selected operation. You can find the list of menu options in the UI required functions section.
	//FXComponentTree tree;
	}
	}
}

