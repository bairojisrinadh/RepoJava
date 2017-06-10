package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Why to use Stream API of Java 8 ? Speed matters.
public class StreamUsage {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Random random = new Random();
		List<Integer> data = new ArrayList<>();
		
		for(int i = 0; i < 1000000; i++){
			data.add(random.nextInt() / 10000000);
		}

		long result;
		// Old method of for each iterator used.
		/*for(int value : data){
			result += func(value);
		}*/
		
		//using parallel streaming we can use complete cores of ur machine
		result = data.parallelStream().map(i -> func(i)).reduce(Integer::sum).get();
		System.out.println("Result: "+result);
		System.out.println("Time Taken: "+ (System.currentTimeMillis() - startTime) +" msecs");
	}

	public static int func(int value) {
		int n = 0;
		if(value <= 0){
			return n;
		}else{
			return value * n;
		}
	}

}
