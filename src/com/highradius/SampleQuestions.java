package com.highradius;

public class SampleQuestions {

	public static void function(String s){
		System.out.println("String");
	}
	
	public static void function(Object o){
		System.out.println("Object");
	}
	public static int rio() {
		int i =10;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//function(null);
		System.out.println(rio());
	}

}
