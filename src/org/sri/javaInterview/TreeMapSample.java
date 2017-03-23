package org.sri.javaInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSample {

	public static void main(String[] args) {
		Map<String, Integer> tm = new TreeMap<String,Integer>();
		tm.put("Inter", 92);
		tm.put("Btech", 79);
		tm.put("SSC", 81);
		System.out.println(tm);
		System.out.println(tm.size());
		Set<Entry<String, Integer>> set = tm.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(set);
	
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				
				return (o2.getValue().compareTo(o1.getValue()));
			}
			
		});
		
	
		for(Map.Entry<String, Integer> entry : list){
			System.out.println(entry.getKey()+ "====" +entry.getValue());
		}

	}

}
