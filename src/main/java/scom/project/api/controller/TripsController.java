package scom.project.api.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import scom.project.api.dto.TripsDTO;
import scom.project.api.service.TripsService;

@RestController
public class TripsController {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter().with(format);
	
	@Autowired
	private TripsService tripsService;
	
	@GetMapping("/trips/all")
	public ResponseEntity<String> getAllTrips() {
		try {
			List<TripsDTO> result = tripsService.findAllTrips();
			return ResponseEntity.status(HttpStatus.OK).body(ow.writeValueAsString(result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
