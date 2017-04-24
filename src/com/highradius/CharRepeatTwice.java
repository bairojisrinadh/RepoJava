package com.highradius;

import java.util.HashMap;
import java.util.Map;

public class CharRepeatTwice {

	public static void main(String[] args) {

		String str = "ABCADEC";
		usingArrays(str);
		usingMap(str);
	}

	public static void usingMap(String str) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++){
			char x = str.charAt(i);
			if(map.containsKey(x)){
				int count = map.get(x);
				count++;
				map.put(x, count);
			}else{
				map.put(x, 1);
			}
		}
		for(char key: map.keySet()){
			if(map.get(key)>1)
				System.out.println("The letter "+key+" appeared "+map.get(key)+" times");
		}
		
		//else we can also traverse the map elements using EntrySet 
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue()>1){
				System.out.println("The letter "+entry.getKey()+" appeared "+entry.getValue()+" times");
			}
		}
		
	}

	public  static void usingArrays(String str) {
		int size = str.length();
		char[] arr = str.toCharArray();
		for(int i = 0 ; i < size ; i++){
			int count = 0;
			for(int j = i + 1; j < size; j++){
				if(arr[i] == arr[j]){
					count++;
					if(count == 1){
						System.out.println("Character "+arr[i]+" has appeared "+(count + 1)+" times");
					}
				}
			}
		}
		
	}
	
	

}
