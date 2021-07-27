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
public class EngineActivitiesCheckPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_MOTOR")
	public String engineCode;
	
	@Column(name = "CODIGO_TIPO_ENSAIO_MOTOR")
	public String engineCheckTypeCode;
	
	@Column(name = "DATA_ENSAIO_ENTRADA")
	public LocalDate checkDateIn;
	
	public EngineActivitiesCheckPK() {
	}
	
	public EngineActivitiesCheckPK(String engineCode, String engineCheckTypeCode, LocalDate checkDateIn) {
		this.engineCode = engineCode;
		this.engineCheckTypeCode = engineCheckTypeCode;
		this.checkDateIn = checkDateIn;
	}
}
