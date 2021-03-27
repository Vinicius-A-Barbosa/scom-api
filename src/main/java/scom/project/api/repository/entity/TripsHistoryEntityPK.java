package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class TripsHistoryEntityPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "VIAGEM_ID")
	private Integer tripId;
	
	@Column(name = "TEMPO")
	private LocalTime tripTime;
	
	public TripsHistoryEntityPK() {
		
	}
	
	public TripsHistoryEntityPK(Integer tripId, LocalTime tripTime) {
		this.tripId = tripId;
		this.tripTime = tripTime;
	}
}
