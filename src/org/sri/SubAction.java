package org.sri;

public class SubAction extends Action {

	public String generateURL(){
		System.out.println("In generation of URL");
		URL str = getURL();
		
		return str.toString();
	}

}
