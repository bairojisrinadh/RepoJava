package com.sri.completeCoreJava;

// TODO: Auto-generated Javadoc
/**
 * The Class CanCreatemethodNamedAsMain.
 */
/*
 * we can create a method with same name as 'main' with no argms / some argms. compiler won't complain
 * on this signature, it complies fine. but it is not considered as java application to run.
 */
public class CanCreatemethodNamedAsMain {

	/** The message. */
	public static String message = "Static Message";
	
	/**
	 * Main.
	 *
	 * @param s the s
	 */
	//below is just a method with name 'main', not an main method signature to be executed by JVM as Java application. 
	public static void main(int... s){
		System.out.println(message);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	static public void main(String... args){
		main(new int[12]);
	}
}
