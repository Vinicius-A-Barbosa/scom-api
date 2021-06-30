package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.BogieKilometersPK;

@Entity
@Getter
@Setter
@Table(name = "QUILOMETRAGEM_TRUQUE")
public class BogieKilometersEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BogieKilometersPK bogieKilometersPK;
	
	@Column(name = "KM_TRUQUE")
	private Integer bogieKm;
	
	public void setBogieKilometersPK(String bogieCode, LocalDate bogieDateKm) {
		this.bogieKilometersPK = new BogieKilometersPK(bogieCode, bogieDateKm);
	}
}
