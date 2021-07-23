package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EngineDTO {
	private String engineCode;
	private String engineAvailability;
	private String engineSerie;
}
