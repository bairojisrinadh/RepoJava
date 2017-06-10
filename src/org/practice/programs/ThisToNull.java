package org.practice.programs;

public class ThisToNull {
	private String str;
	
	public void show(){
		//this = null; left side of assignment is to be a variable
		this.str = null; //valid assignment
	}
	
	public static void main(String[] args) {
		//System.out.println("hello");
		System.out.println(new ThisToNull().str);
		System.out.println((String)null);
		System.out.println((Object)null);
		System.out.println((char[])null); //NullPointerException 
	}

}
