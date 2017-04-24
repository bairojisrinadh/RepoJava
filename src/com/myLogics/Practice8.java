package com.myLogics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice8 {

	public static void main(String[] args) {
		//String[] array = {"Srinadh","Sri","dsfwafedsad"};
		//sortStringArrayByLength(array);
		//sortStringArrayByLengthUsingCollections(array);
		
		/* Program to remove a character from given String and print it. */
		//removeCharacterAndPrintStringUsingIterative("Srinadh",'a');
		removeCharacterAndPrintStringUsingRecursive("Srinadh",'s');
	}

	public static String removeCharacterAndPrintStringUsingRecursive(
			String string, char c) {
		int index = string.indexOf(c);
		if(index == -1){
			System.out.println(string);
			return string;
		}
		
		return removeCharacterAndPrintStringUsingRecursive(string.substring(0,index) +
				string.substring(index + 1, string.length()),c);
		
	}

	public static String removeCharacterAndPrintStringUsingIterative(
			String string, char c) {
		char[] givenStringChars = string.toCharArray();
		StringBuilder sb = new StringBuilder(string.length());
		for(char ch : givenStringChars){
			if(ch != c){
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void sortStringArrayByLengthUsingCollections(String[] array) {
		List<String> list = Arrays.asList(array);
		Collections.sort(list, (o1,o2) -> { return o1.length() > o2.length() ? 1 : -1; });
		System.out.println("In sortStringArrayByLengthUsingCollections Method()");
		for(String str : list){
			System.out.print(str+ " ");
		}
	}

	public static void sortStringArrayByLength(String... array) {
		for(int i = 0; i <array.length - 1; i++){
			for(int j = 0; j < array.length - 1 ; j++){
				int k = j + 1;
				if(array[j].length() > array[k].length()){
					String temp = array[k];
					array[k] = array[j];
					array[j] = temp; 
				}
			}
		}
		System.out.println("In sortStringArrayByLength Method()");
		for(String str : array){
			System.out.print(str +" ");
		}
	}

}
