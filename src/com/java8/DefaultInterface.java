package com.java8;

interface DefaultInterface {
	
	public abstract void show();

	default void sample(){
		
		System.out.println("This is the new feature in JAVA8, define implementation methods "
				+ "along with method declarations");
	}
	
	static void sampleStatic(){
		
		System.out.println("This is also the new feature to define method as static in interface");
	}
	
}
