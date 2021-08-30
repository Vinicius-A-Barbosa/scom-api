package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TrainWithConvertersDTO {
	private String trainCode;
	private String wagonPositionsDescription;
	private String converterCode;
}
