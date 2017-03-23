package org.sri.javaInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;



public class CollectionsImplementation {

	public static void main(String [] args){
		List<Integer> arrayList = new ArrayList<>(5);
		arrayList.add(2);
		arrayList.add(32);
		arrayList.add(1);
		
		System.out.println("Print Array List: "+ arrayList);
		System.out.println("ArrayList Size :" +arrayList.size());
		
		List<Integer> vector = new Vector<>();
		vector.add(23);
		vector.add(21);
		System.out.println("Print Vector List: "+ vector);
		System.out.println("Vector Size :"+vector.size() );
		
		
		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(21);
		linkedList.add(25);
		linkedList.get(1);
		System.out.println("Print LinkedList :" +linkedList);
		System.out.println("LinkedList Size :" +linkedList.size());
		
	}

	
}
