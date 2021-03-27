package scom.project.api.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import scom.project.api.dto.TripsHistoryDTO;
import scom.project.api.service.TripsHistoryService;

@RestController
public class TripsHistoryController {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter().with(format);
	
	@Autowired
	private TripsHistoryService tripsHistoryService;
	
	@GetMapping("/tripsHistory/{tripId}")
	public ResponseEntity<String> getAllTrips(@PathVariable(value = "tripId") Integer tripId) {
		try {
			TripsHistoryDTO result = tripsHistoryService.findTripsDataById(tripId);
			return ResponseEntity.status(HttpStatus.OK).body(ow.writeValueAsString(result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
