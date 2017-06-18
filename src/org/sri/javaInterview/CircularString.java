package org.sri.javaInterview;

import java.util.Scanner;

public class CircularString {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter String: ");
			String input = sc.nextLine();
			circularFunc(input);
		}

	}

	private static void circularFunc(String input) {
		for(int i = 0; i < input.length(); i++){
			System.out.println(input.substring(i,input.length())+input.substring(0, i));
		}
		
	}

}
