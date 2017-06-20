package com.programcreek.interviewPrograms;

public class ReverseWordsMyLogic {

	
	public static void main(String[] args) {
		String given = "the Sky is Blue";
		String[] spliter = given.split(" ");
		int size = spliter.length;
		StringBuilder sb1 = new StringBuilder(size);
		for(int i = size-1; i >= 0; i--){
			sb1.append(spliter[i] + " ");
		} 
		StringBuilder sb = sb1;
		System.out.println("Words of Sentence reversed: "+sb.toString());
	}

}
