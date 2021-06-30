package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.WheelKilometersPK;

@Entity
@Getter
@Setter
@Table(name = "QUILOMETRAGEM_RODA")
public class WheelKilometersEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WheelKilometersPK wheelKilometersPK;
	
	@Column(name = "KM_RODA")
	private Integer wheelKm;
	
	public void setWheelKilometersPK(String wheelCode, LocalDate wheelDateKm) {
		this.wheelKilometersPK = new WheelKilometersPK(wheelCode, wheelDateKm);
	}
}
