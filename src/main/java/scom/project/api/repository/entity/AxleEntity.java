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
@Table(name = "EQUIPAMENTOS_EIXO")
public class AxleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_EIXO")
	private String axleCode;
	
	@Column(name = "DISPONIBILIDADE_EIXO")
	private String axleAvailability;
	
	@Column(name = "TIPO_EIXO")
	private String axleType;
	
	@Column(name = "SERIE_EIXO")
	private String axleSerie;
}
