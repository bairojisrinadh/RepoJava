package com.programcreek.interviewPrograms;

//Rotate an array of n elements to the right by k steps.

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int[] arr1 = {1,2,3,4,5,6,7};
		int[] arr2 = {1,2,3,4,5,6,7};
		int k = 3;
		rotateArrayUsingarraycopy(arr, k);
		rotateUsingBubbleSort(arr1,k);
		rotateUsingReversal(arr2,k);

	}

	public static void rotateUsingReversal(int[] arr, int order) {
		System.out.println("\n---rotateUsingReversal---");
		if(arr == null || arr.length == 0 || order < 0){
			throw new IllegalAccessError("Illegal Argument!");
		}

		if(order > arr.length){
			order = order % arr.length;
		}

		int a = arr.length - order;

		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
		
		System.out.printf("%s ","After Rotation of Array of N elements by K steps to right:");
		for(int i : arr){
			System.out.print(i+ " ");
		}
		
	}

	public static void reverse(int[] arr, int left, int right) {

		if(arr == null || arr.length == 1) 
			return;

		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	

	}

	public static void rotateUsingBubbleSort(int[] arr, int k) {
		System.out.println("\n---rotoateUsingBubbleSort---");
		if(arr == null || k < 0){
			throw new IllegalArgumentException("Illegal Argument!");
		}

		for(int i = 0; i < k; i++){
			for(int j = arr.length - 1; j > 0; j--){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
		System.out.printf("%s ","After Rotation of Array of N elements by K steps to right:");
		for(int i : arr){
			System.out.print(i+ " ");
		}
	}

	public static void rotateArrayUsingarraycopy(int[] arr, int k) {
		System.out.println("---rotateArrayUsingarraycopy---");
		if(k > arr.length){
			k = k % arr.length;
		}

		int[] result = new int[arr.length];

		for(int i = 0; i<k ; i++){
			result[i] = arr[arr.length-k+i];
		}
		int j = 0;
		for(int i=k; i<arr.length;i++){
			result[i] = arr[j];
			j++;
		}
		System.arraycopy(result, 0, arr, 0, arr.length);
		System.out.printf("%s ","After Rotation of Array of N elements by K steps to right:");
		for(int i : arr){
			System.out.print(i+ " ");
		}
	}

}
