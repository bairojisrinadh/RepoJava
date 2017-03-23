package org.sri.javaInterview;

public class SelectionSort {

	public static void main(String[] args) {
		int[] list = {9,8,7,6,5,4,3,2,1};
		int count=0;
		System.out.println("Size of Array :"+list.length);
		System.out.println("SelectionSort Comparsions caluculation, formula: list.length*(list.length - 1) :: " +list.length*(list.length -1));
		System.out.print("Before SelectionSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
		
		for(int i=0;i<list.length-1;i++){
			int index = i;
			for(int j=i+1;j<list.length;j++){
				if(list[j]<list[index]){
					index=j;
				}
			}
			int temp = list[index];
			list[index]=list[i];
			list[i]=temp;
			count++;
		}
		

		System.out.println();
		System.out.println("Looping Count: " +count);
		System.out.print("After SelectionSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
	}

}

