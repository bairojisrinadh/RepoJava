package com.programcreek.interviewPrograms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WildCardMatching {
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "?ab";
		boolean result = isMatch(s,p);
		usingRegex(s,p);
		System.out.printf("WildCard matching is done, Both Strings %s & %s matches: %b",s,p,result);
	}

	//This regex does not work don't use it.
	public static void usingRegex(String s, String p) {
		Pattern pattern = Pattern.compile("["+p+"]");
		Matcher matcher = pattern.matcher(s);
		System.out.printf("WildCard matching is done usingRegex(), Both Strings %s & %s matches: %b \n",s,p,matcher.matches());
	}

	public static boolean isMatch(String s, String p) {
		int i = 0,j = 0;
		int starIndex = -1;
		int iIndex = -1;
		
		while(i<s.length()){
			if(j<p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
				++i;
				++j;
			}else if(j<p.length()&& p.charAt(j)=='*'){
				starIndex = j;
				iIndex = i;
				j++;
			}else if(starIndex != -1){
				j = starIndex + 1;
				i = iIndex+1;
				iIndex++;
			}else{
				return false;
			}
		}
		
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}

}
