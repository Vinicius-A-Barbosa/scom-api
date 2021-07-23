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
public class WheelKilometersPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_RODA")
	private String wheelCode;
	
	@Column(name = "DATA_KM_RODA")
	private LocalDate wheelDateKm;
	
	public WheelKilometersPK() {
	}
	
	public WheelKilometersPK(String wheelCode, LocalDate wheelDateKm) {
		this.wheelCode = wheelCode;
		this.wheelDateKm = wheelDateKm;
	}
}
