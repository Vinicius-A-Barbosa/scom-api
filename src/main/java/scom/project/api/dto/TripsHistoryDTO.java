package scom.project.api.dto;

import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripsHistoryDTO {
	
	private Integer tripId;
	private List<LocalTime> tripTime;
	private List<Double> aceleration;
	private List<Double> position;
	private List<Double> torque;
	private List<Double> frequency;
	private List<Double> velocity;
	private List<Boolean> emergency;
	private List<Double> curve;
	private List<Double> inclination;
}
