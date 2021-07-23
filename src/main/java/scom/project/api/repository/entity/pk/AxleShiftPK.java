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
public class AxleShiftPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "CODIGO_POSICOES_EIXO")
	private String axlePositionsDescription;
	
	@Column(name = "CODIGO_EIXO")
	private String axleCode;
	
	@Column(name = "DATA_ENTRADA_EIXO")
	private LocalDate axleDateIn;
	
	public AxleShiftPK() {
	}
	
	public AxleShiftPK(String bogieCode, String axlePositionsDescription, String axleCode, LocalDate axleDateIn) {
		this.bogieCode = bogieCode;
		this.axlePositionsDescription = axlePositionsDescription;
		this.axleCode = axleCode;
		this.axleDateIn = axleDateIn;
	}
}
