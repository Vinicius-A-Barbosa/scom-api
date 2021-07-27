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
public class EngineActivitiesMaintenancePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_MOTOR")
	public String engineCode;
	
	@Column(name = "DATA_MANUTENCAO_MOTOR")
	public LocalDate engineDateMaintenance;
	
	@Column(name = "COMPRIMENTO_ESCOVA1_INTERNA")
	public double lengthBrushOneInside;
	
	@Column(name = "COMPRIMENTO_ESCOVA1_EXTERNA")
	public double lengthBrushOneOutside;
	
	@Column(name = "COMPRIMENTO_ESCOVA2_INTERNA")
	public double lengthBrushTwoInside;
	
	@Column(name = "COMPRIMENTO_ESCOVA2_EXTERNA")
	public double lengthBrushTwoOutside;
	
	@Column(name = "COMPRIMENTO_ESCOVA3_INTERNA")
	public double lengthBrushThreeInside;
	
	@Column(name = "COMPRIMENTO_ESCOVA3_EXTERNA")
	public double lengthBrushThreeOutside;
	
	@Column(name = "COMPRIMENTO_ESCOVA4_INTERNA")
	public double lengthBrushFourInside;
	
	@Column(name = "COMPRIMENTO_ESCOVA4_EXTERNA")
	public double lengthBrushFourOutside;
	
	public EngineActivitiesMaintenancePK() {
	}
	
	public EngineActivitiesMaintenancePK
	(
		String engineCode, LocalDate engineDateMaintenance,
		double lengthBrushOneInside, double lengthBrushOneOutside,
		double lengthBrushTwoInside, double lengthBrushTwoOutside,
		double lengthBrushThreeInside, double lengthBrushThreeOutside,
		double lengthBrushFourInside, double lengthBrushFourOutside
	) {
		this.engineCode = engineCode;
		this.engineDateMaintenance = engineDateMaintenance;
		this.lengthBrushOneInside = lengthBrushOneInside;
		this.lengthBrushOneOutside = lengthBrushOneOutside;
		this.lengthBrushTwoInside = lengthBrushTwoInside;
		this.lengthBrushTwoOutside = lengthBrushTwoOutside;
		this.lengthBrushThreeInside = lengthBrushThreeInside;
		this.lengthBrushThreeOutside = lengthBrushThreeOutside;
		this.lengthBrushFourInside = lengthBrushFourInside;
		this.lengthBrushFourOutside = lengthBrushFourOutside;
	}
	
}
