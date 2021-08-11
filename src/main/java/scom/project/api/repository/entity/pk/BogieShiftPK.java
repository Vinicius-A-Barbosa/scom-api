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
public class BogieShiftPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "CODIGO_POSICOES_CARRO")
	private String wagonPositionsDescription;
	
	@Column(name = "CODIGO_POSICOES_TRUQUE")
	private String bogiePositionsDescription;
	
	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "DATA_ENTRADA_TRUQUE")
	private LocalDate bogieDateIn;
	
	public BogieShiftPK() {
	}
	
	public BogieShiftPK(String trainCode, String wagonPositionsDescription, String bogiePositionsDescription, String bogieCode, LocalDate bogieDateIn) {
		this.trainCode = trainCode;
		this.wagonPositionsDescription = wagonPositionsDescription;
		this.bogiePositionsDescription = bogiePositionsDescription;
		this.bogieCode = bogieCode;
		this.bogieDateIn = bogieDateIn;
	}
}
