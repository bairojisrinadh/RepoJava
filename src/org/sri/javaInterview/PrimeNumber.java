package org.sri.javaInterview;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		PrimeNumber p = new PrimeNumber();
		int x = 11;
		System.out.println("Is "+x+", A Prime Number? "+p.isPrimeNumber(x));
		
		System.out.println("List of Prime Numbers below "+x+" are: "+p.getPrimeNumbers(x));
	}

	public List<Integer> getPrimeNumbers(int x) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1;i<=x;i++){
			int counter = 0;
			for (int j=i;j>=1;j--){
				if(i%j==0){
				counter +=1;
				if(counter >=3){break;}
				}
			}if(counter ==2){
				list.add(i);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution Time in MilliSeconds: "+(endTime - startTime));
		return list;
	}

	private boolean isPrimeNumber(int x) {
		int count =0;
		for (int i=2;i<=x/2;i++){
			if(x%i==0){
				System.out.println("If Count: "+count);
				return false;
			}count++;
			
			}
		System.out.println("Looping Count: "+count);
		return true;
		
	}

}
