package scom.project.api.repository.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "VIAGENS")
@Entity
public class TripsEntity {
	
	@Id
	@Column(name = "VIAGEM_ID")
	private Integer tripId;
	
	@Column(name = "ESTACAO_PARTIDA")
	private String departureStation;
	
	@Column(name = "ESTACAO_CHEGADA")
	private String arrivalStation;
	
	@Column(name = "TREM_ID")
	private String trainId;
	
	@Column(name = "DATA_INICIAL_VIAGEM")
	private LocalDateTime initialTripsDateHour;
	
	@Column(name = "DATA_FINAL_VIAGEM")
	private LocalDateTime finalTripsDateHour;
}
