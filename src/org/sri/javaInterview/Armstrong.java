package org.sri.javaInterview;

public class Armstrong {
	
	public boolean isArmstrong(int x){
		int temp = x;
		int noOfDigits = String.valueOf(x).length();
		int div = 0;
		int sum = 0;
		
		while(temp>0){
			
			div= temp%10;
			int temp1=1;
			for(int i=0; i<noOfDigits;i++){
				temp1 *= div;
			}
			sum += temp1;
			temp = temp/10;
		}
		if(x == sum) {
			return true; 
		} else {
			return false; 
		} 
	}

	public static void main(String[] args) {
		Armstrong arm = new Armstrong();
		int x = 153;
		System.out.println("Is "+x+", An Armstrong Number? " +arm.isArmstrong(x));
		

	}

}
