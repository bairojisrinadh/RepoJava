package com.programcreek.interviewPrograms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestInArray {

	public static void main(String[] args) {
		int[] arr = {2,3,1,6,4,9,10};
		int k = 2;
		findKthLargestWithMinHeap(arr,k);
		int Largest = findKthLargest(arr,k);
		System.out.printf("%d th largest element in the array: %d",k,Largest);
	}

	public static void findKthLargestWithMinHeap(int[] arr, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>(k);
		for(int i : arr){
			q.offer(i);
			if(q.size() > k){
				q.poll();
			}
		}
		System.out.printf("%d th largest element in the array: %d",k,q.peek());
	}

	public static int findKthLargest(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[arr.length-k];
	}

}
