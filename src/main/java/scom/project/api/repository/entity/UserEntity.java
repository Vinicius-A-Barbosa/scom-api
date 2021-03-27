package scom.project.api.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "USUARIOS")
@Entity
public class UserEntity {
	
	@Id
	@Column(name = "MATRICULA")
	private String login;
	
	@Column(name = "SENHA")
	private String password;
	
	@Column(name = "NIVEL_PERMISSAO")
	private String permissionLevel;
}
