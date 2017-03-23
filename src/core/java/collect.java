package core.java;

import java.util.*;

public class collect {
	public static int method(){
		Map<Integer,Integer> list = new HashMap<>();
		list.put(1, 21);
		list.put(2, 24);
		list.put(3, 3);
		
	
		return list.size();
		
	}
	public static void main(String [] args){
		System.out.println(collect.method());
	}
}
