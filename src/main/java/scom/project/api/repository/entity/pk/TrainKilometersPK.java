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
public class TrainKilometersPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "DATA_KM_TREM")
	private LocalDate trainDateKm;
	
	public TrainKilometersPK() {
	}
	
	public TrainKilometersPK(String trainCode, LocalDate trainDateKm) {
		this.trainCode = trainCode;
		this.trainDateKm = trainDateKm;
	}
}
