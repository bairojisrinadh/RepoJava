package com.highradius;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PairOfNumbersForOutput {

	public static String acceptString = "",output="";
	private static Scanner sc;
	
	public static void main(String... args){
		sc = null;
		try{
			sc = new Scanner(System.in);
			System.out.println("Enter Numbers Seperated By commos: ");
			acceptString = sc.nextLine();
			System.out.println("Enter Output you want: ");
			output = sc.nextLine();
			findPairsForGivenOutput(acceptString,output);
		}finally{
			if(sc != null)
			sc.close();
		}
	}

	
	
	public static void findPairsForGivenOutput(String acceptedString,String output){
		String[] numbers = acceptedString.split(",");
		Set<Integer> set = new TreeSet<Integer>();
		Integer givenOutput = Integer.parseInt(output);
		
		for(int i=0; i<numbers.length; i++){
			set.add(Integer.parseInt(numbers[i]));
		}
		
		
		for(Integer number : set){
			if(number <= givenOutput/2){
			Integer pairValue = givenOutput - number;
			if(set.contains(pairValue)){
				System.out.println("One of Pair is : ("+number+" , "+pairValue+")");
			}
			}
		}
		
	}
}
