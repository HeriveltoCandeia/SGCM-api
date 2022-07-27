package br.pucminas.tcc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FUNCIONARIOS")
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Pessoa{
	
	@Column(name="codigoCargo", nullable=false)
	private Integer codigoCargo;
	
	@NotBlank
	@Size(min=8, max=10)
	@Column(name="dataAdmissao", nullable=false, length=10)
	private String dataAdmissao;

	@Size(min=8, max=10)
	@Column(name="dataDesligamento", length=10)
	private String dataDesligamento;
	
	@Size(min=4, max=20)
	@Column(name="usuario", unique=true, length=20)
	private String usuario;

	@Size(min=8, max=20)
	@Column(name="senha", nullable=false, length=20)
	private String senha;
	
	public Integer getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(Integer codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(String dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
