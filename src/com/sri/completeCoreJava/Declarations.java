package com.sri.completeCoreJava;

/* Declaring instance, static, local and reference variables.
 * say int i; -- termed as declared a variable of type int but not initialized
 * i = 10; -- now the variable which is declared has been initialized now.
 * 
 * variables that represent fields in the class are automatically initialized to their
 * corresponding 'zero' value during object instantiation.
 * 
 * Local variables must be specifically initialized.
 * 
 * Note: ** In java, a variable can be used only when it has been initialized.
 * 
 * Identifiers:
 * 
 * The name of a variable is referred to as its identifier . (The names of your fields, classes,
   methods, interfaces, and enum are also identifiers.)
 * 
 * rules for legal identifiers:
 *1.  An identifier is a UniCode character sequence of Java letters and Java digits. These
	  include the ASCII characters A – Z and a – z , the digits 0 – 9 , the underscore character ( ),
	  and the dollar sign ( $ ).
  2.  The first character of an identifier must be a Java letter, underscore, or dollar sign. (In
	  other words, the first character cannot be a digit.)
  3.  An identifier must not be a Java keyword, true, false, or null.
 */

public class Declarations {

	static int i;
	String string;
	double value;

	public static void main(String... args){
		/*Declarations obj = new Declarations();
		System.out.println(i + " " + obj.string +" " + obj.value);*/
		
		/* Local Variable example listed in below class.*/
		LocalVariable m = new LocalVariable();
		m.clickCount = 4;
		System.out.println(m.wheelClick());
		m.leftClick(1);
		System.out.println(m.clickCount);
	}
}

class LocalVariable{
	public boolean hasWheel;
	int clickCount;

	public int rightClick(double d){
		int response = (int) d;
		return response;
	}

	public String wheelClick(){
		if(hasWheel){
			double pi = 3.143552;
			String greeting = "The mouse ate the "+ pi;
			return greeting;
		}else{
			String error = "No Wheel found";
			return error;
		}
	}
	
	public void leftClick(int clickCount){
		System.out.println("Left Click "+clickCount+" times.");
		this.clickCount = clickCount;
	}
}