package org.sri.javaInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousUsingCollection {

	
	public static void main(String [] args){
		List<Integer> list = new ArrayList<>();
		list.add(523);
		list.add(222);
		list.add(919);
		list.add(490);
		list.add(2, 308);
		
		AnonymousUsingCollection obj = new AnonymousUsingCollection();
		obj.sortUsingAnonymous(list);
		obj.sortUsingLamdaExpression(list);
	}
	
	public void sortUsingAnonymous(List<Integer> list){
		System.out.println(":::In sortUsingAnonymous() Method:::");
		System.out.print("Before sorting using last value : ");
		for(int x:list){
			System.out.print(x+"\t");
		}
		System.out.println();
		Collections.sort(list, new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				if(o1%10>o2%10)
					return 1;
				else
					return -1;
			}
			
		});
		
		System.out.print("After sorting using last value  : ");
		for(int i:list){
			System.out.print(i+"\t");
		}
	}
	
	public void sortUsingLamdaExpression(List<Integer> list){
		System.out.println();
		System.out.println(":::In sortUsingLamdaExpression() Method:::");
		System.out.print("Before sorting using last 2 values : ");
		for(int x:list){
			System.out.print(x+"\t");
		}
		System.out.println();
		Collections.sort(list, (o1,o2) -> { return o1%100>o2%100?1:-1;});
		System.out.print("After sorting using last 2 values  : ");
		for(int i:list){
			System.out.print(i+"\t");
		}
	}
}
