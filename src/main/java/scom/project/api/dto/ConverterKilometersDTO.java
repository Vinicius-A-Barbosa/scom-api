package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConverterKilometersDTO {
	private String converterCode;
	private LocalDate converterDateKm;
	private Integer converterKm;
}
