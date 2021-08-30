package scom.project.api.repository.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TRUQUES_COM_EIXOS")
public class BogieWithAxlesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@Column(name = "CODIGO_POSICOES_EIXO")
	private String axlePositionsDescription;
	
	@Id
	@Column(name = "CODIGO_EIXO")
	private String axleCode;
	
	@OneToMany(mappedBy = "axleCode", cascade = CascadeType.ALL)
	private List<AxleWithWheelsEntity> axleWithWheelsList = new ArrayList<>();
}
