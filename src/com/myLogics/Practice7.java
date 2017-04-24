package com.myLogics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Practice7 {

	public static void main(String[] args) {
		//checkIfStringContainsOnlyDigits();
		//checkNoOfVowelsAndConsonants("vowel");
		//permutationOfGivenString("sri");
		//reverseWordsOfGivenString("Java is Robust Language");
		reverseWordsOfGivenStringUsingCollections("Java is Robust Language");
	}

	public static void reverseWordsOfGivenStringUsingCollections(String string) {
		List<String> list = Arrays.asList(string.split("\\s"));
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder(string.length());
		for(int i = 0; i < list.size() ; i++){
			sb.append(list.get(i));
			sb.append(' ');
		}
		System.out.println("Reverse Sentence: "+ sb.toString().trim());
	}

	public static void reverseWordsOfGivenString(String string) {
		String[] words = string.split("\\s");
		StringBuilder reverse = new StringBuilder();
		for(int i = words.length - 1; i >= 0 ; i--){
			reverse = reverse.append(words[i]).append(" ");
		}
		System.out.println("Reverse Sentence: "+ reverse.toString().trim());
	}

	public static void permutationOfGivenString(String string) {
		permutation("",string);
	}

	private static void permutation(String perm, String word) {
		if(word.isEmpty()){
			System.out.println(perm+word);
		}
		for(int i = 0; i < word.length(); i++){
			permutation(perm + word.charAt(i),word.substring(0, i) + word.substring(i + 1, word.length()));
		}
	}

	public static void checkNoOfVowelsAndConsonants(String string) {
		char[] chars = string.toCharArray();
		int vowelCount = 0, consonantCount = 0;
		for(char ch : chars){
			switch(ch){
			case 'a' :
			case 'e' :
			case 'i' :
			case 'o' : 
			case 'u' :
				vowelCount++;
				break;
			default : 
				consonantCount++;
			}
		}

		System.out.printf("For given String, Vowel Count is %d & Consonant Count is %d",vowelCount,consonantCount);

	}

	public static void checkIfStringContainsOnlyDigits() {
		Pattern pattern =  Pattern.compile(".*[^0-9].*"); // Pattern.compile(".*\\D.*");
		String[] inputs = {"123", "-123" , "123.12", "abcd123"};
		for(String input : inputs){
			System.out.println("does " + input + " is number : "+ !pattern.matcher(input).matches());
		}

		String [] numbers = {"123", "1234" , "123.12", "abcd123", "123456"};
		Pattern digitPattern = Pattern.compile("\\d{6}");       
		//Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");


		for(String number: numbers){
			System.out.println( "does " + number + " is 6 digit number : "
					+ digitPattern.matcher(number).matches());
		}

	}

}
