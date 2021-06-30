package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineKilometersDTO {
	private String engineCode;
	private LocalDate engineDateKm;
	private Integer engineKm;
}
