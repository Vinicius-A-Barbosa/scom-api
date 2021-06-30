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
public class ConverterKilometersPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_CONVERSOR")
	private String converterCode;
	
	@Column(name = "DATA_KM_CONVERSOR")
	private LocalDate converterDateKm;
	
	public ConverterKilometersPK() {
	}
	
	public ConverterKilometersPK(String converterCode, LocalDate converterDateKm) {
		this.converterCode = converterCode;
		this.converterDateKm = converterDateKm;
	}
}
