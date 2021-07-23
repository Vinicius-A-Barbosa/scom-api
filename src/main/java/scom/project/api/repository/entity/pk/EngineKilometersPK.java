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
public class EngineKilometersPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_MOTOR")
	private String engineCode;
	
	@Column(name = "DATA_KM_MOTOR")
	private LocalDate engineDateKm;
	
	public EngineKilometersPK() {
	}
	
	public EngineKilometersPK(String engineCode, LocalDate engineDateKm) {
		this.engineCode = engineCode;
		this.engineDateKm = engineDateKm;
	}
}
