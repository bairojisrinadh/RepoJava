package org.sri;

import java.util.Date;

public class URL {

	private String url;
	private String key;
	private String password;
	private Date expiryDate;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expirydate) {
		this.expiryDate = expirydate;
	}
	
	public String toString(){
		
		StringBuffer buffer = new StringBuffer();
		if (url!=null){
			buffer.append("url :" +url+ "\n");
		}
		if (key!=null){
			buffer.append("Key :" +key+ "\n");
		}
		if (password!=null){
			buffer.append("password :" +password+ "\n");
		}
		if (expiryDate!=null){
			buffer.append("expiry Date :" +expiryDate+ "\n");
		}
		return buffer.toString() ;
	}
}
