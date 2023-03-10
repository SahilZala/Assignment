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
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
    // constructors, getters and setters... 
}
