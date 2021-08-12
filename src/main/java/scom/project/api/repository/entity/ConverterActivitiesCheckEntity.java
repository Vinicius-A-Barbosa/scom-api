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
import scom.project.api.repository.entity.pk.ConverterActivitiesCheckPK;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "ATIVIDADES_ENSAIOS_CONVERSOR")
public class ConverterActivitiesCheckEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ConverterActivitiesCheckPK converterActivitiesCheckPK;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENSAIO_ENTRADA", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntityIn;
	
	@Transient
	private Integer checkKmIn;

	@Column(name = "DATA_ENSAIO_SAIDA")
	private LocalDate checkDateOut;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "CODIGO_CONVERSOR", referencedColumnName = "CODIGO_CONVERSOR", insertable = false, updatable = false),
		@JoinColumn(name = "DATA_ENSAIO_SAIDA", referencedColumnName = "DATA_KM_CONVERSOR", insertable = false, updatable = false)
	})
	private ConverterKilometersEntity converterKilometersEntityOut;
	
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

	@Column(name = "KM_DESDE_ULTIMA_MANUTENCAO_CONVERSOR")
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

	@Column(name = "RESISTENCIA_ARMADURA_ENROLAMENTOS_ENTRADA")
	private double resistenceArmorWindingIn;

	@Column(name = "RESISTENCIA_ARMADURA_ENROLAMENTOS_SAIDA")
	private double resistenceArmorWindingOut;

	@Column(name = "RESISTENCIA_ISOLAMENTO_SHUNT_ENTRADA")
	private double resistenceIsolationShuntIn;

	@Column(name = "RESISTENCIA_ISOLAMENTO_SHUNT_SAIDA")
	private double resistenceIsolationShuntOut;

	@Column(name = "RESISTENCIA_SEPARADO_ENTRADA")
	private double resistenceSeparateIn;

	@Column(name = "RESISTENCIA_SEPARADO_SAIDA")
	private double resistenceSeparateOut;

	@Column(name = "RESISTENCIA_ESTATOR_ENTRADA")
	private double resistenceStatorIn;

	@Column(name = "RESISTENCIA_ESTATOR_SAIDA")
	private double resistenceStatorOut;

	@Column(name = "RESISTENCIA_ROTOR_ENTRADA")
	private double resistenceRotorIn;

	@Column(name = "RESISTENCIA_ROTOR_SAIDA")
	private double resistenceRotorOut;

	@Column(name = "RESISTENCIA_CONTROLE_TENSAO_ENTRADA")
	private double resistenceVoltageControllerIn;

	@Column(name = "RESISTENCIA_CONTROLE_TENSAO_SAIDA")
	private double resistenceVoltageControllerOut;

	@Column(name = "RESISTENCIA_GERACAO_TENSAO_ENTRADA")
	private double resistenceVoltageGenaratorIn;

	@Column(name = "RESISTENCIA_GERACAO_TENSAO_SAIDA")
	private double resistenceVoltageGenaratorOut;

	@Column(name = "RESISTENCIA_ROTOR_EXCITATRIZ_ENTRADA")
	private double resistenceRotorExciterIn;

	@Column(name = "RESISTENCIA_ROTOR_EXCITATRIZ_SAIDA")
	private double resistenceRotorExciterOut;

	@Column(name = "MAXIMA_RESISTENCIA_CONTATO_ENTRADA")
	private double maxResistenceContactIn;

	@Column(name = "MAXIMA_RESISTENCIA_CONTATO_SAIDA")
	private double maxResistenceContactOut;

	@Column(name = "MAXIMA_RESISTENCIA_SHUNT_ENTRADA")
	private double maxResistenceShuntIn;

	@Column(name = "MAXIMA_RESISTENCIA_SHUNT_SAIDA")
	private double maxResistenceShuntOut;

	@Column(name = "MAXIMA_RESISTENCIA_SEPARADO_ENTRADA")
	private double maxResistenceSeparateIn;

	@Column(name = "MAXIMA_RESISTENCIA_SEPARADO_SAIDA")
	private double maxResistenceSeparateOut;

	@Column(name = "MAXIMA_RESISTENCIA_ESTATOR_ENTRADA")
	private double maxResistenceStatorIn;

	@Column(name = "MAXIMA_RESISTENCIA_ESTATOR_SAIDA")
	private double maxResistenceStatorOut;

	@Column(name = "RESISTENCIA_OHMICA_ALTERNADOR_ENTRADA")
	private double resistenceOhmicAlternatorIn;

	@Column(name = "RESISTENCIA_OHMICA_ALTERNADOR_SAIDA")
	private double resistenceOhmicAlternatorOut;

	@Column(name = "RESISTENCIA_OHMICA_INVERSOR_ENTRADA")
	private double resistenceOhmicInverterIn;

	@Column(name = "RESISTENCIA_OHMICA_INVERSOR_SAIDA")
	private double resistenceOhmicInverterOut;

	@Column(name = "RESISTENCIA_OHMICA_PRINCIPAL_ENTRADA")
	private double resistenceOhmicLeadingIn;

	@Column(name = "RESISTENCIA_OHMICA_PRINCIPAL_SAIDA")
	private double resistenceOhmicLeadingOut;

	@Column(name = "RESISTENCIA_OHMICA_ROTOR_ENTRADA")
	private double resistenceOhmicRotorIn;

	@Column(name = "RESISTENCIA_OHMICA_ROTOR_SAIDA")
	private double resistenceOhmicRotorOut;

	@Column(name = "VALOR_DIODO_CONDUCAO_ENTRADA")
	private double valueDiodeConductionIn;

	@Column(name = "VALOR_DIODO_CONDUCAO_SAIDA")
	private double valueDiodeConductionOut;

	@Column(name = "VALOR_DIODO_ISOLACAO_ENTRADA")
	private double valueDiodeIsolationIn;

	@Column(name = "VALOR_DIODO_ISOLACAO_SAIDA")
	private double valueDiodeIsolationOut;

	@Column(name = "TENSAO_SEM_POLARIZACAO_ENTRADA")
	private double voltageWithoutPolarizationIn;

	@Column(name = "TENSAO_SEM_POLARIZACAO_SAIDA")
	private double voltageWithoutPolarizationOut;

	@Column(name = "TENSAO_POLARIZACAO_REVERSA_ENTRADA")
	private double voltageReversePolarizationIn;

	@Column(name = "TENSAO_POLARIZACAO_REVERSA_SAIDA")
	private double voltageReversePolarizationOut;

	@Column(name = "TENSAO_POLARIZACAO_DIRETA_ENTRADA")
	private double voltageDirectPolarizationIn;

	@Column(name = "TENSAO_POLARIZACAO_DIRETA_SAIDA")
	private double voltageDirectPolarizationOut;

	@Column(name = "EQUILIBRIO_FASES_ENTRADA")
	private Boolean balancePhasesIn;

	@Column(name = "EQUILIBRIO_FASES_SAIDA")
	private Boolean balancePhasesOut;

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

	@Column(name = "FORCA_IMA_ENTRADA")
	private double magnetForceIn;

	@Column(name = "FORCA_IMA_SAIDA")
	private double magnetForceOut;

	@Column(name = "TIPO_MANUTENCAO_CONVERSOR")
	private String converterMaintenanceType;

	@Column(name = "DESCRICAO_OU_SINTOMA")
	private String descriptionSymptom;

	@Column(name = "OBSERVACAO")
	private String observation;

	public ConverterActivitiesCheckEntity() {
		this.converterActivitiesCheckPK = new ConverterActivitiesCheckPK();
	}
	
	public void ConverterActivitiesCheckPK
	(
		String converterCode,
		String converterCheckTypeCode,
		LocalDate checkDateIn
	)
	{
		this.converterActivitiesCheckPK = new ConverterActivitiesCheckPK(
													converterCode,
													converterCheckTypeCode,
													checkDateIn
												);
	}
	
	@PostLoad
	private void setKms() {
		checkKmIn = converterKilometersEntityIn != null ? converterKilometersEntityIn.getConverterKm() : null;
		checkKmOut = converterKilometersEntityOut != null ? converterKilometersEntityOut.getConverterKm() : null;
	}
	
	@PrePersist
	private void setKmEntities() {
		converterKilometersEntityIn = new ConverterKilometersEntity();
		converterKilometersEntityIn.getConverterKilometersPK()
			.setConverterCode(converterActivitiesCheckPK.getConverterCode());
		converterKilometersEntityIn.getConverterKilometersPK()
			.setConverterDateKm(converterActivitiesCheckPK.getCheckDateIn());
		converterKilometersEntityIn.setConverterKm(checkKmIn);
		
		converterKilometersEntityOut = new ConverterKilometersEntity();
		converterKilometersEntityOut.getConverterKilometersPK()
			.setConverterCode(converterActivitiesCheckPK.getConverterCode());
		converterKilometersEntityOut.getConverterKilometersPK()
			.setConverterDateKm(checkDateOut);
		converterKilometersEntityOut.setConverterKm(checkKmOut);
	}
}
