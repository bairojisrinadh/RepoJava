package com.mydataStructures;

public class stackImpl {

	public static void main(String... args){
		IntStack intStack = new IntStack();
		intStack.push(6);
		intStack.push(78);
		intStack.push(23);
		intStack.push(1);
		intStack.push(2);
		
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
	}
}
