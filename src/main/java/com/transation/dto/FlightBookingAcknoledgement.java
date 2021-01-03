package com.transation.dto;

import com.transation.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknoledgement {
	
	private String status;
	private double totalfare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
	public FlightBookingAcknoledgement(String status, double totalfare, String pnrNo, PassengerInfo passengerInfo) {
		super();
		this.status = status;
		this.totalfare = totalfare;
		this.pnrNo = pnrNo;
		this.passengerInfo = passengerInfo;
	}
	

}
