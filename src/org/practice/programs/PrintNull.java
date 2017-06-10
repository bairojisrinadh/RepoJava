package org.practice.programs;

public class PrintNull {

	public static void main(String[] args) {
	  //System.out.println(null); //ambiguity : as println is overloaded method, ambiguity arises with same level of clas
								  //char[] and String
		
		System.out.println((String)null);
		System.out.println((Object)null);
		//System.out.println((char[])null); //NullPointerException
	}

}
