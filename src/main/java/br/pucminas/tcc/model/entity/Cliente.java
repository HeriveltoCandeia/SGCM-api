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
	
	@Size(max=40)
	@Column(name="convenioMedico", nullable=true, length=40)
	private String convenioMedico;
	
	@Size(max=40)
	@Column(name="numeroCarteirinha", nullable=true, length=40)
	private String numeroCarteirinha;


	public String getConvenioMedico() {
		return convenioMedico;
	}

	public void setConvenioMedico(String convenioMedico) {
		this.convenioMedico = convenioMedico;
	}

	public String getNumeroCarteirinha() {
		return numeroCarteirinha;
	}

	public void setNumeroCarteirinha(String numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}
	
}
