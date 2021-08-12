package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import scom.project.api.repository.entity.pk.AxleActivitiesLubricationPK;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "ATIVIDADES_LUBRIFICACAO_EIXO")
public class AxleActivitiesLubricationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AxleActivitiesLubricationPK axleActivitiesLubricationPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_EIXO", referencedColumnName = "CODIGO_EIXO", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_LUBRIFICACAO_EIXO", referencedColumnName = "DATA_KM_EIXO", insertable = false, updatable = false)
	})
	private AxleKilometersEntity axleKilometersEntity;
	
	@Transient
	private Integer axleKmLubrication;
	
	@Column(name = "KM_DESDE_ULTIMA_LUBRIFICACAO_EIXO")
	private Integer axleKmSinceLastLubrication;
	
	public AxleActivitiesLubricationEntity() {
		this.axleActivitiesLubricationPK = new AxleActivitiesLubricationPK();
	}
	
	public void setAxleActivitiesLubricationPK
	(
		String axleCode,
		LocalDate axleDateLubrication
	)
	{
		this.axleActivitiesLubricationPK = new AxleActivitiesLubricationPK(
													axleCode,
													axleDateLubrication
												);
	}
	
	@PostLoad
	private void setKms() {
		axleKmLubrication = axleKilometersEntity != null ? axleKilometersEntity.getAxleKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		axleKilometersEntity = new AxleKilometersEntity();
		axleKilometersEntity.getAxleKilometersPK()
			.setAxleCode(axleActivitiesLubricationPK.getAxleCode());
		axleKilometersEntity.getAxleKilometersPK()
			.setAxleDateKm(axleActivitiesLubricationPK.getAxleDateLubrication());
		axleKilometersEntity.setAxleKm(axleKmLubrication);
	}
}
