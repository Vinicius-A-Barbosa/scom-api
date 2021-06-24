package scom.project.api.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EQUIPAMENTOS_TREM")
public class TrainEntity {
	
	@Id
	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "DISPONIBILIDADE_TREM")
	private String trainAvailability;
	
	@Column(name = "SERIE_TREM")
	private String trainSerie;
}
