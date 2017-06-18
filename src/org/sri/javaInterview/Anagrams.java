package org.sri.javaInterview;

import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams obj = new Anagrams();
		obj.input();

	}

	public void input() {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter String: ");
			String input = sc.nextLine();
			display("",input);
		}
		
	}

	public void display(String s1, String s2) {
		if(s2.length() <= 1){
			System.out.println(s1+s2);
		}else{
			for(int i = 0; i < s2.length(); i++){
				String x = s2.substring(i, i+1);
				String y = s2.substring(0, i);
				String z = s2.substring(i+1);
				display(s1+x,y+z);
				System.out.println("Hit");
			}
		}
		
	}

}
