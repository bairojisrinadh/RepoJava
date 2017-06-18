package org.sri.JAXB.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;



@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	@XmlElement
	private String empName;
	@XmlElement
	private int age;
	@XmlElement
	private double salary;
	@XmlElement
	private String dept;
	@XmlElementWrapper(name="Adresses")
	private List<Address> address1;
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<Address> getAddress() {
		return address1;
	}
	public void setAddress(List<Address> address) {
		this.address1 = address;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", age=" + age + ", salary="
				+ salary + ", dept=" + dept + ", address=" + address1 + "]";
	}
	
}
