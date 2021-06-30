package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BogieKilometersDTO {
	private String bogieCode;
	private LocalDate bogieDateKm;
	private Integer bogieKm;
}
