package br.pucminas.tcc.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRONTUARIOMEDICO")
public class ProntuarioMedico extends AbstractEntity<Long>{

	@Column(nullable=false)
	private LocalDateTime dataTimeProntuario;
	
	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_medico_id")
	@JsonIgnore
	private Funcionario medico;

	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	@Column(name="codigoSituacao", nullable=false)
	private Integer codigoSituacao;
	
	@Column(name="dataReg", nullable=false)
	private LocalDate dataReg;
	
	@Column(name="orientacoes", nullable=true, length=1000)
	private String orientacoes;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCodigoSituacao() {
		return codigoSituacao;
	}

	public void setCodigoSituacao(Integer codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	public LocalDate getDataReg() {
		return dataReg;
	}

	public void setDataReg(LocalDate dataReg) {
		this.dataReg = dataReg;
	}

	public LocalDateTime getDataTimeProntuario() {
		return dataTimeProntuario;
	}

	public void setDataTimeProntuario(LocalDateTime dataTimeProntuario) {
		this.dataTimeProntuario = dataTimeProntuario;
	}

	public Funcionario getMedico() {
		return medico;
	}

	public void setMedico(Funcionario medico) {
		this.medico = medico;
	}

	public String getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(String orientacoes) {
		this.orientacoes = orientacoes;
	}
	
}
