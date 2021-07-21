package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WheelActivitiesPreventiveDTO {
	private String wheelCode;
	private LocalDate preventiveDateFlangeRim;
	private Integer preventiveKmFlangeRim;
	private String thicknessFlangeInch;
	private String heightFlangeInch;
	private String thicknessRimInch;
	private LocalDate preventiveDateBearingSurface;
	private Integer preventiveKmBearingSurface;
	private String bearingSurface;
}
