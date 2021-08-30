package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
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
	
	@OneToMany(mappedBy = "trainCode", cascade = CascadeType.ALL)
	private List<TrainWithBogiesEntity> trainWithBogiesList = new ArrayList<>();
	
	@OneToMany(mappedBy = "trainCode", cascade = CascadeType.ALL)
	private List<TrainWithConvertersEntity> trainWithConvertersList = new ArrayList<>();
	
	public LastKmTrainEntity() {
	}
}
