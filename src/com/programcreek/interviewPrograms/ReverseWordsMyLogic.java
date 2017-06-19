package com.programcreek.interviewPrograms;

public class ReverseWordsMyLogic {

	public static void main(String[] args) {
		String given = "the Sky is Blue"; 
		String[] spliter = given.split(" ");
		int size = spliter.length;
		StringBuilder sb = new StringBuilder(size);
		for(int i = size-1; i >= 0; i--){
			sb.append(spliter[i] + " ");
		}
		System.out.println("Words of Sentence reversed: "+sb.toString());
	}

}
