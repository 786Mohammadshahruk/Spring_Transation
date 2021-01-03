package com.transation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transation.dto.FlightBookingAcknoledgement;
import com.transation.dto.FlightBookingRequest;
import com.transation.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransationApplication {
	
	private FlightBookingService flightBookingService;
	
	@PostMapping("/bookFlightTicket")	
	public FlightBookingAcknoledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(TransationApplication.class, args);
	}

}
