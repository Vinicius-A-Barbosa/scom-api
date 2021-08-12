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
import scom.project.api.repository.entity.pk.EngineActivitiesCheckPK;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "ATIVIDADES_ENSAIOS_MOTOR")
public class EngineActivitiesCheckEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EngineActivitiesCheckPK engineActivitiesCheckPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENSAIO_ENTRADA", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntityIn;
	
	@Transient
	private Integer checkKmIn;
	

	@Column(name = "DATA_ENSAIO_SAIDA")
	private LocalDate checkDateOut;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_MOTOR", referencedColumnName = "CODIGO_MOTOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENSAIO_SAIDA", referencedColumnName = "DATA_KM_MOTOR", insertable = false, updatable = false)
	})
	private EngineKilometersEntity engineKilometersEntityOut;
	
	@Transient
	private Integer checkKmOut;
	
	@Column(name = "NUMERO_ORDEM_SERVICO")
	private String serviceOrderNumber;
	
	@Column(name = "DATA_ABERTURA_OS")
	private LocalDate serviceOrderDateOpening;
	
	@Column(name = "DATA_FECHAMENTO_OS")
	private LocalDate serviceOrderDateClosing;
	
	@Column(name = "DIAS_EM_INDISPONIBILIDADE")
	private Integer numberUnavailabilityDays;
	
	@Column(name = "KM_DESDE_ULTIMA_MANUTENCAO_MOTOR")
	private Integer sinceLastCheckKm;
	
	@Column(name = "OVALIZACAO_INTERNA_ENTRADA")
	private double insideOvalizationIn;
	
	@Column(name = "OVALIZACAO_INTERNA_SAIDA")
	private double insideOvalizationOut;
	
	@Column(name = "OVALIZACAO_EXTERNA_ENTRADA")
	private double outsideOvalizationIn;
	
	@Column(name = "OVALIZACAO_EXTERNA_SAIDA")
	private double outsideOvalizationOut;
	
	@Column(name = "DIAMETRO_COMUTADOR_ENTRADA")
	private double commutatorDiameterIn;
	
	@Column(name = "DIAMETRO_COMUTADOR_SAIDA")
	private double commutatorDiameterOut;
	
	@Column(name = "PROFUNDIDADE_MICA_ENTRADA")
	private double micaDepthIn;
	
	@Column(name = "PROFUNDIDADE_MICA_SAIDA")
	private double micaDepthOut;
	
	@Column(name = "RESISTENCIA_ISOLAMENTO_BOBINA_ENTRADA")
	private double resistenceIsolationCoilIn;
	
	@Column(name = "RESISTENCIA_ISOLAMENTO_BOBINA_SAIDA")
	private double resistenceIsolationCoilOut;
	
	@Column(name = "RESISTENCIA_BARRAMENTO_ENTRADA")
	private double resistenceBusIn;
	
	@Column(name = "RESISTENCIA_BARRAMENTO_SAIDA")
	private double resistenceBusOut;
	
	@Column(name = "RESISTENCIA_INTERPOLOS_ENTRADA")
	private double resistenceInterpolesIn;
	
	@Column(name = "RESISTENCIA_INTERPOLOS_SAIDA")
	private double resistenceInterpolesOut;
	
	@Column(name = "RESISTENCIA_ARMADURA_ENTRADA")
	private double resistenceArmorIn;
	
	@Column(name = "RESISTENCIA_ARMADURA_SAIDA")
	private double resistenceArmorOut;
	
	@Column(name = "RESISTENCIA_OHMICA_BOBINA_ENTRADA")
	private double resistenceOhmicCoilIn;
	
	@Column(name = "RESISTENCIA_OHMICA_BOBINA_SAIDA")
	private double resistenceOhmicCoilOut;
	
	@Column(name = "RESISTENCIA_INTERPOLOS_BOBINA_ENTRADA")
	private double resistenceInterpolesCoilIn;
	
	@Column(name = "RESISTENCIA_INTERPOLOS_BOBINA_SAIDA")
	private double resistenceInterpolesCoilOut;
	
	@Column(name = "RESISTENCIA_CONTATO1_ENTRADA")
	private double resistenceContactOneIn;
	
	@Column(name = "RESISTENCIA_CONTATO1_SAIDA")
	private double resistenceContactOneOut;
	
	@Column(name = "RESISTENCIA_CONTATO2_ENTRADA")
	private double resistenceContactTwoIn;
	
	@Column(name = "RESISTENCIA_CONTATO2_SAIDA")
	private double resistenceContactTwoOut;
	
	@Column(name = "IMPEDANCIA_SERIE_ENTRADA")
	private double impedanceSerieIn;
	
	@Column(name = "IMPEDANCIA_SERIE_SAIDA")
	private double impedanceSerieOut;
	
	@Column(name = "IMPEDANCIA_INTERPOLOS_ENTRADA")
	private double impedanceInterpolesIn;
	
	@Column(name = "IMPEDANCIA_INTERPOLOS_SAIDA")
	private double impedanceInterpolesOut;
	
	@Column(name = "TENSAO_INDUZIDA_ENTRADA")
	private double voltageInducedIn;
	
	@Column(name = "TENSAO_INDUZIDA_SAIDA")
	private double voltageInducedOut;
	
	@Column(name = "VELOCIDADE_MAXIMA_ENTRADA")
	private double maxVelocityIn;
	
	@Column(name = "VELOCIDADE_MAXIMA_SAIDA")
	private double maxVelocityOut;
	
	@Column(name = "TIPO_ESCOVA_ENTRADA")
	private double brushTypeIn;
	
	@Column(name = "TIPO_ESCOVA_SAIDA")
	private double brushTypeOut;
	
	@Column(name = "REFERENCIA_FORCA_MOLA_ENTRADA")
	private double springForceReferenceIn;
	
	@Column(name = "REFERENCIA_FORCA_MOLA_SAIDA")
	private double springForceReferenceOut;
	
	@Column(name = "FOLGA_AXIAL_ENTRADA")
	private double axialClearanceIn;
	
	@Column(name = "FOLGA_AXIAL_SAIDA")
	private double axialClearanceOut;
	
	@Column(name = "CRAVAMENTO_PINHAO_ENTRADA")
	private double gearAdherencePercentageIn;
	
	@Column(name = "CRAVAMENTO_PINHAO_SAIDA")
	private double gearAdherencePercentageOut;
	
	@Column(name = "TIPO_MANUTENCAO_MOTOR")
	private String engineMaintenanceType;
	
	@Column(name = "DESCRICAO_OU_SINTOMA")
	private String descriptionSymptom;
	
	@Column(name = "OBSERVACAO")
	private String observation;
	
	public EngineActivitiesCheckEntity() {
		this.engineActivitiesCheckPK = new EngineActivitiesCheckPK();
	}
	
	public void setEngineActivitiesCheckPK
	(
		String engineCode, 
		String engineCheckTypeCode, 
		LocalDate checkDateIn
	)
	{
		this.engineActivitiesCheckPK = new EngineActivitiesCheckPK(
													engineCode,
													engineCheckTypeCode,
													checkDateIn
												);
	}
	
	@PostLoad
	private void setKms() {
		checkKmIn = engineKilometersEntityIn != null ? engineKilometersEntityIn.getEngineKm() : null;
		checkKmOut = engineKilometersEntityOut != null ? engineKilometersEntityOut.getEngineKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		engineKilometersEntityIn = new EngineKilometersEntity();
		engineKilometersEntityIn.getEngineKilometersPK()
			.setEngineCode(engineActivitiesCheckPK.getEngineCode());
		engineKilometersEntityIn.getEngineKilometersPK()
			.setEngineDateKm(engineActivitiesCheckPK.getCheckDateIn());
		engineKilometersEntityIn.setEngineKm(checkKmIn);
		
		engineKilometersEntityOut = new EngineKilometersEntity();
		engineKilometersEntityOut.getEngineKilometersPK()
			.setEngineCode(engineActivitiesCheckPK.getEngineCode());
		engineKilometersEntityOut.getEngineKilometersPK()
			.setEngineDateKm(checkDateOut);
		engineKilometersEntityOut.setEngineKm(checkKmOut);
	}
}
