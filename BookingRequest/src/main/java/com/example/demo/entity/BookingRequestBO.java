package com.example.demo.entity;

import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Document(collection = "BookingRequest")
public class BookingRequestBO {

	@Id
	long bookingID;
	int employeeID;
	String employeeName;
	String source;
	String destination;
	String dropPoint;
	LocalTime timeSlot;
	int tripCabID;
	LocalTime startTime;
	LocalTime reachedTime;
	String status;
	DriverBO driverDetails;
	TripCabInfo cabDetails;

	
	public BookingRequestBO(int employeeID, String employeeName, String source, String destination, String dropPoint,
			LocalTime timeSlot, int tripCabID) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.source = source;
		this.destination = destination;
		this.dropPoint = dropPoint;
		this.timeSlot = timeSlot;
		this.tripCabID = tripCabID;
	}
	
	
}
