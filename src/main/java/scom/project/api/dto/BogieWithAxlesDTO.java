package scom.project.api.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BogieWithAxlesDTO {
	private String bogieCode;
	private String axlePositionsDescription;
	private String axleCode;
	private List<AxleWithWheelsDTO> axleWithWheelsList;
}
