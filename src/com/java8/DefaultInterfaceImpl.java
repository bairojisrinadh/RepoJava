package com.java8;

public class DefaultInterfaceImpl implements DefaultInterface {

	public void show(){
		System.out.println("This is implementation of show() method of DefaultInterface Interface");
	}
	
	public static void main(String[] args) {
	DefaultInterface.sampleStatic();
	DefaultInterface impl = new DefaultInterfaceImpl();
	impl.sample();
	impl.show();

	}

}
