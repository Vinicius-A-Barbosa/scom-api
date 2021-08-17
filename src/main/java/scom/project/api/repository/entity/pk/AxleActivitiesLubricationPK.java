package scom.project.api.repository.entity.pk;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class AxleActivitiesLubricationPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_EIXO")
	public String axleCode;
	
	@Column(name = "DATA_LUBRIFICACAO_EIXO")
	public LocalDate axleDateLubrication;
	
	public AxleActivitiesLubricationPK() {
	}
	
	public AxleActivitiesLubricationPK(String axleCode, LocalDate axleDateLubrication) {
		this.axleCode = axleCode;
		this.axleDateLubrication = axleDateLubrication;
	}
}
