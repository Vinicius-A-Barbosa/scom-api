package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.EngineShiftPK;

@Entity
@Getter
@Setter
@Table(name = "MOVIMENTACOES_MOTOR")
public class EngineShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EngineShiftPK engineShiftPK;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_MOTOR", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntityIn;
	
	@Transient
	private Integer engineKmIn = engineKilometersEntityIn.getEngineKm();
	
	@Column(name = "DATA_SAIDA_MOTOR")
	private LocalDate engineDateOut;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_MOTOR", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntityOut;
	
	@Transient
	private Integer engineKmOut = engineKilometersEntityOut.getEngineKm();
	
	@Column(name = "KM_ACUMULADO_MOTOR")
	private Integer engineKmAccumulated;
	
	public void setEngineShiftPK(String bogieCode, String enginePositionsDescription, String engineCode, LocalDate engineDateIn) {
		this.engineShiftPK = new EngineShiftPK(bogieCode, enginePositionsDescription, engineCode, engineDateIn);
	}
}
