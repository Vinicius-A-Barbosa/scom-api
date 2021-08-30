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
@Table(name = "TRENS_COM_CONVERSORES")
public class TrainWithConvertersEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "CODIGO_POSICOES_CARRO")
	private String wagonPositionsDescription;
	
	@Id
	@Column(name = "CODIGO_CONVERSOR")
	private String converterCode;
}
