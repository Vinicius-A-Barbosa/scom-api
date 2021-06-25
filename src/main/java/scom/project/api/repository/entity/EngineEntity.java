package scom.project.api.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EQUIPAMENTOS_MOTOR")
public class EngineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_MOTOR")
	private String engineCode;
	
	@Column(name = "DISPONIBILIDADE_MOTOR")
	private String engineAvailability;
	
	@Column(name = "SERIE_MOTOR")
	private String engineSerie;
}
