package org.sri.giftpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
				//System.out.println(line);
				Test_Cases.add(line);
			}
			seperateEachTest(Test_Cases);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void seperateEachTest(List<String> list) {
		String package_limit = "";
		//String[] items_List = new String[MAX_ITEMS_PER_PACKAGE];
		Map<Integer,List<Item>> test_map = new LinkedHashMap<>(MAX_ITEMS_PER_PACKAGE);

		for(String testCases : list){
			String[] split_using_colon = testCases.split(":");
			test_map.put(Integer.valueOf(split_using_colon[0].trim()),getListOfStrings(split_using_colon[1].trim()));
		}


		for(Map.Entry<Integer,List<Item>> entry : test_map.entrySet()){
			//System.out.println(entry.getKey()+" == "+ entry.getValue().toString());
			final_gift_package = createPackage(entry.getKey(),entry.getValue());
		}

	}

	private static Map<Integer, List<Item>> createPackage(Integer package_weight,
			List<Item> items) {
		Collections.sort(items, new ItemWeightComparator());
		List<Item> temp_list = new LinkedList<>();
		double weight_count = 0;
		for(Item element1 : items){
			Item element = element1;
			weight_count += element.getWeight();
			if(weight_count <= package_weight){
				temp_list.add(element);
			}else{
				double remaining_package_weight = package_weight - (weight_count - element.getWeight());
				if(element.getWeight() <= remaining_package_weight){
					temp_list.add(element);
					weight_count += element.getWeight();
				}
			}
		}
		
		return (Map<Integer,List<Item>>) new LinkedHashMap<>().put(package_weight, temp_list);
	}

	public static List<Item> getListOfStrings(String string) {
		List<Item> items = new ArrayList<>();
		String[] getStrings_from_givenLine = string.split(" ");
		for(String element : getStrings_from_givenLine){
			//items.add(element.trim());
			String item_details_string = element.trim();
			String eliminate_braces = item_details_string.substring(1,item_details_string.length() - 1);
			//System.out.println(eliminate_braces);
			String[] split_item_elements =  eliminate_braces.split(",");
			Item item = new Item(Integer.valueOf(split_item_elements[0]),Double.valueOf(split_item_elements[1]),
					Double.valueOf(split_item_elements[2].substring(1)));
			//System.out.println(item.toString());
			items.add(item);
		}
		return items;
	}
}

