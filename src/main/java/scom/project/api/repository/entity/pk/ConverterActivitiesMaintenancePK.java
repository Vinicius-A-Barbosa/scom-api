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
public class ConverterActivitiesMaintenancePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_CONVERSOR")
	public String converterCode;
	
	@Column(name = "DATA_MANUTENCAO_CONVERSOR")
	public LocalDate converterDateMaintenance;
	
	@Column(name = "COMPRIMENTO_ESCOVA_DIREITA_INTERNA")
	public double lengthBrushRightInside;
	
	@Column(name = "COMPRIMENTO_ESCOVA_DIREITA_EXTERNA")
	public double lengthBrushRightOutside;
	
	@Column(name = "COMPRIMENTO_ESCOVA_ESQUERDA_INTERNA")
	public double lengthBrushLeftInside;
	
	@Column(name = "COMPRIMENTO_ESCOVA_ESQUERDA_EXTERNA")
	public double lengthBrushLeftOutside;
	
	public ConverterActivitiesMaintenancePK() {
	}
	
	public ConverterActivitiesMaintenancePK
	(
		String converterCode, LocalDate converterDateMaintenance, 
		double lengthBrushRightInside, double lengthBrushRightOutside,
		double lengthBrushLeftInside, double lengthBrushLeftOutside
	) {
		this.converterCode = converterCode;
		this.converterDateMaintenance = converterDateMaintenance;
		this.lengthBrushRightInside = lengthBrushRightInside;
		this.lengthBrushRightOutside = lengthBrushRightOutside;
		this.lengthBrushLeftInside = lengthBrushLeftInside;
		this.lengthBrushLeftOutside = lengthBrushLeftOutside;
		
	}
}
