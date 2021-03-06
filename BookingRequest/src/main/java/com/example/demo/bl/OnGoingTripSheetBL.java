package com.example.demo.bl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.entity.BookingRequestBO;
import com.example.demo.service.TripSheetService;

@Component
public class OnGoingTripSheetBL {

	@Autowired
	private TripSheetService service;
	
	public List<BookingRequestBO> getOnGoingTripSheet(int employeeID) {
		
		return this.service.getTripSheet(employeeID);
	}
}
