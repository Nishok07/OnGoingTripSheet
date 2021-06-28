package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BookingRequestBO;
import com.example.demo.entity.DriverBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.BookingRequestRepository;
import com.example.demo.repository.DriverRepository;
import com.example.demo.repository.TripCabInfoRepository;

@Service(value = "tripSheetService")
public class TripSheetService {

	@Autowired
	private BookingRequestRepository repository;
	
	@Autowired
	private TripCabInfoRepository cabRepo;
	
	@Autowired
	private DriverRepository driverRepo;
	
	public BookingRequestBO save(BookingRequestBO entity) {
		
		return this.repository.save(entity);
	}
	
	public List<BookingRequestBO> getTripSheet(int employeeID) {
		
		BookingRequestBO request = this.repository.findByEmployeeID(employeeID); // Returns the request details of an employee/user
		int tripCabID = request.getTripCabID(); // Get's the TripCabID of the employee
		return this.getAllTripSheet(tripCabID); 
	}
	
	public List<BookingRequestBO> getAllTripSheet(int tripCabID) {

		// Fetches all the requests of employees having the same TripCabID as the user
		List<BookingRequestBO> OngoingTripSheet = this.repository.findRequestByTripCabID(tripCabID); 
		TripCabInfo cabInfo = this.cabRepo.findByTripCabID(tripCabID); // Fetches the Cab details using TripCabID
		
		int driverID = cabInfo.getDriverID(); // Fetches the driverID of that particular trip
		DriverBO driverInfo = this.driverRepo.findByDriverID(driverID); // Fetches the driver details using driverID
		
		// Sets the cabDetails and driverDetails fetched using tripCabID and driverID
		for(BookingRequestBO request : OngoingTripSheet) {
			
			request.setDriverDetails(driverInfo);
			request.setCabDetails(cabInfo);
			
		}
		
		return OngoingTripSheet;
		
	}	
}
