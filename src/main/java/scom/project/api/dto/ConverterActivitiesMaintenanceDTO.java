package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ConverterActivitiesMaintenanceDTO {
	private String converterCode;
	private LocalDate converterDateMaintenance;
	private Integer converterKmMaintenance;
	private double lengthBrushRightInside;
	private double lengthBrushRightOutside;
	private double lengthBrushLeftInside;
	private double lengthBrushLeftOutside;
	private double averageLengthBrush;
	private double pressureSpringRightInside;
	private double pressureSpringRightOutside;
	private double pressureSpringLeftInside;
	private double pressureSpringLeftOutside;
	private Integer ovalization;
	private double wear;
	private double pressure;
	private String maintenanceType;
	private String comments;
	private double hourmeter;
}
