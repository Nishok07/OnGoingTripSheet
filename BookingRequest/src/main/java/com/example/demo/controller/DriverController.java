package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.DriverBO;
import com.example.demo.repository.DriverRepository;
import com.example.demo.service.DriverService;

@RestController
@RequestMapping(path = "/api/v1/")
public class DriverController {

	@Autowired
	private DriverService service;
	
	@Autowired
	private DriverRepository repository;
	
	@PostMapping(path = "/post/driver")
	public DriverBO addDriverInfo(@RequestBody DriverBO driverInfo) {
		
		driverInfo.setDriverID(repository.count() + 1);
		return this.service.saveDriverInfo(driverInfo);
	}
	
	@GetMapping(path = "/driver/{driverID}")
	public DriverBO getDriverInfoByID(@PathVariable("driverID") long driverID) {
		
		return this.service.getDriverInfoByID(driverID);
	}
}
