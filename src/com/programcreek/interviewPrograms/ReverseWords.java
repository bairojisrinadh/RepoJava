package com.programcreek.interviewPrograms;

public class ReverseWords {

	public static void main(String[] args) {
		String sentence = "the sky is blue";
		System.out.println("Before reversal: "+ sentence);
		char[] s = sentence.toCharArray();
		reverseWords(s);
		StringBuilder sb = new StringBuilder();
		for(char value: s){
			sb.append(value);
		}
		System.out.println("After Reversal: "+ sb.toString());
	}

	public static void reverseWords(char[] s) {
		int i = 0;
		for(int j =0; j < s.length; j++){
			if(s[j] == ' '){
				reverse(s, i, j-1);
				i = j+1;
			}
		}
		
		reverse(s,i,s.length-1);
		reverse(s,0,s.length-1);
	}

	public static void reverse(char[] s, int i, int j) {
		while(i<j){
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		
	}

}
