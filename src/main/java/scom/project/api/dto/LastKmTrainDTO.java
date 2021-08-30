package scom.project.api.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class LastKmTrainDTO {
	private String trainCode;
	private String trainAvailability;
	private String trainSerie;
	private LocalDate trainDateKm;
	private Integer trainKm;
	private List<TrainWithBogiesDTO> trainWithBogiesList;
	private List<TrainWithConvertersDTO> trainWithConvertersList;
}
