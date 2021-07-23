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
	
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_RODA", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntityIn;
	
	@Transient
	private Integer wheelKmIn = wheelKilometersEntityIn.getWheelKm();
	
	@Column(name = "DATA_SAIDA_RODA")
	private LocalDate wheelDateOut;
	
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_RODA", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntityOut;
	
	@Transient
	private Integer wheelKmOut = wheelKilometersEntityOut.getWheelKm();
	
	@Column(name = "KM_ACUMULADO_RODA")
	private Integer wheelKmAccumulated;
	
	public void setWheelShiftPK(String axleCode, String wheelPositionsCode, String wheelCode, LocalDate wheelDateIn) {
		this.wheelShiftPK = new WheelShiftPK(axleCode, wheelPositionsCode, wheelCode, wheelDateIn);
	}
}
