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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "PESSOASGENERICAS")
public class PessoaGenerica extends AbstractEntity<Long>{

@NotBlank
@Size(min=11, max=14)
@Column(name="cpf", unique=true, nullable=false, length=14)
private String cpf;

@NotBlank
@Size(min=3, max=60)
@Column(name="nome", unique=true, nullable=false, length=60)
private String nome;

@ManyToMany 
private List<Papel> papeis; 
//@JoinTable(name="PESSOA_PAPEL", 
//		   joinColumns= @JoinColumn(name="PAPEL_ID"),
//           inverseJoinColumns= @JoinColumn(name="PESSOA_ID"))

	
@OneToMany(mappedBy="pessoaGenerica")
private List<Receita> receitas;

public List<Receita> getReceitas() {
	return receitas;
}

public void setReceitas(List<Receita> receitas) {
	this.receitas = receitas;
}

public List<Papel> getPapeis()
{ 
  return papeis; 
} 

public void setPapeis(List<Papel> papeis) 
{ 
  this.papeis = papeis; 
} 

public String getCpf() 
{ 
  return cpf; 
} 

public void setCpf(String cpf) 
{ 
  this.cpf = cpf; 
}

public String getNome() 
{ 
  return nome; 
} 
public void setNome(String nome) 
{ 
  this.nome = nome; 
}
}
