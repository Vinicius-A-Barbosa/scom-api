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
import scom.project.api.repository.entity.pk.ConverterShiftPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "MOVIMENTACOES_CONVERSOR")
public class ConverterShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ConverterShiftPK converterShiftPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_CONVERSOR", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntityIn;
	
	@Transient
	private Integer converterKmIn;
	
	@Column(name = "DATA_SAIDA_CONVERSOR")
	private LocalDate converterDateOut;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_CONVERSOR", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntityOut;
	
	@Transient
	private Integer converterKmOut;
	
	@Column(name = "KM_ACUMULADO_CONVERSOR")
	private Integer converterKmAccumulated;
	
	public ConverterShiftEntity() {
		this.converterShiftPK = new ConverterShiftPK();
	}
	
	public void setConverterShiftPK(String trainCode, String wagonPositionsDescription, String converterCode, LocalDate converterDateIn) {
		this.converterShiftPK = new ConverterShiftPK(trainCode, wagonPositionsDescription, converterCode, converterDateIn);
	}
	
	@PostLoad
	private void setKms() {
		converterKmIn = converterKilometersEntityIn != null ? converterKilometersEntityIn.getConverterKm() : null;
		converterKmOut = converterKilometersEntityOut != null ? converterKilometersEntityOut.getConverterKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		converterKilometersEntityIn = new ConverterKilometersEntity();
		converterKilometersEntityIn.getConverterKilometersPK()
			.setConverterCode(converterShiftPK.getConverterCode());
		converterKilometersEntityIn.getConverterKilometersPK()
			.setConverterDateKm(converterShiftPK.getConverterDateIn());
		converterKilometersEntityIn.setConverterKm(converterKmIn);
		
		converterKilometersEntityOut = new ConverterKilometersEntity();
		converterKilometersEntityOut.getConverterKilometersPK()
			.setConverterCode(converterShiftPK.getConverterCode());
		converterKilometersEntityOut.getConverterKilometersPK()
			.setConverterDateKm(converterDateOut);
		converterKilometersEntityOut.setConverterKm(converterKmOut);
	}
}
