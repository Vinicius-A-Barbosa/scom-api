package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainKilometersDTO {
	private String trainCode;
	private LocalDate trainDateKm;
	private Integer trainKm;
}
