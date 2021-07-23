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
import scom.project.api.repository.entity.pk.AxleKilometersPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "QUILOMETRAGEM_EIXO")
public class AxleKilometersEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AxleKilometersPK axleKilometersPK;
	
	@Column(name = "KM_EIXO")
	private Integer axleKm;
	
	public void setAxleKilometersPK(String axleCode, LocalDate axleDateKm) {
		this.axleKilometersPK = new AxleKilometersPK(axleCode, axleDateKm);
	}
}
