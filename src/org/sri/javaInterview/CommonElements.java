package org.sri.javaInterview;

public class CommonElements {

	public static void main(String[] args) {
		int ar1[] = {1,2,3,4,5};
		int ar2[] = {3,4,5,6,7};
		
		for(int i=0;i<ar1.length;i++){
			for(int j=0;j<ar2.length;j++){
				if(ar2[j] == ar1[i]){
					System.out.println(ar2[j]);
				}
			}
		}

	}

}
