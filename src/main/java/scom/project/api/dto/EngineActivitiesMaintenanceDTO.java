package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineActivitiesMaintenanceDTO {
	private String engineCode;
	private LocalDate engineDateMaintenance;
	private Integer engineKmMaintenance;
	private double lengthBrushOneInside;
	private double lengthBrushOneOutside;
	private double lengthBrushTwoInside;
	private double lengthBrushTwoOutside;
	private double lengthBrushThreeInside;
	private double lengthBrushThreeOutside;
	private double lengthBrushFourInside;
	private double lengthBrushFourOutside;
	private double averageLengthBrush;
	private double pressureSpringBrushOneInside;
	private double pressureSpringBrushOneOutside;
	private double pressureSpringBrushTwoInside;
	private double pressureSpringBrushTwoOutside;
	private double pressureSpringBrushThreeInside;
	private double pressureSpringBrushThreeOutside;
	private double pressureSpringBrushFourInside;
	private double pressureSpringBrushFourOutside;
	private Integer ovalization;
	private double wear;
	private double pressure;
	private String maintenanceType;
	private String comments;
}
