package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.BogieActivitiesRevisionPK;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADES_REVISAO_TRUQUE")
public class BogieActivitiesRevisionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BogieActivitiesRevisionPK bogieActivitiesRevisionPK;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_TRUQUE", referencedColumnName = "CODIGO_TRUQUE", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_REVISAO_TRUQUE", referencedColumnName = "DATA_KM_TRUQUE", insertable = false, updatable = false)
	})
	private BogieKilometersEntity bogieKilometersEntity;
	
	@Transient
	private Integer bogieKmRevision = bogieKilometersEntity.getBogieKm();
	
	@Column(name = "KM_DESDE_ULTIMA_REVISAO_TRUQUE")
	private Integer sinceLastRevisionKm;
	
	public void setBogieActivitiesRevisionPK
	(
		String bogieCode,
		LocalDate bogieDateRevision
	)
	{
		this.bogieActivitiesRevisionPK = new BogieActivitiesRevisionPK(
													bogieCode,
													bogieDateRevision
												);
	}
}
