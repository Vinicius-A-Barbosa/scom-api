package scom.project.api.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TrainWithBogiesDTO {
	private String trainCode;
	private String wagonPositionsDescription;
	private String bogiePositionsDescription;
	private String bogieCode;
	private List<BogieWithAxlesDTO> bogieWithAxlesList;
	private List<BogieWithEnginesDTO> bogieWithEnginesList;
}
