package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TrainDTO {
	private String trainCode;
	private String trainAvailability;
	private String trainSerie;
}
