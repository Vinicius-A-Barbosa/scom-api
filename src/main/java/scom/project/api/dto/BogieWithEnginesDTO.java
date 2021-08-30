package scom.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BogieWithEnginesDTO {
	private String bogieCode;
	private String enginePositionsDescription;
	private String engineCode;
}
