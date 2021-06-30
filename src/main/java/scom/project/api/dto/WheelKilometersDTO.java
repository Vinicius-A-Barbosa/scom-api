package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WheelKilometersDTO {
	private String wheelCode;
	private LocalDate wheelDateKm;
	private Integer wheelKm;
}
