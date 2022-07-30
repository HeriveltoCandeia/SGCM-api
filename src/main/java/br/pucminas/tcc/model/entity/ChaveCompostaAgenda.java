package br.pucminas.tcc.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Embeddable
public class ChaveCompostaAgenda implements Serializable {

	@Column(name="codigo_medico_id")
	private Long codigoMedicoId;
	
 	private LocalDateTime dataAgenda;
 	
   
 	public ChaveCompostaAgenda() { }
	      
 	public ChaveCompostaAgenda(Long id, LocalDateTime dataAgenda) {
 		this.codigoMedicoId = codigoMedicoId;
 		this.dataAgenda = dataAgenda;
 	}

	public Long getCodigoMedicoId() {
		return codigoMedicoId;
	}

	public void setCodigoMedicoId(Long codigoMedicoId) {
		this.codigoMedicoId = codigoMedicoId;
	}

	public LocalDateTime getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(LocalDateTime dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
 	
 	
}
