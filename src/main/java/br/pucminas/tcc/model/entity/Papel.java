package br.pucminas.tcc.model.entity;

import java.util.List;

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
@Table(name = "PAPEIS")
public class Papel extends AbstractEntity<Long>{

@NotBlank
@Size(min=3, max=30)
@Column(name="descricao", nullable=false, unique=true, length=30)
private String descricao;

@ManyToMany(mappedBy="papeis")//, cascade = CascadeType.ALL)
private List<Pessoa> pessoas; 

public List<Pessoa> getPessoas()
{ 
  return pessoas; 
} 

public void setPessoas(List<Pessoa> pessoas) 
{ 
  this.pessoas = pessoas; 
} 

public String getDescricao() 
{ 
  return descricao; 
} 
public void setDescricao(String descricao) 
{ 
  this.descricao = descricao; 
}
}
