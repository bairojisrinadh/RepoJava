package org.sri.javaInterview;


public class TopNumbersOfArray {
	
	public void topNumber(int[] ar){
		int maxOne = 0;
		int maxTwo = 0;
		for (int i : ar){
			if(maxOne<i){
				maxTwo = maxOne;
				maxOne = i;
			}else if(maxTwo<i){
				maxTwo = i;
			}
		}System.out.println("First Max No.:" +maxOne);
		System.out.println("First Max No.:" +maxTwo);
		
	}

	public static void main(String[] args) {
		int ar[] = {2,11,67,1,23};
		TopNumbersOfArray t = new TopNumbersOfArray();
		t.topNumber(ar);
		
		

	}

}
