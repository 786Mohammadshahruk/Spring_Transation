package com.transation.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transation.dto.FlightBookingAcknoledgement;
import com.transation.dto.FlightBookingRequest;
import com.transation.entity.PassengerInfo;
import com.transation.entity.PaymentInfo;
import com.transation.repository.PassangerIngoRepo;
import com.transation.repository.PaymentInfoRepo;
import com.transation.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassangerIngoRepo passangerInfoRepo;

	@Autowired
	private PaymentInfoRepo paymentInfoRepo;
	
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public FlightBookingAcknoledgement bookFlightTicket(FlightBookingRequest request) {
		// FlightBookingAcknoledgement flightBookingAcknoledgement=null;
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passangerInfoRepo.save(passengerInfo);

		PaymentInfo paymentInfo = request.getPaymentInfo();
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNumber(), passengerInfo.getFare());

		paymentInfo.setPassengerId(passengerInfo.getpId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepo.save(paymentInfo);
		return new FlightBookingAcknoledgement("SUCCESS", passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}

}
