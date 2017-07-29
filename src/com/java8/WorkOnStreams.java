package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WorkOnStreams {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(21,32,44,11,765,23,56,77,99);
		Comparator<Integer> comparator = (o1,o2) -> { return (o1 > o2) ? 1 : (o1 == o2) ? 0 : -1; };
		list.sort(comparator.reversed());
		Integer intValue  = list.stream().filter(i -> i > 50)
				.mapToInt(i -> i*i)
				.sum();
		System.out.println(intValue);
		//list.stream().forEach(i -> System.out.println(i));
	}

}
