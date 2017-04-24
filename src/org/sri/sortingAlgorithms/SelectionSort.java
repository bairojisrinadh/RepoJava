package org.sri.sortingAlgorithms;

public class SelectionSort {

	static int a[] = {1,6,1,5,6,3,3,7,4};
	
	public static void main(String... args){
		selectionSort(a);
	}

	public static void selectionSort(int[] a) {
		int len = a.length;
		for(int i = 0;i < len - 1;i++){
			int min = i;
			for(int j = i + 1; j < len; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			swap(i,min);
		}
		System.out.print("Sorted Array: ");
		for(int k=0; k < len; k++){
			System.out.print(a[k]+ " ");
		}
	}

	public static void swap(int i, int min) {
		int temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	}
}
