package org.sri.giftpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PackageImpl {

	public static final double PACKAGE_WEIGHT = 100;
	public static final int MAX_ITEMS_PER_PACKAGE = 15;
	public static final double MAX_WEIGHT_PER_ITEM = 100;
	public static final double MAX_COST_PER_ITEM = 100;

	public static List<String> Test_Cases = new ArrayList<>();
	public static Map<Integer, List<Item>> final_gift_package = new LinkedHashMap<>();

	public static void main(String... args){
		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))){
			String line = "";
			while((line = br.readLine()) != null){
				Test_Cases.add(line);
			}
			seperateEachTest(Test_Cases);
			for(Map.Entry<Integer, List<Item>> entry : final_gift_package.entrySet()){
				System.out.println("Package: "+entry.getKey()+", List of Items in it: "+entry.getValue().toString());
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void seperateEachTest(List<String> list) {
		Map<Integer,List<Item>> test_map = new LinkedHashMap<>(MAX_ITEMS_PER_PACKAGE);

		for(String testCases : list){
			String[] split_using_colon = testCases.split(":");
			test_map.put(Integer.valueOf(split_using_colon[0].trim()),getListOfStrings(split_using_colon[1].trim()));
		}

		for(Map.Entry<Integer,List<Item>> entry : test_map.entrySet()){
			final_gift_package.put(entry.getKey(), createPackage(entry.getKey(),entry.getValue()));
		}

	}

	private static List<Item> createPackage(Integer package_weight,
			List<Item> items) {
		Collections.sort(items, new ItemWeightComparator());
		double package_wt = package_weight.doubleValue();
		List<Item> temp_list = new LinkedList<>();
		for(Item element : items){
			if(element.getWeight() <= package_wt){
				package_wt -= element.getWeight();
				temp_list.add(element);
			}	
		}

		return temp_list;
	}

	public static List<Item> getListOfStrings(String string) {
		List<Item> items = new ArrayList<>();
		String[] getStrings_from_givenLine = string.split(" ");
		for(String element : getStrings_from_givenLine){
			String item_details_string = element.trim();
			String eliminate_braces = item_details_string.substring(1,item_details_string.length() - 1);
			String[] split_item_elements =  eliminate_braces.split(",");
			Item item = new Item(Integer.valueOf(split_item_elements[0]),Double.valueOf(split_item_elements[1]),
					Double.valueOf(split_item_elements[2].substring(1)));
			items.add(item);
		}
		return items;
	}
}

