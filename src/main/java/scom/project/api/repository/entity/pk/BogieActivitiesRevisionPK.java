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
public class BogieActivitiesRevisionPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_TRUQUE")
	public String bogieCode;
	
	@Column(name = "DATA_REVISAO_TRUQUE")
	public LocalDate bogieDateRevision;
	
	public BogieActivitiesRevisionPK(String bogieCode, LocalDate bogieDateRevision) {
		this.bogieCode = bogieCode;
		this.bogieDateRevision = bogieDateRevision;
	}
}
