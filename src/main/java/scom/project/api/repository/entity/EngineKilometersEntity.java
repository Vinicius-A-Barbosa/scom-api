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
import scom.project.api.repository.entity.pk.EngineKilometersPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "QUILOMETRAGEM_MOTOR")
public class EngineKilometersEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EngineKilometersPK engineKilometersPK;
	
	@Column(name = "KM_MOTOR")
	private Integer engineKm;
	
	public void setEngineKilometersPK(String engineCode, LocalDate engineDateKm) {
		this.engineKilometersPK = new EngineKilometersPK(engineCode, engineDateKm);
	}
}
