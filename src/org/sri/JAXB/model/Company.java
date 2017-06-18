package org.sri.JAXB.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

	@XmlElement
	private String companyName;
	@XmlElementWrapper(name="Employees")
	@XmlElement(name="Employee")
	private List<Employee> empList;
	@XmlElement
	private String companyAddress;
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Employee> getEmpList() {
		return empList;
	}


	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String address) {
		this.companyAddress = address;
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", empList=" + empList
				+ ", address=" + companyAddress + "]";
	}



}
