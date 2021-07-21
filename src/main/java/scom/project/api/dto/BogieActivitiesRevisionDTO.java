package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BogieActivitiesRevisionDTO {
	private String bogieCode;
	private LocalDate bogieDateRevision;
	private Integer bogieKmRevision;
	private Integer sinceLastRevisionKm;
}
