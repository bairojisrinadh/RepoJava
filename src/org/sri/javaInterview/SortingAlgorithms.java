package org.sri.javaInterview;


public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] list = {5,1,6,2,7,3,8,4,9};
		int[] list1 = {5,1,6,2,7,3,8,4,9};
		int[] list2 = {5,1,6,2,7,3,8,4,9};
		SortingAlgorithms sa = new SortingAlgorithms();
		sa.insertionSorting(list);
		sa.bubbleSorting(list1);
		sa.selectionSorting(list2);


	}

	public void selectionSorting(int[] list2) {
		System.out.println("Selection Sorting");
		System.out.print("Before Sorting: ");
		for(int value : list2){
			System.out.print(value+"  ");
		}
		
		for(int i=0;i<list2.length-1;i++){
			int index=i;
			for(int j=i+1;j<list2.length;j++){
				if(list2[j]<list2[index]){
					index = j;
				}
			}
			int temp = list2[i];
			list2[i]=list2[index];
			list2[index] = temp;
			System.out.println();
			System.out.print("Iteration "+(i+1)+":::  ");
			for(int value : list2){
				System.out.print(value+"  ");
			}
		}
		System.out.println();
		System.out.print("After Sorting: ");
		for(int value : list2){
			System.out.print(value+"  ");
		}
		
	}

	public void bubbleSorting(int[] list1) {
		System.out.println("Bubble Sorting");
		System.out.print("Before Sorting: ");
		for(int value : list1){
			System.out.print(value+"  ");
		}
		
		for(int i=0;i<list1.length-1;i++){
			for(int j=0;j<list1.length-1;j++){
				int k = j+1;
				if(list1[k]<list1[j]){
					int temp = list1[k];
					list1[k] = list1[j];
					list1[j] = temp;
					System.out.println();
					System.out.print("Iteration "+k+":::  ");
					for(int value : list1){
						System.out.print(value+"  ");
					}
				}
			}
		}
		
		System.out.println();
		System.out.print("After Sorting: ");
		for(int value : list1){
			System.out.print(value+"  ");
		}
		System.out.println();
		System.out.println();
		
	}

	public void insertionSorting(int[] list) {
		System.out.println("Insertion Sorting");
		System.out.print("Before Sorting: ");
		for(int value : list){
			System.out.print(value+"  ");
		}
		
		for(int i=1;i<list.length-1;i++){
			int temp = list[i];
			int index = i;
			while(index>0 && list[index-1]>temp){
				list[index] = list[index-1];
				index--;
			}
			list[index] = temp;
			System.out.println();
			System.out.print("Iteration "+(i)+":::  ");
			for(int value : list){
				System.out.print(value+"  ");
			}
		}
		
		System.out.println();
		System.out.print("After Sorting: ");
		for(int value : list){
			System.out.print(value+"  ");
		}
		System.out.println();
		System.out.println();
		

	}

}
