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
@Table(name = "EQUIPAMENTOS_CONVERSOR")
public class ConverterEntity implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_CONVERSOR")
	private String converterCode;
	
	@Column(name = "DISPONIBILIDADE_CONVERSOR")
	private String converterAvailability;
	
	@Column(name = "SERIE_CONVERSOR")
	private String converterSerie;
}
