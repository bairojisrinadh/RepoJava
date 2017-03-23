package org.sri.javaInterview;

public class InsertionSorting {

	public static void main(String[] args) {
		int[] list1 = {9,8,7,6,5,4,3,2,1};
		InsertionSorting is = new InsertionSorting();
		is.insertionMethod1(list1);
		int[] list2 = {9,8,7,6,5,4,3,2,1};
		is.insertionMethod2(list2);

	}
	
	public void insertionMethod2(int[] list) {
		int n = list.length;
		System.out.println();
		System.out.println("Size of Array :"+list.length);
		System.out.print("Before InsertionSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
		
		for(int i=1;i<=n-1;i++){
			int temp = list[i];
			int index = i;
			while(index>0 && (list[index-1]>temp)){
				list[index]= list[index-1];
				index--;
			}
			list[index]= temp;
			
		}
		
		System.out.println();
		//System.out.println("Looping Count: " +count);
		System.out.print("After InsertionSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
		
	}

	public void insertionMethod1(int[] list){
		
		int n = list.length;
		int temp;
		System.out.println("Size of Array :"+list.length);
		System.out.print("Before InsertionSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
		for(int i=1;i<n;i++){
			for(int j=i;j>0;j--){
				if(list[j]<list[j-1]){
					temp = list[j];
					list[j]=list[j-1];
					list[j-1]=temp;
				}
				
				
			}
		}
		
		System.out.println();
		//System.out.println("Looping Count: " +count);
		System.out.print("After InsertionSort List: ");
		for(int k=0;k<list.length;k++){
			System.out.print(list[k]+" ");	
		}
		
	}

}
