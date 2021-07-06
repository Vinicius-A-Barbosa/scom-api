package scom.project.api.repository.entity.pk;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class EngineShiftPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "CODIGO_POSICOES_MOTOR")
	private String enginePositionsDescription;
	
	@Column(name = "CODIGO_MOTOR")
	private String engineCode;
	
	@Column(name = "DATA_ENTRADA_MOTOR")
	private LocalDate engineDateIn;
	
	public EngineShiftPK() {
	}
	
	public EngineShiftPK(String bogieCode, String enginePositionsDescription, String engineCode, LocalDate engineDateIn) {
		this.bogieCode = bogieCode;
		this.enginePositionsDescription = enginePositionsDescription;
		this.engineCode = engineCode;
		this.engineDateIn = engineDateIn;
	}
}
