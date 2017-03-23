package org.sri.javaInterview;

public class SwapStrings {
	
	private String fname;
	private String lname;
	
	private SwapStrings(String fname,String lname){
		this.fname = fname;
		this.lname = lname;
	}
	private void swapStringMethod(SwapStrings s) {
		
		String fname = s.fname;
		String lname = s.lname;
		
		System.out.println(":::::Before Swapping::::");
		System.out.println("FirstName :" +fname);
		System.out.println("LastName :" +lname);
		
		int flength = fname.length();
		int llength = lname.length();
		
		String fullName = fname.concat(lname);
		int fullLength = fullName.length();
		fname = fullName.substring(fullLength-flength+1, fullLength);
		lname = fullName.substring(0, fullLength-llength);
		System.out.println(":::::After Swapping::::");
		System.out.println("FirstName :" +fname);
		System.out.println("LastName :" +lname);
	}

	
	public static void main(String[] args) {
		String s1 = "Srinadh";
		String s2 = "Biroji";
		SwapStrings obj = new SwapStrings(s1,s2);
		obj.swapStringMethod(obj);
		
		

	}

}
