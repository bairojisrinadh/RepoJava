package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsImpl {

	public static void main(String... args){
		//initial();
		//creationAndConversion();
		//intermediateOperations();
		//terminalOpertions();
		//practice();
		//parallelStreamProcess();
		impl();
	}
	
	public static void initial(){
		Stream<Integer> stream = Stream.of(1,4,5,6,8,22,43,11);
		Stream<Integer> stream1 = Stream.of(new Integer[]{1,2,42,12,32});
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<100;i++)list.add(i);
		
		Stream<String> s1 = Stream.generate(() -> {return "abc";} );
		Stream<String> s2 = Stream.iterate("srinadh", (i) -> i);
	}
	
	public static void creationAndConversion(){
		Stream<Integer> stream = Stream.of(1,4,5,6,8,22,43,11);
		List<Integer> list = stream.filter(p -> p > 10).sorted().collect(Collectors.toList());
		System.out.println(list);
		stream = Stream.of(4,3,6,1,12);
		Map<Integer,Integer> intMap = stream.collect(Collectors.toMap(i -> i, i -> i+10));
		System.out.println(intMap);
		
		stream = Stream.of(21,323,434,211);
		Integer[] intArray = stream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray));
	}
	
	public static void intermediateOperations(){
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<100; i++)list.add((int) (i*Math.random()));
		Stream<Integer> stream = list.stream();
		
		Stream<Integer> highNum = stream.filter(p -> p>50);
		highNum.forEach(p -> System.out.print(p+" "));
		
		Stream<String> str = Stream.of("srinadh","biroji","BOLD");
		System.out.println(str.map(s -> {return s.toUpperCase();})
				.filter(s -> s.length() > 4)
				.sorted()
				.collect(Collectors.toList()));
		
		//flatMap()
		
		Stream<List<String>> stream1 = Stream.of(Arrays.asList("Srinadh"),
				Arrays.asList("Benny","Mani"),
				Arrays.asList("Ramya"));
		Stream<String> flatStream = stream1.flatMap(s -> s.stream());
		flatStream.forEach(System.out::println);
				
	}
	
	public static void terminalOpertions(){
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		Optional<Integer> opt = stream.reduce((i,j) -> {return i*j;});
		if(opt.isPresent()){
			System.out.println("Multiplication: "+ opt.get());
		}
		
		//anyMatch
		stream = Stream.of(21,32,43,54,65,76);
		System.out.println("Any Match Found: "+ stream.anyMatch(i -> i==32));
	
		//allMatch
		stream = Stream.of(21,32,43,54,65,76);
		System.out.println("Stream contains all elements < 100: "+stream.allMatch(i -> i<100));
		
		//noneMatch
		stream = Stream.of(21,32,43,54,65,76);
		System.out.println("Stream does not contain 21? : " +stream.noneMatch(i -> i==21));
		
		//findFirst
		Stream<String> stream1 = Stream.of("Sri","Ramya","Sharad","Ash","Sainath");
		Optional<String> opt1 =  stream1.filter(i -> i.startsWith("S")).findFirst();
		if(opt1.isPresent()){
			System.out.println("First Name starting with letter 'S': "+opt1.get());
		}
		
	}
	
	public static void practice(){
		
		List<Double> list = Arrays.asList(21.00,645.423,131.43,1234.443,22.32,343.32);
		
		int sum = (int) list.stream().filter(i -> i<500).mapToDouble(i->i).sum();
		System.out.println(sum);
	}
	
	public static void parallelStreamProcess(){
		List<Integer> list = Arrays.asList(21,32,8,3,65,76,20,9,1,2,65,76,2565,3562,4653,5654,6655,6576);
		List<Integer> result = new ArrayList<>();
		Stream<Integer> stream = list.parallelStream();
		stream.map(s ->{
			synchronized (result){
				if(result.size()<5){
					result.add(s);
				}
			}
			return s;
		}).forEach(e -> System.out.println(e));
		System.out.println(result);
	}
	
	
	public static void impl(){
		Map<Integer,String> map = new HashMap<>();
		map.put(21, "Ashwini");
		map.put(43, "Saran");
		map.put(65, "Dinesh");
		map.put(02, "Ramya");
		map.put(66, "Divya");
		map.put(99, "Mani");
		map.put(33, "Benny");
		map.put(44, "Srinadh"); 
		Set<Entry<Integer,String>> set = map.entrySet();
		List<Entry<Integer,String>> list = new ArrayList<>(set);
		list.sort(new Comparator<Map.Entry<Integer, String>>(){

			@Override
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				return (o1.getKey()<50&&o2.getKey()<50)?(o1.getKey()>o2.getKey()?1:-1):-1;
				//return o1.getKey()>o2.getKey()?1:-1;
			}
			
		});
		
		for(Map.Entry<Integer, String> entry : list){
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		/*Stream<?> stream = (Stream<?>) map.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		stream.forEach(s -> System.out.println(s.toString()));*/
		
	}
	
}
