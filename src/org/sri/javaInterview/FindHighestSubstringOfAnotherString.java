package org.sri.javaInterview;

//Not Implemented completely -- unable to find the logic
public class FindHighestSubstringOfAnotherString {

	public static void main(String[] args) {
		String s = "sbscuhsasxbanc";
		String t = "abc";
		findHightestSubStringOfScontainsT(s,t);
	}

	public static void findHightestSubStringOfScontainsT(String s, String t) {
		StringBuilder sb = new StringBuilder();
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		String longest = "";
		for(int i = 0; i < sChar.length; i++){
			for(int j = 0; j < tChar.length; j++){
				if(sChar[i] == tChar[j]){
					sb.append(sChar[i]);
				}
			}
		}
		
	}

}
