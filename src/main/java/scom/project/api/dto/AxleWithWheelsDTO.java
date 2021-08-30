package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AxleWithWheelsDTO {
	private String axleCode;
	private String wheelPositionsDescription;	
	private String wheelCode;
}
