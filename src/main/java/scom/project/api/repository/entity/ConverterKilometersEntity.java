package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.ConverterKilometersPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "QUILOMETRAGEM_CONVERSOR")
public class ConverterKilometersEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ConverterKilometersPK converterKilometersPK;
	
	@Column(name = "KM_CONVERSOR")
	private Integer converterKm;
	
	public ConverterKilometersEntity() {
		this.converterKilometersPK = new ConverterKilometersPK();
	}
	
	public void setConverterKilometersPK(String converterCode, LocalDate converterDateKm) {
		this.converterKilometersPK = new ConverterKilometersPK(converterCode, converterDateKm);
	}
}
