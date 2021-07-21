package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AxleActivitiesLubricationDTO {
	private String axleCode;
	private LocalDate axcelDateLubrication;
	private Integer axcelKmLubrication;
	private Integer axcelKmSinceLastLubrication;
}
