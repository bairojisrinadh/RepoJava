package org.sri.giftpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PackageImpl {

	public static final double PACKAGE_WEIGHT = 100;
	public static final int MAX_ITEMS_PER_PACKAGE = 15;
	public static final double MAX_WEIGHT_PER_ITEM = 100;
	public static final double MAX_COST_PER_ITEM = 100;

	public static List<String> Test_Cases = new ArrayList<>();

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


		/*for(Map.Entry<Integer,List<Item>> entry : test_map.entrySet()){
			System.out.println(entry.getKey()+" == "+ entry.getValue().toString());
		}*/

		//List<String> 


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
