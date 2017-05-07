package com.myLogics;

public class Practice1 {

	public static void main(String... args){
		int[] arr = {9,4,1,3,7,5,4,6};
		//isEvenOrOdd(11);
		//isPrime(91);
		//printPrimeNumbersTill(100);
		//checkIfNumIsPalindrome(555);
		//reverseAString("srinadh");
		//System.out.println(reverseAStringUsingRecursion("Srinadh"));
		//sortingUsingBubbleSort(arr);
		checkIfNumIsArmstrong(371);
	}

	public static void checkIfNumIsArmstrong(int num) {
		int armstrong = 0;
		int givenNumber = num;
		int noOfDigits = String.valueOf(num).length();
		int sum = 0;
		while(num > 0){
			armstrong = num%10;
			int temp = 1;
				for(int i = 0; i< noOfDigits;i++){
					temp *= armstrong;
				}
				sum += temp;
				num = num/10;
				System.out.println(sum);
		}
		if(sum == givenNumber){
			System.out.println("Given Number is "+givenNumber+" Armstrong No.");
		}else{
			System.out.println("Given Number is "+givenNumber+" Not Armstrong No.");
		}
		
	}

	public static void sortingUsingBubbleSort(int[] array) {
		for(int i = 0; i< array.length - 1; i++){
			for(int j = 0; j<array.length - 1; j++){
				int k = j+1;
				if(array[j]> array[k]){
					int temp = array[j];
					array[j] = array[k];
					array[k] = temp;
				}
			}	
		}
		System.out.print("Sorted Array using Bubble Sort: ");
		for(int k = 0; k <array.length; k++){
			System.out.print(" "+array[k]);
		}
		
	}

	public static String reverseAStringUsingRecursion(String string) {
		if(string.length() < 2){
			return string;
		}
		return reverseAStringUsingRecursion(string.substring(1)) + string.charAt(0);
	}
	
	public static void reverseAString(String string) {
		int size = string.length();
		String reverse = "";
		for(int i = size - 1; i >= 0; i-- ){
			reverse += string.charAt(i); 
		}
		System.out.println("Reverse of given String \""+string+"\" :: "+ reverse);
	}

	public static void checkIfNumIsPalindrome(int num) {
		int reverse = 0;
		int givenValue = num;
		while(num>0){
				reverse = reverse*10;
				reverse = reverse + num%10;
				num = num/10;
		}
		if(reverse == givenValue){
			System.out.println("Provided Number "+givenValue+" is Palindrome");
		}else{
			System.out.println("Provided Number "+givenValue+" is Not Palindrome");
		}

	}

	public static void printPrimeNumbersTill(int num) {
		int count;
		int noOfPrimes = 0;
		System.out.print("Prime Numbers Till "+num+" are: ");
		for(int i = 2; i<=num; i++){
			count = 0;
			for(int j = 2; j<= i/2; j++){ //Here in 'j' for loop condition, we can even use this below conditions
				if(i%j == 0){			  // "(int)Math.sqrt(i)" or "i/2" - Ex: If i = 9; (int)Math.sqrt(i) = 3; 
					count++;              // i/2 = 4; Thus iterations are less in 1st condition, iterations are
				}						  // are more in second condition
			}
			if(count == 0){
				noOfPrimes++;
				System.out.print(i+" ");
			}
		}
		System.out.print("\n" +"Total No. of Primes till "+num+" are: "+noOfPrimes);
	}

	public static void isPrime(int num) {
		int count = 0;
		for(int i = 2; i <= (int) Math.sqrt(num);i++){
			if(num%i == 0){
				count++;
			}
		}
		if(count == 0){
			System.out.println("Provided Number "+num+" is Prime");
		}else{
			System.out.println("Provided Number "+num+" is Not Prime");
		}
	}

	public static void isEvenOrOdd(int num) {
		if(num%2 == 0){
			System.out.println("Provided Number, "+num+" is Even" );
		}else{
			System.out.println("Provided Number, "+num+" is Odd" );
		}
	}
}
