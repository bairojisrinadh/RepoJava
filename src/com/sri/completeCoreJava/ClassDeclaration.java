package com.sri.completeCoreJava;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *	Examine the ColorChanger class in Listing 2.1
	and see if you can determine its instance and class variables, methods, constructors, nested
	classes and instance and static initializers. The class displays a window with three buttons
	in it, and clicking a button changes the background color of the window.
 */
public class ClassDeclaration extends Frame {
	
	//instance variables
	private Button redBtn, whiteBtn, blueBtn;
	
	//below block of code in curly braces '{}' is termed as instance block initializers. executed at the time of object instantiation i.e., new ClassDeclaration("Click a Button");
	{
		redBtn = new Button("Red");
		whiteBtn = new Button("White");
		blueBtn = new Button("Blue");
		System.out.println("End of Instance initializer!!");
	}
	
	//class member fields (or) static fields
	private static final Color RED, WHITE, BLUE;
	
	//private static final int NORTH = -1, SOUTH = -1, WEST = 0; --> No use, instead we need to use BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.WEST
	
	//below block of code in curly braces '{}' is termed as static block initializers. executed at the time of class loading.
	static{
		RED = new Color(255, 0, 0);
		WHITE = new Color(255,255,255);
		BLUE = new Color(0,0,255);
		System.out.println("End of Static initializer!!");
	}
	
	/*
	 * 1. Inner class, can be accessed as just instantiating the inner class object. If same class is being called in different class of same/other package then 
	   2. Inner class instantiation needs to be like this, 
	 *     ClassDeclaration cd = new ClassDeclaration();
	 * 	   ClassDeclaration.MyButtonListener innerClass = cd.new MyButtonListener(); 
	 *     (or)
	 * 	   ClassDeclaration.MyButtonListener innerClass = new ClassDeclaration().new MyButtonListener();
	 * 
	 */
	public class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String label = e.getActionCommand();
			if(label.equals(redBtn.getLabel())){
				ClassDeclaration.this.setBackground(RED);
			}else if(label.equals(whiteBtn.getLabel())){
				ClassDeclaration.this.setBackground(WHITE);
			}else if(label.equals(blueBtn.getLabel())){
				ClassDeclaration.this.setBackground(BLUE);
			}
			System.out.println("End of MyButtonListener, actionPerformed() Method");
		}
	}
	
	public static Color[] getColors(){
		Color [] colors = {RED,WHITE,BLUE};
		System.out.println("End of getColors() Method");
		return colors;
	}
	
	public Button [] getButtons(){
		Button [] buttons = {redBtn, whiteBtn, blueBtn};
		System.out.println("End of getButtons() Method");
		return buttons;
	}
	
	/* If not mention any constructor, compiler will automatically create no-arg constructor while compilation i.e., .class file creation.
	Else if we mention any 1-arg, 2-arg, so on.. then constructor won't create any no-arg constructor while compilation. */	
	
	//Constructor without arguments
	public ClassDeclaration(){};
	
	//Constructor with argument
	public ClassDeclaration(String title){
		super(title);
		layoutButtons();
		initializeEvents();
		this.setSize(200, 200);
		this.setVisible(true);
		System.out.println("End of ClassDeclaration() Constructor");
	}
	
	//Instance Method
	public void initializeEvents() {
		MyButtonListener listener = new MyButtonListener();
		redBtn.addActionListener(listener);
		whiteBtn.addActionListener(listener);
		blueBtn.addActionListener(listener);
		System.out.println("End of initializeEvents() Method");
	}

	//Instance Method
	public void layoutButtons() {
		this.setLayout(new BorderLayout());
		this.add(redBtn,BorderLayout.NORTH);
		this.add(whiteBtn, BorderLayout.SOUTH);
		this.add(blueBtn, BorderLayout.WEST);
		System.out.println("End of layoutButtons() Method");
	}

	//Static Method
	public static void main(String[] args) {
		new ClassDeclaration("Click a Button");
		System.out.println("End of main() Method");
		
		/*ClassDeclaration.MyButtonListener innerClass = new ClassDeclaration().new MyButtonListener();
		System.out.println(innerClass.toString());*/
	}

}
