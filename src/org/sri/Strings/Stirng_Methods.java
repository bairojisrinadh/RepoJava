package org.sri.Strings;

public class Stirng_Methods {

	public static void main(String[] args) {
		
		String literal_1 = "Hey! There";
		String literal_2 = "Hi";
		String literal_3 = literal_1;
		
		System.out.println(literal_1.charAt(2)); // returns charAt index '2' i.e., y
		System.out.println(literal_2.codePointAt(0));// returns unicode value at index '0' i.e., H <=> 72
		System.out.println(literal_1.codePointBefore(2));// returns unicode value of before character at index '2' i.e., e <=> 101
		System.out.println(literal_2.codePointCount(0,2));// returns no. of unicode characters in given range of indexes i.e., 2
		System.out.println(literal_1.compareTo(literal_2)); // return -ve value, if first string is larger than 2nd string, +ve if 1st is smaller than 2nd, 0 if both are same
		System.out.println(literal_2.compareToIgnoreCase(literal_1));// return -ve value, if first string is larger than 2nd string, +ve if 1st is smaller than 2nd, 0 if both are same
		System.out.println(literal_1.concat(literal_2)); // Concatenates/Combines to strings 1st with 2nd i.e., Hey! ThereHi
		System.out.println(literal_1.contains(literal_3));// returns true, if string 2nd contains in string 1st, else returns false, if string 2nd does not contains in string 1st
		//overloaded methods, contentEquals(CharSequence) & contentEquals(StringBuilder)
		System.out.println(literal_1.contentEquals(literal_2));// returns true, if string 2nd content (all characters of string) equals with string 1st (both should have same length)
															   //, else returns false,if string 2nd content (all characters of string) not equals with string 1st (both should not have same length)
		System.out.println(literal_2.contentEquals(literal_1));// returns true, if string 2nd content (all characters of string) equals with string 1st (both should have same length)
		   													   //, else returns false,if string 2nd content (all characters of string) not equals with string 1st (both should not have same length)
		System.out.println(literal_1.endsWith("re"));// returns true, if string endsWith given string
	}

}
