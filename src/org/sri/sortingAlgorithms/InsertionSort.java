package org.sri.sortingAlgorithms;

public class InsertionSort {

	static int[] a = {4,1,1,3,8,2,6,9};
	
	public static void main(String[] args) {
		insertionSort(a);

	}

	public static void insertionSort(int[] a) {
		int len = a.length;
		for(int i = 1; i < len; i++){
			int j = i;
			while(j > 0 && a[j-1]>a[j]){
				swap(j,j-1);
				j = j-1;
			}
		}
		
		System.out.print("Sorted Array: ");
		for(int k = 0; k < len; k++){
			System.out.print(a[k]+" ");
		}
	}

	public static void swap(int j, int i) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;	
	}

}
