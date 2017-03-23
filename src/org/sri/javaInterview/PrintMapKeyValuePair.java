package org.sri.javaInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintMapKeyValuePair {

	public static void main(String[] args) {
		Map<Integer,String> m = new HashMap<>();
		m.put(2, "Dinesh");
		m.put(3, "Srinadh");
		m.put(1, "Amar");
		m.put(9, "Ash");
		m.put(5, "Sheshi");
		Set<Entry<Integer, String>> set = m.entrySet();
		List<Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer,String>>(set);
		list.sort((o1,o2) -> {return (o2.getKey()>o1.getKey()?-1:1);});
		for(Entry<Integer, String> i : list)
		{
			System.out.println(i);
		}
	}

}
