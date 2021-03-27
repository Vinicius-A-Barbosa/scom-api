package scom.project.api.dto;


import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripsDTO {
	private Integer tripId;
	private String departureStation;
	private String arrivalStation;
	private String trainId;
	private LocalDate initialTripsDate;
	private LocalDate finalTripsDate;
	private LocalTime initialTripsTime;
	private LocalTime finalTripsTime;
}
