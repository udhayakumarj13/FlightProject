package com.fms.service;

import java.util.List;

import com.fms.dto.Airport;


public interface AirportServiceInterface {
	
	List<Airport> viewAllAirports();
	void deleteAirport(String airportCode);

}
