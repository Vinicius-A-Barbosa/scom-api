package scom.project.api.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "HISTORICO_VIAGENS")
@Entity
@NamedQuery(name = "TripsHistoryEntity.findAll", query = "SELECT m FROM TripsHistoryEntity m")
public class TripsHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TripsHistoryEntityPK id;
	
	@Column(name = "ACELERACAO")
	private Double aceleration;
	
	@Column(name = "POSICAO")
	private Double position;
	
	@Column(name = "CONJUGADO")
	private Double torque;
	
	@Column(name = "FREQUENCIA")
	private Double frequency;
	
	@Column(name = "VELOCIDADE")
	private Double velocity;
	
	@Column(name = "EMERGENCIA")
	private Boolean emergency;
	
	@Column(name = "CURVA")
	private Double curve;
	
	@Column(name = "INCLINACAO")
	private Double inclination;
	
}
