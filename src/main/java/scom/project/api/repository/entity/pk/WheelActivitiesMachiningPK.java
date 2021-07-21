package scom.project.api.repository.entity.pk;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class WheelActivitiesMachiningPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_RODA")
	public String wheelCode;
	
	@Column(name = "DATA_USINAGEM_RODA")
	public LocalDate wheelDateMachining;
	
	public WheelActivitiesMachiningPK(String wheelCode, LocalDate wheelDateMachining) {
		this.wheelCode = wheelCode;
		this.wheelDateMachining = wheelDateMachining;
	}
}
