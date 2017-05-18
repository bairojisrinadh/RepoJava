package com.highradius;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
		//System.out.println(sq.getString());
		Map<Integer,Integer> map = new TreeMap<>();
		map.put(3, 1);
		map.put(2, 1);
		map.put(4, 1);
		map.put(5, 1);
		map.put(1, 1);
		//System.out.println(map);
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(1);
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
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