package org.geonames.feed;

public class PostalCode {
	
	private int postalCode;
	private String name;
	private String countryCode;
	private long latitude;
	private long longitude;
	
	public PostalCode(int postalCode, String name, String countryCode,
			long latitude, long longitude) {
		super();
		this.postalCode = postalCode;
		this.name = name;
		this.countryCode = countryCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getName() {
		return name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public long getLatitude() {
		return latitude;
	}

	public long getLongitude() {
		return longitude;
	}

}
