package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DriverBO;
import com.example.demo.repository.DriverRepository;

@Service(value = "driverService")
public class DriverService {

	@Autowired
	private DriverRepository repository;
	
	public DriverBO saveDriverInfo(DriverBO driverInfo) {
		
		return this.repository.save(driverInfo);
	}
	
	public DriverBO getDriverInfoByID(long driverID) {
		
		return this.repository.findByDriverID(driverID);
	}
}
