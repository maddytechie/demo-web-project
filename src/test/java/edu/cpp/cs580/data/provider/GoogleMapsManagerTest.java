package edu.cpp.cs580.data.provider;

import org.junit.Assert;
import org.junit.Test;

import com.google.maps.model.DistanceMatrixElement;

public class GoogleMapsManagerTest{
	
	@Test
	public void testGetResult() throws Exception {
		GoogleMapsManager manager = new GoogleMapsManager();
		DistanceMatrixElement provider = manager.getResult("3425 Pomona Boulevard, Pomona, CA 91768", "20242 Fuero Dr, Walnut, CA 91789");
		Assert.assertEquals("4.0 mi", provider.distance.toString());
		Assert.assertEquals("4.0 mi", provider.distance.humanReadable);
	}
}
