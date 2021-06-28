package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entity.DriverBO;

public interface DriverRepository extends MongoRepository<DriverBO, Long> {

	DriverBO findByDriverID(long driverID);
}
