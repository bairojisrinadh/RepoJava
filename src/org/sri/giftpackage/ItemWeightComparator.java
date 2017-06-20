package org.sri.giftpackage;

import java.util.Comparator;

public class ItemWeightComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getWeight() > o2.getWeight() ? 1 : (o1.getWeight() == o2.getWeight()) ? 0 : -1 ;
	}

}
