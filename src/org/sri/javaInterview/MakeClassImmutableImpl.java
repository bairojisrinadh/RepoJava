package org.sri.javaInterview;

/**
 * 
 * @author bsrinadh
 *
 *To make a class immutable, you need to make all instance variables of class as private. so, that no object would access those 
 *to change values.
 *
 *Then initialize those variable in constructor, and finally access those variables using getter/accessor methods
 *
 *Do not, provide any setter/mutator methods to change the values of instance variables 
 *
 */
public class MakeClassImmutableImpl {

	static public void main(String... args){
		MakeClassImmutable obj = new MakeClassImmutable();
		//System.out.println(obj.setFirstName()); --> result in compilation error, no method with name setFirstName()
		System.out.println(obj.getFirstName());
		System.out.println(obj.getLastName());
	}
	
}


class MakeClassImmutable{
	
	private String firstName;
	private String lastName;
	
	public MakeClassImmutable(){
		this.firstName = "Srinadh";
		this.lastName = "Biroji";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
}