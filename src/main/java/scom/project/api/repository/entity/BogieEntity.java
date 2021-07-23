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
@Table(name = "EQUIPAMENTOS_TRUQUE")
public class BogieEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "DISPONIBILIDADE_TRUQUE")
	private String bogieAvailability;
	
	@Column(name = "TIPO_TRUQUE")
	private String bogieType;
	
	@Column(name = "SERIE_TRUQUE")
	private String bogieSerie;
}
