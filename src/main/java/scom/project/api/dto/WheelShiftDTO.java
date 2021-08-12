package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class WheelShiftDTO {
	private String axleCode;
	private String wheelPositionsDescription;
	private String wheelCode;
	private LocalDate wheelDateIn;
	private Integer wheelKmIn;
	private LocalDate wheelDateOut;
	private Integer wheelKmOut;
	private Integer wheelKmAccumulated;
}
