package edu.cpp.cs580.data.provider;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.Unit;

public class GoogleMapsManager {
private static final String APIKEY = "AIzaSyCeBLuD_-XioM3h7wPmqsz6Vwp9Xsj1lLw";
	
	public GeoApiContext getAPIKey () {
		GeoApiContext context = new GeoApiContext().setApiKey(APIKEY);
		return context;
	}
	
	public String[] getOrigin(String address) {
		String[] origins;
		origins = new String[] {address};
		return origins;
	}
	
	public String[] getDestination(String address) {
		String[] destinations;
		destinations = new String[] {address};
		return destinations;
	}
	
	public DistanceMatrixElement getResult(String origin, String destination) throws Exception {
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(getAPIKey());
		req.units(Unit.IMPERIAL);
		req.origins(getOrigin(origin));
		req.destinations(getDestination(destination));
		DistanceMatrixElement result = req.await().rows[0].elements[0];
		return result;
	}
}
