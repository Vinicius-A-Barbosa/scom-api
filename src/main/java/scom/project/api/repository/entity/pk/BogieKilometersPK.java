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
public class BogieKilometersPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "DATA_KM_TRUQUE")
	private LocalDate bogieDateKm;
	
	public BogieKilometersPK() {
	}
	
	public BogieKilometersPK(String bogieCode, LocalDate bogieDateKm) {
		this.bogieCode = bogieCode;
		this.bogieDateKm = bogieDateKm;
	}
}
