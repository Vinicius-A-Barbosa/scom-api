package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BogieKilometersDTO {
	private String bogieCode;
	private LocalDate bogieDateKm;
	private Integer bogieKm;
}
