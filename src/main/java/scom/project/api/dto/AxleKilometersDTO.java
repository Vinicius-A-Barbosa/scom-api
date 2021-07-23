package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AxleKilometersDTO {
	private String axleCode;
	private LocalDate axleDateKm;
	private Integer axleKm;
}
