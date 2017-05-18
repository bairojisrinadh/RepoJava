package com.sri.completeCoreJava;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This ColorChangerTest is just an example used for classpath set in SCJP_JAVA1.6.pdf
 * how to set class path using command prompt
 * set ClASSPATH = c:\myProjects\build;.;
 * else using commandline arguments we can also define class path using -classpath/-cp
 * 
 * java -cp c:\myProjects\build;. ColorChangerTest
 * 
 * also jar file creation using command prompt (jdk contains jar.exe in \bin folder, which helps in creating jar files
 * 
 * C:myProjects\build> jar -cvf myProject.jar .
 * 
 * -c flag: for creating new jar file
 * -v flag: verbose while processing files.
 * -f flag: define the filename 
 * . : indicates class files are found in present directory
 * 
 */
public class ColorChangerTest {

	public static void main(String[] args) {
		Button b = new Button("Testing...");
		b.setBackground(Color.GREEN);
		System.out.println("Color is "+ b.getBackground());

		ColorChanger c = new ColorChanger(b);
		ActionEvent action = new ActionEvent(b, ActionEvent.ACTION_PERFORMED, "blue");
		c.actionPerformed(action);
		System.out.println("Now the new Color is "+b.getBackground());
	}

}

class ColorChanger implements ActionListener{

	private Component container;

	public ColorChanger(Component c){
		this.container = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String color = e.getActionCommand();
		if(color.equals("red")){
			container.setBackground(Color.RED);
		}else if(color.equals("blue")){
			container.setBackground(Color.BLUE);
		}else{
			container.setBackground(Color.WHITE);
		}
	}
	
}

