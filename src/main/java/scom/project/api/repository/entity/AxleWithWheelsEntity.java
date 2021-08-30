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
@Table(name = "EIXOS_COM_RODAS")
public class AxleWithWheelsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_EIXO")
	private String axleCode;
	
	@Column(name = "CODIGO_POSICOES_RODA")
	private String wheelPositionsDescription;
	
	@Id
	@Column(name = "CODIGO_RODA")
	private String wheelCode;
}
