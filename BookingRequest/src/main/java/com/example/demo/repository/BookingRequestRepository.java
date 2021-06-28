package com.example.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.demo.entity.BookingRequestBO;

public interface BookingRequestRepository extends MongoRepository<BookingRequestBO, Long> {

	@Query(value = "{employeeID : ?0 , status:{$nin : [Reached, No Show, Cancelled]}}")
	// Fetches all the employee's requests where status is not equal to any of the values defined in the query array
	BookingRequestBO findByEmployeeID(int employeeID); 
	
	@Query(value = "{tripCabID : ?0, status:{$nin : [Reached, No Show, Cancelled]}}")
	// Fetches all the requests of employees having same tripCabID as the user
	List<BookingRequestBO> findRequestByTripCabID(int tripCabID);
}
