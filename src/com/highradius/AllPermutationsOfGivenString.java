package com.highradius;

public class AllPermutationsOfGivenString {
	
	public static void main(String... args){
		permutationOfString("JSP");
	}

	public static void permutationOfString(String input) {
		permutationOfString("",input);
	}

	public static void permutationOfString(String permutation, String input) {
		if(input.length() == 0){
			System.out.println(permutation);
		}else{
			for(int i=0; i < input.length(); i++){
			permutationOfString(permutation+input.charAt(i),input.substring(0,i)+input.substring(i+1, input.length()));
			}
		}
	}

}
