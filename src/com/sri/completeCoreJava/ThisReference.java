package com.sri.completeCoreJava;

import java.util.Date;

public class ThisReference {

	private String firstName, lastName;
	private Date hireDate;
	
	public ThisReference(String first, String last){
		this(first, last, new Date());
		System.out.println("Inside First Constructor");
	}
	
	public ThisReference(String first, String last, Date hire){
		System.out.println("Inside Second Constructor");
		this.firstName = first;
		this.lastName = last;
		this.hireDate = hire;
	}
	
	public String toString(){
		return "ThisReference[ FirstName: "+ firstName +" ,LastName: " + lastName +" ,HireDate: "+ hireDate + " ]";
	}
	
	public static void main(String[] args) {
		ThisReference obj = new ThisReference("Srinadh","Biroji");
		ThisReference obj1 = new ThisReference("Srinadh","Biroji", new Date(System.currentTimeMillis() + 48*1000));
		System.out.println(obj.toString());
		System.out.println(obj1.toString());
	}

}
