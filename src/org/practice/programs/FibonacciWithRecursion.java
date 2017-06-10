package org.practice.programs;

public class FibonacciWithRecursion {

	public static void main(String[] args) {
		int i = 0, j = 1;
		findFibonacci(i,j);
	}

	public static void findFibonacci(int i, int j) {
		int sum = 0;
		if(i == 0){
			System.out.print(i+ " " + j+" ");
		}
		sum = i + j;
		if(sum <= 100){
			System.out.print(sum+ " ");
			i = j;
			j = sum;
			findFibonacci(i,j);
		}		
	}


}
