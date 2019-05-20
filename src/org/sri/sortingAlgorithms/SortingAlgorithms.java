package org.sri.sortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int arr[] = { 6, 5, 4, 3 };
		// bubbleSort(arr);
		// selectionSort(arr);
		// insertionSort(arr);
		// insertionSort_1(arr);
		quickSort(arr);
		printArray(arr);
	}

	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int l, int h) {
		if (l < h) {
			int j = partitioning(arr, l, h);
			quickSort(arr, l, j);
			quickSort(arr, j + 1, h);
		}
	}

	private static int partitioning(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l, j = h;
		while (i < j) {
			do {
				i++;
			} while (i <= h && arr[i] <= pivot);
			while (pivot < arr[j]) {
				j--;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, l, j);
		return j;
	}

	private static void insertionSort_1(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int index = i;
			while (index > 0 && arr[index] < arr[index - 1]) {
				swap(arr, index, index - 1);
				index--;
			}
		}
	}

	private static void insertionSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int value = arr[i];
			int hole = i;
			while (hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
		}
	}

	private static void selectionSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			swap(arr, i, minIndex);
		}
	}

	private static void bubbleSort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {
			int flag = 0;
			for (int j = 0; j < length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flag = 1;
				}
			}
			if (flag == 0)
				break;
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
