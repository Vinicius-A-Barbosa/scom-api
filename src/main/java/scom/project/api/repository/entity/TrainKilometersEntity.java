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
import scom.project.api.repository.entity.pk.TrainKilometersPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "QUILOMETRAGEM_TREM")
public class TrainKilometersEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrainKilometersPK trainKilometersPK;
	
	@Column(name = "KM_TREM")
	private Integer trainKm;
	
	public TrainKilometersEntity() {
		this.trainKilometersPK = new TrainKilometersPK();
	}
	
	public void setTrainKilometersPK(String trainCode, LocalDate trainDateKm) {
		this.trainKilometersPK = new TrainKilometersPK(trainCode, trainDateKm);
	}
}
