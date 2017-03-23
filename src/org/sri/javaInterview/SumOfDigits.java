package org.sri.javaInterview;

public class SumOfDigits {
	int sum = 0;

	public static void main(String[] args) {
		int x = 12345;
		SumOfDigits sod = new SumOfDigits();
		System.out.println(sod.sumOfNumber(x));
	}
	public int sumOfNumber(int x){
		
		if(x !=0){
		sum += x%10;
		x=x/10;
		sumOfNumber(x);
		}
		return sum;
	}

}
