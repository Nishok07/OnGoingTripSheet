package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.entity.BookingRequestBO;
import com.example.demo.entity.DriverBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.BookingRequestRepository;
import com.example.demo.repository.DriverRepository;
import com.example.demo.repository.TripCabInfoRepository;

@SpringBootApplication
public class BookingRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingRequestApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			BookingRequestRepository repository;
			
			@Autowired
			TripCabInfoRepository cabRepo;
			
			@Autowired
			DriverRepository driverRepo;
			
			@Override
			public void run(String... args) throws Exception {
				
			repository.save(new BookingRequestBO(1, 263, "Nishok Thulasimani", "Alpha City", "Velachery", "Velachery",
					 LocalTime.now(), 7, LocalTime.of(8, 0), LocalTime.of(9, 0), "Reached", new DriverBO(), new TripCabInfo()));
			
			cabRepo.save(new TripCabInfo(10, "TNXXXXXX", 1, "Alpha City", "Velachery", "Velachery", LocalDate.now(), LocalTime.now(), 10, 3, 7, "Not Reached", LocalTime.of(8, 0), LocalTime.of(9, 0)));
			
			driverRepo.save(new DriverBO(1, "Ravi", 12345678, "Ravi", 1234, LocalDate.of(2025, 1, 1)));
			
			}
		};
	}
}
