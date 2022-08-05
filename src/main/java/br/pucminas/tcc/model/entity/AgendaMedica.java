package br.pucminas.tcc.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "AGENDAMEDICA")
public class AgendaMedica extends AbstractEntity<Long>{

	@Column(nullable=false)
	private LocalDateTime dataAgenda;
	
	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_medico_id")
	@JsonIgnore
	private Funcionario medico;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "codigo_cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	@Column(name="codigoSituacao", nullable=false)
	private Integer codigoSituacao;
	
	@Column(name="codigoTipo", nullable=false)
	private Integer codigoTipo;


	@Column(name="dataReg", nullable=false)
	private LocalDate dataReg;
	
	public LocalDateTime getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(LocalDateTime dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public Funcionario getMedico() {
		return medico;
	}

	public void setMedico(Funcionario medico) {
		this.medico = medico;
	}

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

	public Integer getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(Integer codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public LocalDate getDataReg() {
		return dataReg;
	}

	public void setDataReg(LocalDate dataReg) {
		this.dataReg = dataReg;
	}
	
}
