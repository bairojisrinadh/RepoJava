package org.sri;

import java.util.Date;

public abstract class Action implements UrlInterface {

	public int getID(){
		
		URL obj = getURL();
		String str = obj.getKey();
	    String str1 = str.substring(1,str.length());
	    int val = Integer.parseInt(str1);
		return val;
	}

	public URL getURL(){
		
		URL obj = new URL();
		obj.setUrl("https://lpu.zurich.ch/zedec/completion");
		obj.setKey("C939937347");
		obj.setPassword("P2323846873");
		obj.setExpiryDate(new Date());
		
		return obj;
	}
}
