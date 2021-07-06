package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AxleShiftDTO {
	private String bogieCode;
	private String axlePositionsDescription;
	private String axleCode;
	private LocalDate axleDateIn;
	private Integer axleKmIn;
	private LocalDate axleDateOut;
	private Integer axleKmOut;
	private Integer axleKmAccumulated;
}
