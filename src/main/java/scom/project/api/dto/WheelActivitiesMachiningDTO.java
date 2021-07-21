package scom.project.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WheelActivitiesMachiningDTO {
	private String wheelCode;
	private LocalDate wheelDateMachining;
	private Integer wheelKmMachining;
	private Integer sinceLastMachiningKm;
	private double diameterWheelInLathe;
	private double diameterWheelAfterMachining;
	private double lostDiameterWheelInMachining;
	private double wearDiameterInTime;
	private double thicknessFlangeInLathe;
	private double thicknessFlangeAfterMachining;
	private double lostFlangeInMachining;
	private double wearFlangeInTime;
}
