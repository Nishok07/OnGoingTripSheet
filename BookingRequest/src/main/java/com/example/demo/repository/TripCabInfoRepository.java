package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entity.TripCabInfo;

public interface TripCabInfoRepository extends MongoRepository<TripCabInfo, Long> {

	TripCabInfo findByTripCabID(long tripCabID);
}
