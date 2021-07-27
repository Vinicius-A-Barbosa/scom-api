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
public class AxleKilometersPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_EIXO")
	private String axleCode;
	
	@Column(name = "DATA_KM_EIXO")
	private LocalDate axleDateKm;
	
	public AxleKilometersPK() {
	}
	
	public AxleKilometersPK(String axleCode, LocalDate axleDateKm) {
		this.axleCode = axleCode;
		this.axleDateKm = axleDateKm;
	}
}
