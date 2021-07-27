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
public class ConverterShiftPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "CODIGO_POSICOES_CARRO")
	private String wagonPositionsDescription;
	
	@Column(name = "CODIGO_CONVERSOR")
	private String converterCode;
	
	@Column(name = "DATA_ENTRADA_CONVERSOR")
	private LocalDate converterDateIn;
	
	public ConverterShiftPK() {
	}
	
	public ConverterShiftPK(String trainCode, String wagonPositionsDescription, String converterCode, LocalDate converterDateIn) {
		this.trainCode = trainCode;
		this.wagonPositionsDescription = wagonPositionsDescription;
		this.converterCode = converterCode;
		this.converterDateIn = converterDateIn;
	}
}
