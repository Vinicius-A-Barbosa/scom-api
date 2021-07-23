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
public class ConverterActivitiesCheckPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_CONVERSOR")
	public String converterCode;
	@Column(name = "CODIGO_TIPO_ENSAIO_CONVERSOR")
	public String converterCheckTypeCode;
	@Column(name = "DATA_ENSAIO_ENTRADA")
	public LocalDate checkDateIn;
	
	public ConverterActivitiesCheckPK(String converterCode, String converterCheckTypeCode, LocalDate checkDateIn) {
		this.converterCode = converterCode;
		this.converterCheckTypeCode = converterCheckTypeCode;
		this.checkDateIn = checkDateIn;
	}
	
}
