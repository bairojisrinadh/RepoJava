package org.sri.javaInterview;

import java.util.HashMap;

public class MyHashCodeImpl {

	public static void main(String[] args) {
		//MyHashCodeImpl hmImpl = new MyHashCodeImpl(); /* Outer Class instance created, inOrder to create inner class instance */
		/* To make below code work, replace inner class as static (non-access modifier) */
		HashMap<Price,String> hm = new HashMap<Price,String>();
		hm.put(new Price("Banana", 20), "Banana");
		hm.put(new Price("Apple", 40), "Apple");
		hm.put(new Price("Orange", 30), "Orange");
		Price key = new Price("Apple", 40);
		System.out.println("Hashcode of the key: "+key.hashCode());
		System.out.println("Value from map: "+hm.get(key));
	}

	static class Price{
	
		private String item;
		private int price;
		
		public Price(String itm, int pr){
			this.item = itm;
			this.price = pr;
		}
		
		public int hashCode(){
			System.out.println("In HashCode Method");
			int hashcode = 0;
			hashcode = price*20;
			hashcode += item.hashCode();
			return hashcode;
		}
		
		public boolean equals(Object obj){
			System.out.println("In equals Method");
			if(!(obj instanceof Price)){
				return false;	
			}else{
				Price pp = (Price)obj;
				return (pp.item.equals(this.item) && pp.price==this.price);
			}
		}
		
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		public String toString(){
			return "item: "+item+"  price: "+price;
		}
		
	}
}