package com.earthquake.feed;

import java.util.Date;

public class Quake //implements Comparable 
{
	private Date date;
	private String details;
	private String location;
	private double magnitude;
	private String link;
	
	public Quake(Date date, String details, String location, double magnitude,
			String link) {
		super();
		this.date = date;
		this.details = details;
		this.location = location;
		this.magnitude = magnitude;
		this.link = link;
	}

	public Date getDate() {
		return date;
	}

	public String getDetails() {
		return details;
	}

	public String getLocation() {
		return location;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public String getLink() {
		return link;
	}

	
	//If implementing Comparable interface, for internal sorting
	/*@Override
	public int compareTo(Object o) {
		if(o instanceof Quake){
			Quake q = (Quake) o;
			return this.getMagnitude() < q.getMagnitude() ? 1 : -1;	
		}
		return 0;
	}*/
	
	
}
