package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class WheelDTO {
	private String wheelCode;
	private String wheelAvailability;
	private String wheelSerie;
}
