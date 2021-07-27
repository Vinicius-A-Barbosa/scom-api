package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ConverterShiftDTO {
	private String trainCode;
	private String wagonPositionsDescription;
	private String converterCode;
	private LocalDate converterDateIn;
	private Integer converterKmIn;
	private LocalDate converterDateOut;
	private Integer converterKmOut;
	private Integer converterKmAccumulated;
}
