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
import scom.project.api.repository.entity.pk.AxleShiftPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "MOVIMENTACOES_EIXO")
public class AxleShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AxleShiftPK axleShiftPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_EIXO", referencedColumnName = "CODIGO_EIXO", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_EIXO", referencedColumnName = "DATA_KM_EIXO", insertable = false, updatable = false)
	})
	private AxleKilometersEntity axleKilometersEntityIn;
	
	@Transient
	private Integer axleKmIn;
	
	@Column(name = "DATA_SAIDA_EIXO")
	private LocalDate axleDateOut;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_EIXO", referencedColumnName = "CODIGO_EIXO", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_EIXO", referencedColumnName = "DATA_KM_EIXO", insertable = false, updatable = false)
	})
	private AxleKilometersEntity axleKilometersEntityOut;
	
	@Transient
	private Integer axleKmOut;
	
	@Column(name = "KM_ACUMULADO_EIXO")
	private Integer axleKmAccumulated;
	
	public AxleShiftEntity() {
		this.axleShiftPK = new AxleShiftPK();
	}
	
	public void setAxleShiftPK(String bogieCode, String axlePositionsDescription, String axleCode, LocalDate axleDateIn) {
		this.axleShiftPK = new AxleShiftPK(bogieCode, axlePositionsDescription, axleCode, axleDateIn);
	}
	
	@PostLoad
	private void setKms() {
		axleKmIn = axleKilometersEntityIn != null ? axleKilometersEntityIn.getAxleKm() : null;
		axleKmOut = axleKilometersEntityOut != null ? axleKilometersEntityOut.getAxleKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		axleKilometersEntityIn = new AxleKilometersEntity();
		axleKilometersEntityIn.getAxleKilometersPK()
			.setAxleCode(axleShiftPK.getAxleCode());
		axleKilometersEntityIn.getAxleKilometersPK()
			.setAxleDateKm(axleShiftPK.getAxleDateIn());
		axleKilometersEntityIn.setAxleKm(axleKmIn);
		
		axleKilometersEntityOut = new AxleKilometersEntity();
		axleKilometersEntityOut.getAxleKilometersPK()
			.setAxleCode(axleShiftPK.getAxleCode());
		axleKilometersEntityOut.getAxleKilometersPK()
			.setAxleDateKm(axleDateOut);
		axleKilometersEntityOut.setAxleKm(axleKmOut);
	}
}
