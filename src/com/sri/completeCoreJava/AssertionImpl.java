package com.sri.completeCoreJava;

import java.util.Scanner;

public class AssertionImpl {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in);){
		System.out.println("Enter your age: ");
		int value = scanner.nextInt();
		assert value > 18 : "Invalid Age! Minors not allowed";
		System.out.println("Age is: "+value);
		}
	}

}
