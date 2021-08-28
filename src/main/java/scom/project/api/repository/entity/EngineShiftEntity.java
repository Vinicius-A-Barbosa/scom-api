package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.EngineShiftPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "MOVIMENTACOES_MOTOR")
public class EngineShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EngineShiftPK engineShiftPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_MOTOR", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntityIn;
	
	@Transient
	private Integer engineKmIn;
	
	@Column(name = "DATA_SAIDA_MOTOR")
	private LocalDate engineDateOut;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_MOTOR", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntityOut;
	
	@Transient
	private Integer engineKmOut;
	
	@Column(name = "KM_ACUMULADO_MOTOR")
	private Integer engineKmAccumulated;
	
	public EngineShiftEntity() {
		this.engineShiftPK = new EngineShiftPK();
	}
	
	public void setEngineShiftPK(String bogieCode, String enginePositionsDescription, String engineCode, LocalDate engineDateIn) {
		this.engineShiftPK = new EngineShiftPK(bogieCode, enginePositionsDescription, engineCode, engineDateIn);
	}
	
	@PostLoad
	private void setKms() {
		engineKmIn = engineKilometersEntityIn != null ? engineKilometersEntityIn.getEngineKm() : null;
		engineKmOut = engineKilometersEntityOut != null ? engineKilometersEntityOut.getEngineKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		engineKilometersEntityIn = new EngineKilometersEntity();
		engineKilometersEntityIn.getEngineKilometersPK()
			.setEngineCode(engineShiftPK.getEngineCode());
		engineKilometersEntityIn.getEngineKilometersPK()
			.setEngineDateKm(engineShiftPK.getEngineDateIn());
		engineKilometersEntityIn.setEngineKm(engineKmIn);
		
		engineKilometersEntityOut = new EngineKilometersEntity();
		engineKilometersEntityOut.getEngineKilometersPK()
			.setEngineCode(engineShiftPK.getEngineCode());
		engineKilometersEntityOut.getEngineKilometersPK()
			.setEngineDateKm(engineDateOut);
		engineKilometersEntityOut.setEngineKm(engineKmOut);
	}
}
