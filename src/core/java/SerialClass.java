package core.java;

import java.io.Serializable;

public class SerialClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private transient int rollNo;
	private String school;
	
	
	public SerialClass(String name, int rollNo, String school) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.school = school;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
