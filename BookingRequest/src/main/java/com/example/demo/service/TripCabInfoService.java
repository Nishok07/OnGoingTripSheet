package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.TripCabInfoRepository;

@Service(value ="tripCabInfoService")
public class TripCabInfoService {

	@Autowired
	private TripCabInfoRepository repository;
	
	public TripCabInfo saveTrip(TripCabInfo cabInfo) {
		
		return this.repository.save(cabInfo);
	}
	
	public TripCabInfo findByTripCabID(long tripCabID) {
		
		return this.repository.findByTripCabID(tripCabID);
	}
}
