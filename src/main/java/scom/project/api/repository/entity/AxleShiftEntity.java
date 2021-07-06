package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.AxleShiftPK;

@Entity
@Getter
@Setter
@Table(name = "MOVIMENTACOES_EIXO")
public class AxleShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AxleShiftPK axleShiftPK;
	
	@JoinColumns({
		@JoinColumn(name = "CODIGO_EIXO", referencedColumnName = "CODIGO_EIXO", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_EIXO", referencedColumnName = "DATA_KM_EIXO", insertable = false, updatable = false)
	})
	private AxleKilometersEntity AxleKilometersEntityIn;
	
	@Transient
	private Integer axleKmIn = AxleKilometersEntityIn.getAxleKm();
	
	@Column(name = "DATA_SAIDA_EIXO")
	private LocalDate axleDateOut;
	
	@JoinColumns({
		@JoinColumn(name = "CODIGO_EIXO", referencedColumnName = "CODIGO_EIXO", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_EIXO", referencedColumnName = "DATA_KM_EIXO", insertable = false, updatable = false)
	})
	private AxleKilometersEntity AxleKilometersEntityOut;
	
	@Transient
	private Integer axleKmOut = AxleKilometersEntityOut.getAxleKm();
	
	@Column(name = "KM_ACUMULADO_EIXO")
	private Integer axleKmAccumulated;
	
	public void setAxleShiftPK(String bogieCode, String axlePositionsDescription, String axleCode, LocalDate axleDateIn) {
		this.axleShiftPK = new AxleShiftPK(bogieCode, axlePositionsDescription, axleCode, axleDateIn);
	}
}
