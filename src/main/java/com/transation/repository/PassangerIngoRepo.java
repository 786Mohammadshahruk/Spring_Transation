package com.transation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transation.entity.PassengerInfo;

public interface PassangerIngoRepo extends JpaRepository<PassengerInfo, Long>{

}
