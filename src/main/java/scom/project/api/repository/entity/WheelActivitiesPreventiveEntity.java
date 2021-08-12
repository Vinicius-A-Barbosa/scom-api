package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "ATIVIDADES_PREVENTIVA_RODA")
public class WheelActivitiesPreventiveEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_RODA")
	private String wheelCode;
	
	@Column(name = "DATA_PREVENTIVA_RODA_FRISO_ARO")
	private LocalDate preventiveDateFlangeRim;
	
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_PREVENTIVA_RODA_FRISO_ARO", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntityFlangeRim;
	
	@Transient
	private Integer preventiveKmFlangeRim;
	
	@Column(name = "ESPESSURA_FRISO_POLEGADA")
	private String thicknessFlangeInch;
	
	@Column(name = "ALTURA_FRISO_POLEGADA")
	private String heightFlangeInch;
	
	@Column(name = "ESPESSURA_ARO_POLEGADA")
	private String thicknessRimInch;
	
	@Column(name = "DATA_PREVENTIVA_RODA_SUPERFICIE_ROLAMENTO")
	private LocalDate preventiveDateBearingSurface;
	
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_PREVENTIVA_RODA_SUPERFICIE_ROLAMENTO", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntityBearingSurface;
	
	@Transient
	private Integer preventiveKmBearingSurface = wheelKilometersEntityBearingSurface.getWheelKm();
	
	@Column(name = "SUPERFICIE_ROLAMENTO")
	private String bearingSurface;
	
	public WheelActivitiesPreventiveEntity() {
	}
	
	@PostLoad
	private void setKms() {
		preventiveKmFlangeRim = wheelKilometersEntityFlangeRim != null ? wheelKilometersEntityFlangeRim.getWheelKm() : null;
		preventiveKmBearingSurface = wheelKilometersEntityBearingSurface != null ? wheelKilometersEntityBearingSurface.getWheelKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		wheelKilometersEntityFlangeRim = new WheelKilometersEntity();
		wheelKilometersEntityFlangeRim.getWheelKilometersPK()
			.setWheelCode(wheelCode);
		wheelKilometersEntityFlangeRim.getWheelKilometersPK()
			.setWheelDateKm(preventiveDateFlangeRim);
		wheelKilometersEntityFlangeRim.setWheelKm(preventiveKmFlangeRim);
		
		wheelKilometersEntityBearingSurface = new WheelKilometersEntity();
		wheelKilometersEntityBearingSurface.getWheelKilometersPK()
			.setWheelCode(wheelCode);
		wheelKilometersEntityBearingSurface.getWheelKilometersPK()
			.setWheelDateKm(preventiveDateBearingSurface);
		wheelKilometersEntityBearingSurface.setWheelKm(preventiveKmBearingSurface);
	}
}
