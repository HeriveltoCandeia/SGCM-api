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
@Table(name = "PRONTUARIOMEDICAMENTO")
public class ProntuarioMedicamento extends AbstractEntity<Long>{

	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_prontuario_id", nullable=false)
	private ProntuarioMedico prontuarioMedico;

	@JsonManagedReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "medicamento_id")
	private Medicamento medicamento;
	
	@Column(name="orientacoes", nullable=true, length=1000)
	private String orientacoes;
	
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
}
