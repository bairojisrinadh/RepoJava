package org.sri.javaInterview;

public class DecimalToBinary {

	public static void main(String[] args) {
		DecimalToBinary dtb = new DecimalToBinary();
		dtb.getBinary(7);

	}

	private void getBinary(int num) {
		int[] binary = new int[25];
		int index=0;
		
		while(num>0){
			binary[index++]=num%2;
			num=num/2;
		}
		
		for(int i=index-1;i>=0;i--){
			System.out.print(binary[i]);
		}
		
	}

}
