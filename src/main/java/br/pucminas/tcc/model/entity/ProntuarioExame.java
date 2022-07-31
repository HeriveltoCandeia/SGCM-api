package br.pucminas.tcc.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRONTUARIOEXAME")
public class ProntuarioExame extends AbstractEntity<Long>{

	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_prontuario_id", nullable=false)
	private ProntuarioMedico prontuarioMedico;

	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "exame_id")
	private Exame exame;

	@Column(name="codigoSituacao", nullable=false)
	private Integer codigoSituacao;
	
	@Column(name="orientacoes", nullable=true, length=1000)
	private String orientacoes;

	@Column(name="resultado", nullable=true, length=100)
	private String resultado;
	
	public String getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(String orientacoes) {
		this.orientacoes = orientacoes;
	}

	public ProntuarioMedico getProntuarioMedico() {
		return prontuarioMedico;
	}

	public void setProntuarioMedico(ProntuarioMedico prontuarioMedico) {
		this.prontuarioMedico = prontuarioMedico;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Integer getCodigoSituacao() {
		return codigoSituacao;
	}

	public void setCodigoSituacao(Integer codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
}
