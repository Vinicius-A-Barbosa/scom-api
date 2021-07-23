package scom.project.api.repository.entity.pk;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class WheelShiftPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_EIXO")
	private String axleCode;
	
	@Column(name = "CODIGO_POSICOES_RODA")
	private String wheelPositionsDescription;
	
	@Column(name = "CODIGO_RODA")
	private String wheelCode;
	
	@Column(name = "DATA_ENTRADA_RODA")
	private LocalDate wheelDateIn;
	
	public WheelShiftPK() {
	}
	
	public WheelShiftPK(String axleCode, String wheelPositionsDescription, String wheelCode, LocalDate wheelDateIn) {
		this.axleCode = axleCode;
		this.wheelPositionsDescription = wheelPositionsDescription;
		this.wheelCode = wheelCode;
		this.wheelDateIn = wheelDateIn;
	}
}
