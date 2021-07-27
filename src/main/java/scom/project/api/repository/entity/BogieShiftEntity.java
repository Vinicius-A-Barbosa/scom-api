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
import scom.project.api.repository.entity.pk.BogieShiftPK;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "MOVIMENTACOES_TRUQUE")
public class BogieShiftEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BogieShiftPK bogieShiftPK;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_TRUQUE", referencedColumnName = "CODIGO_TRUQUE", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_TRUQUE", referencedColumnName = "DATA_KM_TRUQUE", insertable = false, updatable = false)
	})
	private BogieKilometersEntity bogieKilometersEntityIn;
	
	@Transient
	private Integer bogieKmIn = bogieKilometersEntityIn.getBogieKm();
	
	@Column(name = "DATA_SAIDA_TRUQUE")
	private LocalDate bogieDateOut;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_TRUQUE", referencedColumnName = "CODIGO_TRUQUE", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_TRUQUE", referencedColumnName = "DATA_KM_TRUQUE", insertable = false, updatable = false)
	})
	private BogieKilometersEntity bogieKilometersEntityOut;
	
	@Transient
	private Integer bogieKmOut = bogieKilometersEntityOut.getBogieKm();
	
	@Column(name = "KM_ACUMULADO_TRUQUE")
	private Integer bogieKmAccumulated;
	
	public BogieShiftEntity() {
		this.bogieShiftPK = new BogieShiftPK();
	}
	
	public void setBogieShiftPK(String trainCode, String wagonPositionsDescription, String bogiePositionsDescription, LocalDate bogieDateIn) {
		this.bogieShiftPK = new BogieShiftPK(trainCode, wagonPositionsDescription, bogiePositionsDescription, bogieDateIn);
	}
}
