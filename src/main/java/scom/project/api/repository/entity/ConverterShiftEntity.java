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
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_CONVERSOR", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntityIn;
	
	@Transient
	private Integer converterKmIn = converterKilometersEntityIn.getConverterKm();
	
	@Column(name = "DATA_SAIDA_CONVERSOR")
	private LocalDate converterDateOut;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_CONVERSOR", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntityOut;
	
	@Transient
	private Integer converterKmOut = converterKilometersEntityOut.getConverterKm();
	
	@Column(name = "KM_ACUMULADO_CONVERSOR")
	private Integer converterKmAccumulated;
	
	public void setConverterShiftPK(String trainCode, String wagonPositionsDescription, String converterCode, LocalDate converterDateIn) {
		this.converterShiftPK = new ConverterShiftPK(trainCode, wagonPositionsDescription, converterCode, converterDateIn);
	}
}
