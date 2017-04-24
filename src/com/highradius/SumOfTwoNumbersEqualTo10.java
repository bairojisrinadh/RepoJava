package com.highradius;

public class SumOfTwoNumbersEqualTo10 {

	public static void main(String... args){
		int[] numbers = {1,9,9,8,5,4,3,7,2,2,5};
		int size = numbers.length;
		int[] newArray = new int[20];
		for(int i = 0 ; i < size; i++){
			for(int j = i + 1; j < size; j++){
				if((numbers[i] == numbers[j]) && (numbers[i] + numbers[j]) != 10){
					numbers[j] = numbers[size -1];
					size--;
					j--;
				}
			}
		}
		System.out.print("Array without duplicates elements: ");
		for(int k = 0 ; k < size; k++ ){
			System.out.print(numbers[k]+ " ");
			newArray[k] = numbers[k];
		}

		int newSize = newArray.length;
		System.out.println();
		System.out.print("Pair of integers whose sum is 10: ");
		for(int i = 0 ; i < newSize ; i++){
			for(int j = i + 1; j < newSize; j++){
				if((newArray[i] + newArray[j]) == 10){
					System.out.print("("+newArray[i]+","+newArray[j]+")");
				}
			}

		}
	}	
}