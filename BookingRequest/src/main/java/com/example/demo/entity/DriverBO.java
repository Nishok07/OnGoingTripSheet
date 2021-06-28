package com.example.demo.entity;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Driver")
public class DriverBO {

	@Id
	long driverID;
	String driverName;
	long driverNumber;
	String password;
	int licenseNumber;
	LocalDate expiryDate;
}
