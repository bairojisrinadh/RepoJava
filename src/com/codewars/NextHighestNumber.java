package com.codewars;

import java.util.Arrays;

/*
You have to create a function that takes a positive integer number and returns the next bigger number formed by the same digits:

12 ==> 21
513 ==> 531
2017 ==> 2071

If no bigger number can be composed using those digits, return -1:

9 ==> -1
111 ==> -1
531 ==> -1
*/

public class NextHighestNumber {

	public static long nextBiggerNumber(long n) {
		long result = 0;
		if (n < 10)
			return -1;
		else if (n == (result = highestNumber(n)))
			return -1;
		else
			return result;
	}

	private static long highestNumber(long n) {
		long result = 0;
		char[] arr = String.valueOf(n).toCharArray();
		sortSingleDigit(arr);
		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			int digit = Integer.parseInt("" + arr[i]);
			result += digit * Math.pow(10, j);
		}
		return result;
	}

	private static void sortSingleDigit(char[] arr) {
		if(arr.length < 2) return;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] > arr[i - 1]) {
				swap(arr, i, i - 1);
				return;
			}
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static long reverse(long n) {
		long reverse = 0;
		int i = 0;
		while (n != 0) {
			long last = n % 10;
			reverse += last * Math.pow(10, i++);
			n /= 10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(nextBiggerNumber(12));
		System.out.println(nextBiggerNumber(513));
		System.out.println(nextBiggerNumber(2017));
		System.out.println(nextBiggerNumber(9));
		System.out.println(nextBiggerNumber(111));
		System.out.println(nextBiggerNumber(531));
		System.out.println(nextBiggerNumber(2017));
		System.out.println(nextBiggerNumber(414));
		System.out.println(nextBiggerNumber(144));
	}
}
