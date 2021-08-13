package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EngineActivitiesCheckDTO {
	private String engineCode;
	private String engineCheckTypeCode;
	private LocalDate checkDateIn;
	private Integer checkKmIn;
	private LocalDate checkDateOut;
	private Integer checkKmOut;
	private String serviceOrderNumber;
	private LocalDate serviceOrderDateOpening;
	private LocalDate serviceOrderDateClosing;
	private Integer numberUnavailabilityDays;
	private Integer sinceLastCheckKm;
	private double insideOvalizationIn;
	private double insideOvalizationOut;
	private double outsideOvalizationIn;
	private double outsideOvalizationOut;
	private double commutatorDiameterIn;
	private double commutatorDiameterOut;
	private double micaDepthIn;
	private double micaDepthOut;
	private double resistenceIsolationCoilIn;
	private double resistenceIsolationCoilOut;
	private double resistenceBusIn;
	private double resistenceBusOut;
	private double resistenceInterpolesIn;
	private double resistenceInterpolesOut;
	private double resistenceArmorIn;
	private double resistenceArmorOut;
	private double resistenceOhmicCoilIn;
	private double resistenceOhmicCoilOut;
	private double resistenceInterpolesCoilIn;
	private double resistenceInterpolesCoilOut;
	private double resistenceContactOneIn;
	private double resistenceContactOneOut;
	private double resistenceContactTwoIn;
	private double resistenceContactTwoOut;
	private double impedanceSerieIn;
	private double impedanceSerieOut;
	private double impedanceInterpolesIn;
	private double impedanceInterpolesOut;
	private double voltageInducedIn;
	private double voltageInducedOut;
	private double maxVelocityIn;
	private double maxVelocityOut;
	private String brushTypeIn;
	private String brushTypeOut;
	private double springForceReferenceIn;
	private double springForceReferenceOut;
	private double axialClearanceIn;
	private double axialClearanceOut;
	private double gearAdherencePercentageIn;
	private double gearAdherencePercentageOut;
	private String engineMaintenanceType;
	private String descriptionSymptom;
	private String observation;
}
