package org.practice.programs;

public class TopTwoMaxOfArray {

	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4};
		findTopTwoMaxNumbers(arr);

	}

	public static void findTopTwoMaxNumbers(int[] arr) {
		int max1 = 0, max2 = 0;
		for(int i = 0; i < arr.length; i ++){
			if(arr[i] > max1){
				max2 = max1;
				max1 = arr[i];
			}else if(arr[i]>max2){
				max2 = arr[i];
			}
		}
		System.out.println("Max1: "+max1+", Max2: "+max2);
	}
}
