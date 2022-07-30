package br.pucminas.tcc.model.entity;

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
public class AgendaMedica {

	@EmbeddedId
	private ChaveCompostaAgenda chaveCompostaAgenda;
	
	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	@Column(name="codigoSituacao", nullable=false)
	private Integer codigoSituacao;
	
	@Column(name="codigoTipo", nullable=false)
	private Integer codigoTipo;

	public ChaveCompostaAgenda getChaveCompostaAgenda() {
		return chaveCompostaAgenda;
	}

	public void setChaveCompostaAgenda(ChaveCompostaAgenda chaveCompostaAgenda) {
		this.chaveCompostaAgenda = chaveCompostaAgenda;
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
	
}
