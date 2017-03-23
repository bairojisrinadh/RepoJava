package org.sri.javaInterview;

import java.util.Scanner;

public class fibonacci {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int f1=0;
		int f2=1;
		int f;
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("Enter No.");
		
		for (int i=1;i<=num;i++){
			
			f=f1+f2;
			System.out.println(f);
			f1=f2;
			f2=f;
			
			
			
			
		}
		

	}

}
