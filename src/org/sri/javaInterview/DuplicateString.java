package org.sri.javaInterview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateString {

	public static void main(String[] args) {
		String[] input = {"car","bar","car","lar","har","lar"};
		Map<String,Integer> map = new LinkedHashMap<>();
		
		for(String element : input){
			if(map.containsKey(element)){
				continue;
			}else{
				map.put(element, 1);
			}
		}
		
		int i = 0;
		for(String value : map.keySet()){
			input[i]= value;
			System.out.println(value);
			i++;
		}
	}

}
