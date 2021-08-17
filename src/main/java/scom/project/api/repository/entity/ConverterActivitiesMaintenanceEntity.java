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
import scom.project.api.repository.entity.pk.ConverterActivitiesMaintenancePK;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "ATIVIDADES_MANUTENCAO_CONVERSOR")
public class ConverterActivitiesMaintenanceEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ConverterActivitiesMaintenancePK converterActivitiesMaintenancePK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_MANUTENCAO_CONVERSOR", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntity;
	
	@Transient
	private Integer converterKmMaintenance;

	@Column(name = "COMPRIMENTO_MEDIO_ESCOVAS")
	private double averageLengthBrush;

	@Column(name = "PRESSAO_MOLA_DIREITA_INTERNA")
	private double pressureSpringRightInside;

	@Column(name = "PRESSAO_MOLA_DIREITA_EXTERNA")
	private double pressureSpringRightOutside;

	@Column(name = "PRESSAO_MOLA_ESQUERDA_INTERNA")
	private double pressureSpringLeftInside;

	@Column(name = "PRESSAO_MOLA_ESQUERDA_EXTERNA")
	private double pressureSpringLeftOutside;

	@Column(name = "OVALIZACAO")
	private Integer ovalization;

	@Column(name = "DESGASTE")
	private double wear;

	@Column(name = "PRESSAO")
	private double pressure;

	@Column(name = "TIPO_MANUTENCAO")
	private String maintenanceType;

	@Column(name = "COMENTARIO")
	private String comments;

	@Column(name = "HORIMETRO")
	private double hourmeter;
	
	public ConverterActivitiesMaintenanceEntity() {
		this.converterActivitiesMaintenancePK = new ConverterActivitiesMaintenancePK();
	}

	public void setConverterActivitiesMaintenancePK
	(
		String converterCode, LocalDate converterDateMaintenance, 
		double lengthBrushRightInside, double lengthBrushRightOutside,
		double lengthBrushLeftInside, double lengthBrushLeftOutside
	) 
	{
		this.converterActivitiesMaintenancePK = new ConverterActivitiesMaintenancePK(
													converterCode,
													converterDateMaintenance,
													lengthBrushRightInside,
													lengthBrushRightOutside,
													lengthBrushLeftInside,
													lengthBrushLeftOutside
												);
	}
	
	@PostLoad
	private void setKms() {
		converterKmMaintenance = converterKilometersEntity != null ? converterKilometersEntity.getConverterKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		converterKilometersEntity = new ConverterKilometersEntity();
		converterKilometersEntity.getConverterKilometersPK()
			.setConverterCode(converterActivitiesMaintenancePK.getConverterCode());
		converterKilometersEntity.getConverterKilometersPK()
			.setConverterDateKm(converterActivitiesMaintenancePK.getConverterDateMaintenance());
		converterKilometersEntity.setConverterKm(converterKmMaintenance);
	}
}
