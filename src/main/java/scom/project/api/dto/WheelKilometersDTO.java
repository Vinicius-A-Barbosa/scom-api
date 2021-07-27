package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class WheelKilometersDTO {
	private String wheelCode;
	private LocalDate wheelDateKm;
	private Integer wheelKm;
}
