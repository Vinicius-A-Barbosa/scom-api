package scom.project.api.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ConverterActivitiesCheckDTO {
	private String converterCode;
	private String converterCheckTypeCode;
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
	private double resistenceArmorWindingIn;
	private double resistenceArmorWindingOut;
	private double resistenceIsolationShuntIn;
	private double resistenceIsolationShuntOut;
	private double resistenceSeparateIn;
	private double resistenceSeparateOut;
	private double resistenceStatorIn;
	private double resistenceStatorOut;
	private double resistenceRotorIn;
	private double resistenceRotorOut;
	private double resistenceVoltageControllerIn;
	private double resistenceVoltageControllerOut;
	private double resistenceVoltageGenaratorIn;
	private double resistenceVoltageGenaratorOut;
	private double resistenceRotorExciterIn;
	private double resistenceRotorExciterOut;
	private double maxResistenceContactIn;
	private double maxResistenceContactOut;
	private double maxResistenceShuntIn;
	private double maxResistenceShuntOut;
	private double maxResistenceSeparateIn;
	private double maxResistenceSeparateOut;
	private double maxResistenceStatorIn;
	private double maxResistenceStatorOut;
	private double resistenceOhmicAlternatorIn;
	private double resistenceOhmicAlternatorOut;
	private double resistenceOhmicInverterIn;
	private double resistenceOhmicInverterOut;
	private double resistenceOhmicLeadingIn;
	private double resistenceOhmicLeadingOut;
	private double resistenceOhmicRotorIn;
	private double resistenceOhmicRotorOut;
	private double valueDiodeConductionIn;
	private double valueDiodeConductionOut;
	private double valueDiodeIsolationIn;
	private double valueDiodeIsolationOut;
	private double voltageWithoutPolarizationIn;
	private double voltageWithoutPolarizationOut;
	private double voltageReversePolarizationIn;
	private double voltageReversePolarizationOut;
	private double voltageDirectPolarizationIn;
	private double voltageDirectPolarizationOut;
	private Boolean balancePhasesIn;
	private Boolean balancePhasesOut;
	private double maxVelocityIn;
	private double maxVelocityOut;
	private String brushTypeIn;
	private String brushTypeOut;
	private double springForceReferenceIn;
	private double springForceReferenceOut;
	private double magnetForceIn;
	private double magnetForceOut;
	private String converterMaintenanceType;
	private String descriptionSymptom;
	private String observation;
}
