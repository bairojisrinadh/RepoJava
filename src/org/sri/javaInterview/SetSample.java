package org.sri.javaInterview;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetSample{
		
	public static void main(String [] args){
	
		Set<String> s = new HashSet<String>();
		s.add("Srinadh");
		s.add("Ashwini");
		s.add("Ramya");
	
		
		System.out.println(s);
		TreeSet<String> sortedset = new TreeSet<String>(s);
		System.out.println(sortedset);
		
		
		
	}
	
	
}
