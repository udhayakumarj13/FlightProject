package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Flight;
import com.fms.repository.FlightRepository;

@Service
public class FlightService implements FlightServiceI {
	
	@Autowired
	private FlightRepository flightDao;
	

	public Flight addFlight(Flight flight) {
		return flightDao.save(flight);
		
	}

	public List<Flight> viewFlight(){
		return flightDao.findAll();
		}
	
	public String updateFlight(Flight flight) {
		boolean result=flightDao.existsById(flight.getFlightNumber());
			
			if(result){
				flightDao.save(flight);
				return "Flight details updated successfully";
			}else{
				return "Id not exits";
			}
		
		}
		

	public void deleteFlight(int flight_number) {
		flightDao.deleteById(flight_number);
	
	}
	

	public Flight viewFlight(int flight_number) {
		
		return flightDao.findById(flight_number).get();
	}

	public boolean unblock(Flight flight, Long flightId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean block(Flight flight, Long flightId) {
		// TODO Auto-generated method stub
		return false;
	}

}
