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
import scom.project.api.repository.entity.pk.EngineActivitiesMaintenancePK;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADES_MANUTENCAO_MOTOR")
public class EngineActivitiesMaintenanceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	public EngineActivitiesMaintenancePK engineActivitiesMaintenancePK;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_MANUTENCAO_MOTOR", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntity;
	
	@Transient
	private Integer engineKmMaintenance = engineKilometersEntity.getEngineKm();
	
	@Column(name = "COMPRIMENTO_MEDIO_ESCOVAS")
	private double averageLengthBrush;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA1_INTERNA")
	private double pressureSpringBrushOneInside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA1_EXTERNA")
	private double pressureSpringBrushOneOutside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA2_INTERNA")
	private double pressureSpringBrushTwoInside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA2_EXTERNA")
	private double pressureSpringBrushTwoOutside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA3_INTERNA")
	private double pressureSpringBrushThreeInside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA3_EXTERNA")
	private double pressureSpringBrushThreeOutside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA4_INTERNA")
	private double pressureSpringBrushFourInside;
	
	@Column(name = "PRESSAO_MOLA_ESCOVA4_EXTERNA")
	private double pressureSpringBrushFourOutside;
	
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
	
	public void setEngineActivitiesMaintenancePK
	(
		String engineCode, LocalDate engineDateMaintenance,
		double lengthBrushOneInside, double lengthBrushOneOutside,
		double lengthBrushTwoInside, double lengthBrushTwoOutside,
		double lengthBrushThreeInside, double lengthBrushThreeOutside,
		double lengthBrushFourInside, double lengthBrushFourOutside
	)
	{
		this.engineActivitiesMaintenancePK = new EngineActivitiesMaintenancePK(
													engineCode,
													engineDateMaintenance,
													lengthBrushOneInside,
													lengthBrushOneOutside,
													lengthBrushTwoInside,
													lengthBrushTwoOutside,
													lengthBrushThreeInside,
													lengthBrushThreeOutside,
													lengthBrushFourInside,
													lengthBrushFourOutside
												);
	}
}