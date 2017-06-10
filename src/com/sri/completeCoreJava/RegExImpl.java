package com.sri.completeCoreJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExImpl {	

	public static void stringMatcher(){
		Pattern expression = Pattern.compile("aba");
		Matcher source = expression.matcher("acababajabas");
		while(source.find()){
			System.out.print(source.start()+ " ");
		}
	}
	
	private static void metaCharacters(String metaChar) {
		String input = "a1 efe4 5 fr4";
		Pattern expression = Pattern.compile(metaChar);
		Matcher source = expression.matcher(input);
		while(source.find()){
			System.out.print(source.start()+ " ");
		}
	}
	
	private static void squareBracketdSearches(String metaChar) {
		String input = "a1 efeA 5 fr4";
		Pattern expression = Pattern.compile(metaChar);
		Matcher source = expression.matcher(input);
		while(source.find()){
			System.out.print(source.start()+ " ");
		}
	}
	
	public static void main(String[] args) {
		//stringMatcher();
		//metaCharacters("e.e"); // "\\d" to find numeric characters; "\\s" to find white spaces; "\\w" to find : A word character (letters, digits, or "_" (underscore)), excludes white spaces
		//‘.’  : any character, including white space
		squareBracketdSearches("[e*]");
	}

	
}
