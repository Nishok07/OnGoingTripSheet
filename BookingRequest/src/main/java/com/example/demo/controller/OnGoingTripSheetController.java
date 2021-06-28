package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bl.OnGoingTripSheetBL;
import com.example.demo.entity.BookingRequestBO;
import com.example.demo.repository.BookingRequestRepository;
import com.example.demo.service.TripSheetService;

@RestController
@RequestMapping(path="/api/v1/")
@CrossOrigin(origins = "*")
public class OnGoingTripSheetController {

	@Autowired
	private OnGoingTripSheetBL service;
	
	@Autowired
	private TripSheetService repoService;
	
	@Autowired
	private BookingRequestRepository repo;
	
	
	@PostMapping(path = "/requests")
	public BookingRequestBO addRequest(@RequestBody BookingRequestBO request) {
		request.setBookingID(repo.count() + 1);
		return this.repoService.save(request);
	}
	
	@GetMapping(path = "/requests/{employeeID}")
	public List<BookingRequestBO> getOnGoingTripSheet(@PathVariable("employeeID") int employeeID) {

		//Calls the getTripSheet() method of service layer
		return this.service.getOnGoingTripSheet(employeeID);
	}

}
