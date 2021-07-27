package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BogieDTO {
	private String bogieCode;
	private String bogieAvailability;
	private String bogieType;
	private String bogieSerie;
}
