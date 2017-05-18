package org.sri.javaInterview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentHashMapImpl{
	
	public static void main(String... args){
		usingConcurrentHashMapForIntegerElements();
		usingConcurrentHashMapForStringElements();
		usingHashMapForStringElements();
	}

	public static void usingConcurrentHashMapForIntegerElements(){
		Map<Integer,Integer> map = new ConcurrentHashMap<>();
		map.put(3, 1);
		map.put(5, 1);
		map.put(4, 1);
		map.put(1, 1);
		map.put(2, 1);
		
		Iterator<Integer> itr = map.keySet().iterator();
		
		while(itr.hasNext()){
			int key = itr.next();
			if(key == 3){
				map.put(key+10, map.get(key)+key); //here adding a new key,value pair while iterating the collection of elements
			}	                                   //map.put(key, map.get(key)+key);If we just change the value of key, it will accept even it is HashMap elements. Here we are not changing collection elements, just changing the existing value of specified key
		}                                          //map.put(key+10, map.get(key)+key); If we add new Key value element in the collection while iterating, now we will get concurrentModificationException while using HashMap. This issue is resolved using ConcurrentHashMap
		System.out.println("Concurrent Hash Map after iteration: "+ map);
	}

	public static void usingConcurrentHashMapForStringElements(){
		Map<String,String> map = new ConcurrentHashMap<>();
		map.put("3", "1");
		map.put("5", "1");
		map.put("4", "1");
		map.put("1", "1");
		map.put("2", "1");
		System.out.println("Concurrent Hash Map before iteration: "+ map);
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext()){
			String key = itr.next();
			if(key.equals("3")){
				map.put(key+"new", "new3");
			}	
		}
		System.out.println("Concurrent Hash Map after iteration: "+ map);
	}
	
	public static void usingHashMapForStringElements(){
		Map<String,String> map = new HashMap<>();
		map.put("3", "1");
		map.put("5", "1");
		map.put("4", "1");
		map.put("1", "1");
		map.put("2", "1");
		System.out.println("Concurrent Hash Map before iteration: "+ map);
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext()){
			String key = itr.next();
			if(key.equals("3")){
				map.put(key+"new", "new3");
				break;
			}	
		}
		System.out.println("Concurrent Hash Map after iteration: "+ map);
	}
}



//Bit of code is wrong under method modifyConcurrentHashMap()

/*public class ConcurrentHashMapImpl implements Runnable {

	private static Map<Integer,Integer> chm = null;
	//private ConcurrentHashMap<Integer, Integer> chm = null;
	//Set<Map.Entry<Integer, Integer>> set = null;

	public ConcurrentHashMapImpl(){
		chm = new HashMap<>();
		//chm = new ConcurrentHashMap<>(20);
		chm.put(4, 4);
		chm.put(6, 6);
		chm.put(1, 1);
		chm.put(3, 3);
		chm.put(8, 8);
		chm.put(2, 2);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ConcurrentHashMapImpl());
		Thread t2 = new Thread(new ConcurrentHashMapImpl());
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		synchronized(this){
			concurrentHashMapCheck();
		}
		synchronized(this){
			modifyConcurrentHashMap();
		}

	}


	public static void concurrentHashMapCheck(){
		Set<Map.Entry<Integer, Integer>> set = chm.entrySet();
		Iterator<Map.Entry<Integer, Integer>> itr = set.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		for(Map.Entry<Integer, Integer> entry : set){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}

	public static void modifyConcurrentHashMap(){
		Set<Map.Entry<Integer, Integer>> set = chm.entrySet();
		Map.Entry<Integer,Integer> e = new Map.Entry<Integer, Integer>() {

			@Override
			public Integer setValue(Integer value) {
				// TODO Auto-generated method stub
				return value;
			}

			@Override
			public Integer getValue() {
				// TODO Auto-generated method stub
				return getValue();
			}

			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return 2;
			}
		};
		set.add(e);
	}

}*/
