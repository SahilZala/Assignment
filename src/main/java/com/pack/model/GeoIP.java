package com.pack.model;

public class GeoIP {
    
	public GeoIP(String ipAddress, String city, String latitude, String longitude) {
		super();
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
	@Override
	public String toString() {
		return "GeoIP [ipAddress=" + ipAddress + ", city=" + city + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
    
    
    // constructors, getters and setters... 
}
