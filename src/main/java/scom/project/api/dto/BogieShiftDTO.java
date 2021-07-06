package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BogieShiftDTO {
	private String trainCode;
	private String wagonPositionsDescription;
	private String bogiePositionsDescription;
	private LocalDate bogieDateIn;
	private Integer bogieKmIn;
	private LocalDate bogieDateOut;
	private Integer bogieKmOut;
	private Integer bogieKmAccumulated;
}
