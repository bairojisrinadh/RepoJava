package org.sri.JAXB.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	private String address;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String Address) {
		this.address = Address;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}
	
	
	
	
}
