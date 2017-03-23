package org.sri.javaInterview;

public class BubbleSorting {

	public static void main(String[] args) {
		int[] list = {9,8,7,6,5,4,3,2,1};
		int temp;
		int count=0;
		System.out.println("Size of Array :"+list.length);
		System.out.println("BubbleSort Looping caluculation, formula: (list.length - 1)*(list.length + 1) :: " +(list.length -1)*(list.length + 1));
		System.out.print("Before BubbleSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
		
		
		for(int i=list.length;i>=0;i--){
			for(int j=0;j<list.length-1;j++){
				int k = j+1;
				if(list[j]>list[k]){
					temp=list[j];
					list[j]=list[k];
					list[k]=temp;
				}count++;
			}
		}
		System.out.println();
		System.out.println("Looping Count: " +count);
		System.out.print("After BubbleSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
	}

}
