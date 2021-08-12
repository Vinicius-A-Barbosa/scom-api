package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AxleActivitiesLubricationDTO {
	private String axleCode;
	private LocalDate axleDateLubrication;
	private Integer axleKmLubrication;
	private Integer axleKmSinceLastLubrication;
}
