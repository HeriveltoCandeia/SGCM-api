package br.pucminas.tcc.model.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "MEDICAMENTOS")
public class Medicamento extends AbstractEntity<Long>{

@NotBlank
@Size(min=3, max=30)
@Column(name="nomeFabrica", nullable=false, unique=true, length=30)
private String nomeFabrica;

@NotBlank
@Size(min=3, max=30)
@Column(name="nomeGenerico", nullable=false, length=30)
private String nomeGenerico;

@NotBlank
@Size(min=3, max=30)
@Column(name="nomeFabricante", nullable=false, length=30)
private String nomeFabricante;


@JsonIgnore
@JsonBackReference	
@OneToMany(mappedBy = "medicamento")
private List<ProntuarioMedicamento> prontuarioMedicamentos;


public String getNomeFabrica() {
	return nomeFabrica;
}


public void setNomeFabrica(String nomeFabrica) {
	this.nomeFabrica = nomeFabrica;
}


public String getNomeGenerico() {
	return nomeGenerico;
}


public void setNomeGenerico(String nomeGenerico) {
	this.nomeGenerico = nomeGenerico;
}


public String getNomeFabricante() {
	return nomeFabricante;
}


public void setNomeFabricante(String nomeFabricante) {
	this.nomeFabricante = nomeFabricante;
}



}
