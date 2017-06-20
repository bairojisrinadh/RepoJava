package org.sri.giftpackage;

import java.util.Comparator;

public class ItemCostComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getCost() > o2.getCost() ? 1 : (o1.getCost() == o2.getCost()) ? 0 : -1 ;
	}

}
