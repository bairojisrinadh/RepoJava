package org.sri.javaInterview;

public class AddTwoNumbersWithoutAddOperator {

	public static void main(String[] args) {
		int sum = add(4,7);
		System.out.println("Sum: "+sum);
	}

	public static int add(int a, int b) {
		if(b == 0) return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum,carry);
	}

}
