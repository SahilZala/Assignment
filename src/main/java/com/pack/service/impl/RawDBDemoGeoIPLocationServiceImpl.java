package com.pack.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.pack.model.GeoIP;

public class RawDBDemoGeoIPLocationServiceImpl {
	private DatabaseReader dbReader;
    
    public RawDBDemoGeoIPLocationServiceImpl() throws IOException {
        File database = new File("./GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }
    
    public GeoIP getLocation(String ip) 
      throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude = 
          response.getLocation().getLatitude().toString();
        String longitude = 
          response.getLocation().getLongitude().toString();
        return new GeoIP(ip, cityName, latitude, longitude);
    }
}
