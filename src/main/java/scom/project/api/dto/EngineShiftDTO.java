package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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