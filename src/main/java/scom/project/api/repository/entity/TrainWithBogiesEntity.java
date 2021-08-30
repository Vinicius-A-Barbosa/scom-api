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
@Table(name = "TRENS_COM_TRUQUES")
public class TrainWithBogiesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO_TREM")
	private String trainCode;
	
	@Column(name = "CODIGO_POSICOES_CARRO")
	private String wagonPositionsDescription;
	
	@Column(name = "CODIGO_POSICOES_TRUQUE")
	private String bogiePositionsDescription;
	
	@Id
	@Column(name = "CODIGO_TRUQUE")
	private String bogieCode;
	
	@OneToMany(mappedBy = "bogieCode", cascade = CascadeType.ALL)
	private List<BogieWithAxlesEntity> bogieWithAxlesList = new ArrayList<>();

	@OneToMany(mappedBy = "bogieCode", cascade = CascadeType.ALL)
	private List<BogieWithEnginesEntity> bogieWithEnginesList = new ArrayList<>();
}
