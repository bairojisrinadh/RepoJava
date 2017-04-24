package com.myLogics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice5 {

	public static void main(String[] args) {
		//printDuplicateCharactersOfString("bairojisrinadh");
		//checkIfStringAreAnagrams("Mary","Army");
		//checkIfStringAreAnagramsUsingArraysClass("Mary","Army");
		//checkIfStringAreAnagramsUsingStringBuilder("AAAA","AAAA");
		//checkIfStringAreAnagramsUsingSubString("Mary","Army");
	}

	public static boolean checkIfStringAreAnagramsUsingSubString(String word,
			String anagram) {
		String string1 = word.toLowerCase();
		String string2 = anagram.toLowerCase();

		if(string1.length() != string2.length()){
			return false;
		}

		char[] chars = string1.toCharArray();
		for(char ch : chars){
			int index = string2.indexOf(ch);
			if(index != -1){
				string2 = string2.substring(0, index) + string2.substring(index+1, string2.length());
			}else{
				return false;
			}
		}
		boolean result = string2.isEmpty(); 
		if(result){
			System.out.println("Provided Strings are Anagrams: "+word+", "+anagram);
		}else{
			System.out.println("Provided Strings are not Anagrams: "+word+", "+anagram);
		}
		return result;

	}

	public static boolean checkIfStringAreAnagramsUsingStringBuilder(
			String word, String anagram) {
		String string1 = word.toLowerCase();
		String string2 = anagram.toLowerCase();
		char[] chars = string1.toCharArray();
		StringBuilder sb = new StringBuilder(string2);

		for(char ch : chars){
			int index = sb.indexOf(""+ch);
			if(index != -1){
				sb.deleteCharAt(index);
			}else{
				return false;
			}
		}

		boolean result = (sb.length() == 0 ? true : false); 
		if(result){
			System.out.println("Provided Strings are Anagrams: "+word+", "+anagram);
		}else{
			System.out.println("Provided Strings are not Anagrams: "+word+", "+anagram);
		}
		return result;
	}

	public static boolean checkIfStringAreAnagramsUsingArraysClass(String string1,
			String string2) {

		char[] word = string1.toLowerCase().toCharArray();
		char[] anagram = string2.toLowerCase().toCharArray();

		Arrays.sort(word);
		Arrays.sort(anagram);

		boolean result = Arrays.equals(word, anagram);
		if(result){
			System.out.println("Provided Strings are Anagrams: "+string1+", "+string2);
		}else{
			System.out.println("Provided Strings are not Anagrams: "+string1+", "+string2);
		}
		return result;

	}

	public static boolean checkIfStringAreAnagrams(String str1, String str2) {
		String string1 = str1.toLowerCase();
		String string2 = str2.toLowerCase();
		Map<Character,Integer> map1 = new HashMap<>();
		for(int i = 0; i < string1.length(); i++){
			char key1 = string1.charAt(i);
			if(map1.containsKey(key1)){
				map1.put(key1, map1.get(key1)+1);
			}else{
				map1.put(key1, 1);
			}
		}

		int count=0;
		for(int i = 0; i < string2.length(); i++){
			char key2 = string2.charAt(i);
			if(map1.containsKey(key2)){
				count++;
			}else{
				break;
			}
		}

		if(count == string1.length()){
			System.out.println("Provided Strings are Anagrams: "+string1+", "+string2);
			return true;
		}else{
			System.out.println("Provided Strings are not Anagrams: "+string1+", "+string2);
			return false;
		}
	}

	public static void printDuplicateCharactersOfString(String string) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0; i < string.length(); i++){
			char key = string.charAt(i);
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}

		System.out.println("Duplicate Characters in Given String: ");
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue() > 1){
				System.out.print(entry.getKey()+" --> "+entry.getValue()+"  ");
			}
		}
	}

}
