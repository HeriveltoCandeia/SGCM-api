package br.pucminas.tcc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "MEDICAMENTOSRECEITA")
public class MedicamentosReceita extends AbstractEntity<Long>{

	private Long receitas_Id;
	private Long medicamentos_receita_id;
	private String forma_uso;

    public Long getReceitas_Id() {
		return receitas_Id;
	}
	public void setReceitas_Id(Long receitas_Id) {
		this.receitas_Id = receitas_Id;
	}
	public Long getMedicamentos_receita_id() {
		return medicamentos_receita_id;
	}
	public void setMedicamentos_receita_id(Long medicamentos_receita_id) {
		this.medicamentos_receita_id = medicamentos_receita_id;
	}
	public String getForma_uso() {
		return forma_uso;
	}
	public void setForma_uso(String forma_uso) {
		this.forma_uso = forma_uso;
	}

}
