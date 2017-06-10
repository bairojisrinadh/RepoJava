package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class StreamFilter {

	public static void main(String[] args) {
		//for experience in streams intermediate functions etc
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		int sum = list.stream()
				  .filter(e -> e%2 == 0)
				  .mapToInt(e -> e*10)
				  .sum();
		System.out.println("Sum: "+sum);
		
		//print prime numbers using streams
		List<Integer> list1 = new ArrayList<>();
		for(int i = 1; i <= 1000; i++){
			list1.add(i);
		}
		System.out.print("Prime Numbers using predicate: ");
		list1.stream()
			 .filter(new PrimeFunction())
			 .forEach(e -> System.out.print(e+" "));
		
		System.out.println();
		System.out.print("Prime Numbers using LongStream: ");
		primeSequence(25).forEach(e -> System.out.print(e+" "));
		
	}
	
	public static LongStream primeSequence(long max){
		return LongStream.iterate(2, i -> i + 1)
						 .filter(e -> isPrime(e))
						 .limit(max);
	}

	public static boolean isPrime(long e) {
		boolean isPrime = true;
		long i = e;
		for(int j = 2; j <= i/2; j++){
			if(i%j == 0)
				isPrime = false;
		}
		return isPrime;
	}

}

class PrimeFunction implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		boolean isPrime = true;
		int i = t;
		if(i>2){
		for(int j = 2; j <= i/2; j++){
			if(i % j == 0)
			isPrime = false;
		}
		if(isPrime){
			return true;
		}else{
		return false;
		}
		}return false;
	}
	
}
