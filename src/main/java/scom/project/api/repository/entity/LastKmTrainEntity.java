package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "ULTIMO_KM_TREM")
public class LastKmTrainEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "DISPONIBILIDADE_TREM")
	private String trainAvailability;
	
	@Column(name = "SERIE_TREM")
	private String trainSerie;
	
	@Column(name = "DATA_KM_TREM")
	private LocalDate trainDateKm;
	
	@Column(name = "KM_TREM")
	private Integer trainKm;
	
	public LastKmTrainEntity() {
	}
}
