package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EngineShiftDTO {
	private String bogieCode;
	private String enginePositionsDescription;
	private String engineCode;
	private LocalDate engineDateIn;
	private Integer engineKmIn;
	private LocalDate engineDateOut;
	private Integer engineKmOut;
	private Integer engineKmAccumulated;
}
