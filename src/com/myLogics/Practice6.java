package com.myLogics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.junit.Assert.*;
import org.junit.Test;

public class Practice6 {
	
	public static void main(String... args){
		printFirstNonRepeatedCharacterOfString("MirMeng");
		printFirstNonRepeatedCharacterOfStringUsingSetAndList("MirMeng");
		printFirstNonRepeatedCharacterOfStringUsingHaspMap("MirMeng");
	}

	public static char printFirstNonRepeatedCharacterOfStringUsingHaspMap(
			String string) {
		Map<Character,Integer> hashMap = new HashMap<>();
		for(int i = 0; i < string.length(); i++){
			char ch = string.charAt(i);
			hashMap.put(ch, hashMap.containsKey(ch) ? hashMap.get(ch) + 1 : 1 );
		}
		for(char ch : string.toCharArray()){
			if(hashMap.get(ch) == 1){
				System.out.println("First Non Repeated Character: "+ ch);
				return ch;
			}
		}
		throw new RuntimeException("Didn't find any non repeated Caracter");
	}

	public static char printFirstNonRepeatedCharacterOfStringUsingSetAndList(
			String string) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();
		
		for(int i = 0 ; i < string.length() ; i++){
			char letter = string.charAt(i);
			if(repeating.contains(letter)){
				continue;
			}
			if(nonRepeating.contains(letter)){
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			}else{
				nonRepeating.add(letter);
			}
		}
		char firstNonRepeatingCharacter = nonRepeating.get(0);
		System.out.println("First Non Repeated Character: "+firstNonRepeatingCharacter);
		return firstNonRepeatingCharacter;
	}

	public static char printFirstNonRepeatedCharacterOfString(String string) {
		Map<Character,Integer> linkedHashMap = new LinkedHashMap<>(string.length());
		for(char ch : string.toCharArray()){
			linkedHashMap.put(ch, linkedHashMap.containsKey(ch) ? linkedHashMap.get(ch)+1 : 1);
		}
		
		for(Entry<Character,Integer> entry : linkedHashMap.entrySet()){
			if(entry.getValue() == 1){
				System.out.println("First Non Repeated Character: "+entry.getKey());
				return entry.getKey();
			}
		}
		throw new RuntimeException("Didn't find any non repeated Caracter");
	}

}