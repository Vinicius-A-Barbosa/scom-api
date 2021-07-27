package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ConverterDTO {
	private String converterCode;
	private String converterAvailability;
	private String converterSerie;
}
