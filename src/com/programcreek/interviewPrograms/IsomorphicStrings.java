package com.programcreek.interviewPrograms;

import java.util.HashMap;
import java.util.Map;

/**
 *Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
  For example,"egg" and "add" are isomorphic, "foo" and "bar" are not. 
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		if(checkIsomorphic(s,t)){
			System.out.printf("Strings %s & %s are Isomorphic",s,t);
		}else{
			System.out.printf("Strings %s & %s are not Isomorphic",s,t);	
		}
	}

	public static boolean checkIsomorphic(String s, String t) {
		if(s == null || t == null){
			return false;
		}
		if(s.length() != t.length()){
			return false;
		}

		Map<Character,Character> hashMap = new HashMap<>();

		for(int i = 0; i < s.length() ; i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if(hashMap.containsKey(c1)){
				if(hashMap.get(c1) != c2)
					return false;
			}else{
				if(hashMap.containsValue(c2))
					return false;
				hashMap.put(c1, c2);
			}
		}
		return true;
	}

}
