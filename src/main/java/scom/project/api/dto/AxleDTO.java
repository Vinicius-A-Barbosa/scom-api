package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AxleDTO {
	private String axleCode;
	private String axleAvailability;
	private String axleType;
	private String axleSerie;
}
