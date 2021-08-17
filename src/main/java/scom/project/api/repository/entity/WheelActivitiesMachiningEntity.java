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
import scom.project.api.repository.entity.pk.WheelActivitiesMachiningPK;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "ATIVIDADES_USINAGEM_RODA")
public class WheelActivitiesMachiningEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WheelActivitiesMachiningPK wheelActivitiesMachiningPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_RODA", referencedColumnName = "CODIGO_RODA", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_USINAGEM_RODA", referencedColumnName = "DATA_KM_RODA", insertable = false, updatable = false)
	})
	private WheelKilometersEntity wheelKilometersEntity;
	
	@Transient
	private Integer wheelKmMachining;
	

	@Column(name = "KM_DESDE_ULTIMA_USINAGEM_RODA")
	private Integer sinceLastMachiningKm;
	
	@Column(name = "DIAMETRO_RODA_NO_TORNO")
	private double diameterWheelInLathe;
	
	@Column(name = "DIAMETRO_RODA_POS_USINAGEM")
	private double diameterWheelAfterMachining;
	
	@Column(name = "PERDA_DIAMETRO_NA_USINAGEM")
	private double lostDiameterWheelInMachining;
	
	@Column(name = "DESGASTE_DIAMETRO_NO_TEMPO")
	private double wearDiameterInTime;
	
	@Column(name = "ESPESSURA_FRISO_NO_TORNO")
	private double thicknessFlangeInLathe;
	
	@Column(name = "ESPESSURA_FRISO_POS_USINAGEM")
	private double thicknessFlangeAfterMachining;
	
	@Column(name = "PERDA_FRISO_NA_USINAGEM")
	private double lostFlangeInMachining;
	
	@Column(name = "DESGASTE_FRISO_NO_TEMPO")
	private double wearFlangeInTime;
	
	public WheelActivitiesMachiningEntity() {
		this.wheelActivitiesMachiningPK = new WheelActivitiesMachiningPK();
	}
	
	public void setWheelActivitiesMachiningPK
	(
		String wheelCode, 
		LocalDate wheelDateMachining
	)
	{
		this.wheelActivitiesMachiningPK = new WheelActivitiesMachiningPK(
													wheelCode,
													wheelDateMachining
												);
	}
	
	@PostLoad
	private void setKms() {
		wheelKmMachining = wheelKilometersEntity != null ? wheelKilometersEntity.getWheelKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		wheelKilometersEntity = new WheelKilometersEntity();
		wheelKilometersEntity.getWheelKilometersPK()
			.setWheelCode(wheelActivitiesMachiningPK.getWheelCode());
		wheelKilometersEntity.getWheelKilometersPK()
			.setWheelDateKm(wheelActivitiesMachiningPK.getWheelDateMachining());
		wheelKilometersEntity.setWheelKm(wheelKmMachining);
	}
}
