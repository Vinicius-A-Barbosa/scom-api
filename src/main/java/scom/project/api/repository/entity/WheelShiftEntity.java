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
import scom.project.api.repository.entity.pk.WheelShiftPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "MOVIMENTACOES_RODA")
public class WheelShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WheelShiftPK wheelShiftPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_RODA", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntityIn;
	
	@Transient
	private Integer wheelKmIn;
	
	@Column(name = "DATA_SAIDA_RODA")
	private LocalDate wheelDateOut;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_RODA", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntityOut;
	
	@Transient
	private Integer wheelKmOut;
	
	@Column(name = "KM_ACUMULADO_RODA")
	private Integer wheelKmAccumulated;
	
	public WheelShiftEntity() {
		this.wheelShiftPK = new WheelShiftPK();
	}
	
	public void setWheelShiftPK(String axleCode, String wheelPositionsCode, String wheelCode, LocalDate wheelDateIn) {
		this.wheelShiftPK = new WheelShiftPK(axleCode, wheelPositionsCode, wheelCode, wheelDateIn);
	}
	
	@PostLoad
	private void setKms() {
		wheelKmIn = wheelKilometersEntityIn != null ? wheelKilometersEntityIn.getWheelKm() : null;
		wheelKmOut = wheelKilometersEntityOut != null ? wheelKilometersEntityOut.getWheelKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		wheelKilometersEntityIn = new WheelKilometersEntity();
		wheelKilometersEntityIn.getWheelKilometersPK()
			.setWheelCode(wheelShiftPK.getWheelCode());
		wheelKilometersEntityIn.getWheelKilometersPK()
			.setWheelDateKm(wheelShiftPK.getWheelDateIn());
		wheelKilometersEntityIn.setWheelKm(wheelKmIn);
		
		wheelKilometersEntityOut = new WheelKilometersEntity();
		wheelKilometersEntityOut.getWheelKilometersPK()
			.setWheelCode(wheelShiftPK.getWheelCode());
		wheelKilometersEntityOut.getWheelKilometersPK()
			.setWheelDateKm(wheelDateOut);
		wheelKilometersEntityOut.setWheelKm(wheelKmOut);
	}
}
