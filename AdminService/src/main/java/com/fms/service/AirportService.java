package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Airport;
import com.fms.dto.Flight;
import com.fms.repository.AirportRepository;

@Service
public class AirportService implements AirportServiceInterface {
	
	@Autowired
	private AirportRepository airportDao;

	public List<Airport> viewAllAirports() {
		return airportDao.findAll();
	}

	public void deleteAirport(String airportCode) {
		airportDao.deleteById(airportCode);
		
	}

	public String updateAirport(Airport airport) {
		boolean result = airportDao.existsById(airport.getAirportCode());
		
		if(result) {
			airportDao.save(airport);
			return "Airport Details Updated successfully";
		}else 
		return "Please Enter correct Id";
	}

	public Airport addAirport(Airport airport) {
		return airportDao.save(airport);
	}
	
	public Flight blockFlights(Flight flight) {
		return airportDao.save(flight);
		
	}
	
	public Flight  unblockFlights(Flight flight) {
		return airportDao.save(flight);
	}

}
