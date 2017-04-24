package org.sri.javaInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValue {

	public static void main(String [] args){
	Map<String,Integer> m = new HashMap<String,Integer>();
	m.put("Srinadh",80);
	m.put("Ashwini",85);
	m.put("Ramya", 78);
	m.put("Ben",81);
	m.put("Mani",89);
	m.put("Kodi",87);
	Set<Entry<String,Integer>> set=m.entrySet();
	List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(set);
	SortMapByValue s = new SortMapByValue();
	s.sortByAnonymous(list);
	s.sortByLamdaExpression(list);
	}
	

	public void sortByAnonymous(List<Entry<String,Integer>> list){
		System.out.println("Inside sortByAnonymous method : ");
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>()
				{
					public int compare(Map.Entry<String, Integer> o1,Map.Entry<String,Integer> o2){
						return(o2.getValue()).compareTo(o1.getValue());
					}
				});
		for(Map.Entry<String, Integer> entry:list){
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
			
		}	
	}


	public void sortByLamdaExpression(List<Entry<String, Integer>> list) {
		System.out.println();
		System.out.println("Inside sortByLamdaExpression method : ");
		Collections.sort(list, (o1,o2) -> {
			return(o2.getValue()).compareTo(o1.getValue());
		});
		
		for(Map.Entry<String, Integer> entry:list){
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
		}
	}
}
