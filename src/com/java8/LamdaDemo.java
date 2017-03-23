package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LamdaDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(21);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(12);
		list.add(3);
		list.sort((o1,o2) -> {return o1>o2?1:-1;}); // This lambda expression is for using of Comparator interface 
		list.forEach(i -> System.out.println(i));
		System.out.println("Find Any:"+list.stream().findFirst());
		/*list.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2)
					return 1;
				else
					return -1;
			}
		});
		
		for(int i : list){
			System.out.println(i);
		}*/
		

	}

}
