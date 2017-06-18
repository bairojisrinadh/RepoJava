package org.sri.javaInterview;

public class LargestSubStringOfPalindrome {

	public static void main(String[] args) {
		String input = "formoomder";
		StringBuilder palindrome = new StringBuilder();
		for(int i = input.length(); i > 0; i--){
			palindrome.append(input.charAt(i-1));
		}

		if(input.equals(palindrome.toString())){
			System.out.println("True");
		}
		
		longestPalindrome(palindrome.toString());
	}

	private static void longestPalindrome(String s) {
		String longest = s.substring(0,1);
		for(int i = 0; i < s.length() -1 ; i++){
			String palidrome = intermediatePalindrome(s, i , i);
			if(palidrome.length() > longest.length()){
				longest = palidrome;
			}
			palidrome = intermediatePalindrome(s, i, i + 1);
			if (palidrome.length() > longest.length()) {
				longest = palidrome;
			}
		}
		System.out.println(longest);
		
	}

	private static String intermediatePalindrome(String s, int left, int right) {
		if(left > right) return null;
		while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}

}
