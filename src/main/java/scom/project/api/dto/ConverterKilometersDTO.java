package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ConverterKilometersDTO {
	private String converterCode;
	private LocalDate converterDateKm;
	private Integer converterKm;
}
