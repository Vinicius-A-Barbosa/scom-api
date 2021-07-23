package scom.project.api.repository.entity;

import java.io.Serializable;

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
@Table(name = "EQUIPAMENTOS_RODA")
public class WheelEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_RODA")
	private String wheelCode;
	
	@Column(name = "DISPONIBILIDADE_RODA")
	private String wheelAvailability;
	
	@Column(name = "SERIE_RODA")
	private String wheelSerie;
}
