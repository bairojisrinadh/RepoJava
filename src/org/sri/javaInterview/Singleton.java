package org.sri.javaInterview;

public class Singleton {

	private static Singleton instance;
	
	static{
		instance= new Singleton();
	}
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return instance;
	}
	
	public void test(){
		System.out.println("This is to test singleton object without using new keyword for "
				+ "Object creation");
	}

	public static void main(String [] args){
		
		Singleton s = getInstance();
		s.test();
		
	}
}
