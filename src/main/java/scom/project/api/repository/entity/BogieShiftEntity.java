package scom.project.api.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
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
	
	@ManyToOne
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_TRUQUE", referencedColumnName = "CODIGO_TRUQUE", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENTRADA_TRUQUE", referencedColumnName = "DATA_KM_TRUQUE", insertable = false, updatable = false)
	})
	private BogieKilometersEntity bogieKilometersEntityIn;
	
	@Transient
	private Integer bogieKmIn;
	
	@Column(name = "DATA_SAIDA_TRUQUE")
	private LocalDate bogieDateOut;
	
	@ManyToOne
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_TRUQUE", referencedColumnName = "CODIGO_TRUQUE", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_SAIDA_TRUQUE", referencedColumnName = "DATA_KM_TRUQUE", insertable = false, updatable = false)
	})
	private BogieKilometersEntity bogieKilometersEntityOut;
	
	@Transient
	private Integer bogieKmOut;
	
	@Column(name = "KM_ACUMULADO_TRUQUE")
	private Integer bogieKmAccumulated;
	
	public BogieShiftEntity() {
		this.bogieShiftPK = new BogieShiftPK();
	}
	
	public void setBogieShiftPK(String trainCode, String wagonPositionsDescription, String bogiePositionsDescription, String bogieCode, LocalDate bogieDateIn) {
		this.bogieShiftPK = new BogieShiftPK(trainCode, wagonPositionsDescription, bogiePositionsDescription, bogieCode, bogieDateIn);
	}
	
	@PostLoad
	private void setKms() {
		bogieKmIn = bogieKilometersEntityIn != null ? bogieKilometersEntityIn.getBogieKm() : null;
		bogieKmOut = bogieKilometersEntityOut != null ? bogieKilometersEntityOut.getBogieKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		bogieKilometersEntityIn = new BogieKilometersEntity();
		bogieKilometersEntityIn.getBogieKilometersPK()
			.setBogieCode(bogieShiftPK.getBogieCode());
		bogieKilometersEntityIn.getBogieKilometersPK()
			.setBogieDateKm(bogieShiftPK.getBogieDateIn());
		bogieKilometersEntityIn.setBogieKm(bogieKmIn);
		
		bogieKilometersEntityOut = new BogieKilometersEntity();
		bogieKilometersEntityOut.getBogieKilometersPK()
			.setBogieCode(bogieShiftPK.getBogieCode());
		bogieKilometersEntityOut.getBogieKilometersPK()
			.setBogieDateKm(bogieDateOut);
		bogieKilometersEntityOut.setBogieKm(bogieKmOut);
	}
}
