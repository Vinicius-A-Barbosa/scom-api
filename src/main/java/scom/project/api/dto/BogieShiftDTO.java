package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BogieShiftDTO {
	private String trainCode;
	private String wagonPositionsDescription;
	private String bogiePositionsDescription;
	private String bogieCode;
	private LocalDate bogieDateIn;
	private Integer bogieKmIn;
	private LocalDate bogieDateOut;
	private Integer bogieKmOut;
	private Integer bogieKmAccumulated;
}
