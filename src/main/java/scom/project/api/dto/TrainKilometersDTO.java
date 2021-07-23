package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TrainKilometersDTO {
	private String trainCode;
	private LocalDate trainDateKm;
	private Integer trainKm;
}
