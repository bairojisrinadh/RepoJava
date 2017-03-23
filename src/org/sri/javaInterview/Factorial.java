package org.sri.javaInterview;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int fact = 1;
		if(num < 0){
			System.out.println("Enter positive Number");
		    num = sc.nextInt();
		}else{
		for(int i=1;i<=num;i++){
		fact *=i;
		}
		System.out.println("Using for loop, factorial of "+num+" :" +fact);
		
		
		System.out.println("Using Recursion, factorial of "+num+" :" +fact(num));
		}
	}
	
	static int fact(int number){
		int fact;
	
		if (number == 0){
			return 1;
		}else{
			fact= number * fact(number-1);
			return fact;
		}
	}
	


}
