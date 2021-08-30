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
@Table(name = "TRUQUES_COM_MOTORES")
public class BogieWithEnginesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "CODIGO_POSICOES_MOTOR")
	private String enginePositionsDescription;
	
	@Id
	@Column(name = "CODIGO_MOTOR")
	private String engineCode;
}
