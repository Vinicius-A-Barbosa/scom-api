package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WheelShiftDTO {
	private String axleCode;
	private String wheelPositionsCode;
	private String wheelCode;
	private LocalDate wheelDateIn;
	private Integer wheelKmIn;
	private LocalDate wheelDateOut;
	private Integer wheelKmOut;
	private Integer wheelKmAccumulated;
}
