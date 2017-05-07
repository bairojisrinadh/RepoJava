package com.highradius;

public class SampleQuestions {
	
	/*
	 * ADP Interview Question
	 * 
	 * By making instance members of class as private and only initializing values to instance
	 * variables at the time of object creation and only having getter methods for the members
	 * will results in immutable class.
	 * 
	 */
	private String s = null; 
		
	
	public SampleQuestions(){};
	
	public SampleQuestions(String string){
		this.s = string;
	}
	
	public String getString(){
		return s;
	}
	public static void function(String s){
		System.out.println("String");
	}
	
	public static void function(Object o){
		System.out.println("Object");
	}
	public static int rio() {
		int i =0;
		try{
			int j = i/5;
			return j;
		}catch(ArithmeticException ae){
			ae.printStackTrace();
			return i;
		}finally{
			System.out.println("In finally");
		}
	}

	public static char convertCharactertochar(Character c){
		char chars = c.charValue();
		//System.out.println(chars);
		return chars;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//function(null);
		//System.out.println(rio());
		//convertCharactertochar(new Character('C'));
		SampleQuestions sq = new SampleQuestions("Srinadh"); //This is to make class immutable
		System.out.println(sq.getString());
	}


}



/*
 * Subclass main() method will only execute when the class access modifier is public
 * to execute subclass main(), then copy paste the below code into respective subclass java
 * file. as its an bug with eclipse 
 * 
 */

/*class subclass extends SampleQuestions{
	
	public String s = null;
	public subclass(String string){
		this.s = string;
	}
	public static void main(String... args){
		SampleQuestions sq = new subclass("Biroji");
		sq.getString();
	}
}*/