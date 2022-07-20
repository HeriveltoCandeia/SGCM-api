package br.pucminas.tcc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENTES")
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Pessoa{
	
	@Column(name="codigoConvenioMedico", nullable=true)
	private Integer codigoConvenioMedico;
	
	@Size(max=40)
	@Column(name="numeroCarteirinha", nullable=true, length=40)
	private String numeroCarteirinha;

	public Integer getCodigoConvenioMedico() {
		return codigoConvenioMedico;
	}

	public void setCodigoConvenioMedico(Integer codigoConvenioMedico) {
		this.codigoConvenioMedico = codigoConvenioMedico;
	}

	public String getNumeroCarteirinha() {
		return numeroCarteirinha;
	}

	public void setNumeroCarteirinha(String numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}
	
}
