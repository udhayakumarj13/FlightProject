package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.Airport;
import com.fms.dto.Flight;

import com.fms.dto.Userdata;
import com.fms.exception.FlightNotFoundException;
import com.fms.exception.IdNotFoundException;
import com.fms.service.AirportService;
import com.fms.service.FlightService;

import com.fms.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private FlightService flightService;

	@Autowired
	private UserService userservice;

	@Autowired
	private AirportService airportService;

	// add user
	@PostMapping(value = "/addUser")
	public ResponseEntity<String> addUser(@RequestBody Userdata user) {
		Userdata e = userservice.addUser(user);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Username");
		} else {
			return new ResponseEntity<>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// login user
	@PutMapping("/loginUser")
	public String loginUser(@RequestBody Userdata u) {

		return userservice.loginUser(u);

	}

	// add flight details
	@PostMapping("/addflight")
	public String addFlight(@RequestBody Flight flight) {
		Flight f = flightService.addFlight(flight);
		if (f != null) {
			return "Flight details are added";
		} else
			throw new FlightNotFoundException("Invalid flight details");
	}

	// get all flights`
	@GetMapping(value = "/getAllFlight", produces = "application/json")
	public List<Flight> viewFlight() {
		return flightService.viewFlight();
	}

	// update flight
	@PutMapping("/updateFlight")
	public String modifyFlight(@RequestBody Flight flight) {
		return flightService.updateFlight(flight);
	}

	// delete flight
	@DeleteMapping("/deleteFlight/{flightnumber}")
	public String deleteFlight(@PathVariable int flightnumber) {

		flightService.deleteFlight(flightnumber);
		return "Flight Details Deleted";
	}

	// get particular flight using flight number
	@GetMapping(value = "/getflight/{flight_no}", produces = "application/json")
	public Flight viewFlight(@PathVariable int flight_no) {
		return flightService.viewFlight(flight_no);
	}

	// getAllAirports
	@GetMapping(value = "/getAllAirports", produces = "application/json")
	public List<Airport> viewAllAirport() {
		return airportService.viewAllAirports();
	}

	// delete airport
	@DeleteMapping("/deleteAirport/{airportCode}")
	public String deleteAirport(@PathVariable String airportCode) {
		airportService.deleteAirport(airportCode);
		return "Success!!. Airport Details Deleted";
	}
	
    // updateAirpot
	@PutMapping("/updateAirport")
	public String updateAirportDetails(@RequestBody Airport airport) {
		return airportService.updateAirport(airport);

	}

	// add airport
	@PostMapping("/addAirport")
	public String addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
		return "Airport added successfully";
		
	}

	// block flights
//	@PostMapping("/blockflights")
//	public String blockflights(@RequestBody Flight flight) {
//		airportService.blockFlights(flight);
//		return "Flight Blocked successfully";
//
//	}
//
//	@PostMapping("/unblockflights")
//	public String unblockflights(@RequestBody Flight flight) {
//		airportService.unblockFlights(flight);
//		return "Flight UnBlocked successfully";
		
	@PutMapping("/BlockFlight")
	public boolean blockFlight(@RequestBody  Flight flight,@PathVariable Long flightId) {
	return flightService.block(flight, flightId);

		}

	@PutMapping("/unblockFlight")
	public boolean unblockFlight(@RequestBody  Flight flight,@PathVariable Long flightId ) {
	return flightService.unblock(flight,flightId);
		}

	}


