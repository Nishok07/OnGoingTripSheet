package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.TripCabInfoRepository;
import com.example.demo.service.TripCabInfoService;

@RestController
@RequestMapping(path = "/api/v1/")
public class TripCabInfoController {

	@Autowired
	private TripCabInfoService service;
	
	@Autowired
	private TripCabInfoRepository repository;
	
	@PostMapping(path = "/post/cabInfo")
	public TripCabInfo addCabInfo(TripCabInfo cabInfo) {
		
		cabInfo.setTripCabID(repository.count() + 1);
		return this.service.saveTrip(cabInfo);
	}
	
	@GetMapping(path = "/cabInfo/{tripCabID}")
	public TripCabInfo getCabInfoByID(@PathVariable("tripCabID") long tripCabID) {
		
		return this.service.findByTripCabID(tripCabID);
	}
}
