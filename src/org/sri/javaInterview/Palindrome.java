/*Here in Palindrome class, we have overloaded methods 
 * 1.isPalindrome(String argument) - passing string as an argument
 * 2.isPalindrome(int argument) - passing int datatype as an argument
 * 
 * isPalindrome method is overloaded because it has same method signature, but 
 * difference in argument/parameter datatype
 * 
 * 
 * */

package org.sri.javaInterview;


public class Palindrome {

	public static void main(String[] args) {
		String name = "Moon";
		int number = 536;
		Palindrome pos = new Palindrome();
		System.out.println("Is "+name+",a Palindrome String? :"+pos.isPalindrome(name));
		System.out.println("Is "+number+",a Palindrome Number? :"+pos.isPalindrome(number));

	}

	public boolean isPalindrome(String name) {
		String Palindrome = "";
		for(int i=name.length()-1;i>=0;i--){
			Palindrome += name.charAt(i);
		}
		if(Palindrome.equalsIgnoreCase(name)){
			return true;
		}
		return false;	
	}
	
	public boolean isPalindrome(int num){
		int number =num;
		int reverse=0;
		while (num>0){
			reverse = reverse*10 + num%10;
			num /= 10;
		}
		if(reverse==number){
			return true;
		}
		return false;
	}
	
}
