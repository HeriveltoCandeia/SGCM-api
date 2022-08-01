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
@Column(name="descricao", nullable=false, unique=true, length=30)
private String descricao;

@JsonIgnore
@JsonBackReference	
@OneToMany(mappedBy = "medicamento")
private List<ProntuarioMedicamento> prontuarioMedicamentos;

//@JoinTable(name="RECEITA_MEDICAMENTO", 
//joinColumns= {@JoinColumn(name="RECEITA_ID")},
//inverseJoinColumns= {@JoinColumn(name="MEDICAMENTO_ID")})

//@OneToMany(mappedBy = "receita")
//Set<ReceitasMedicamentosReceita> ratings;


//@ManyToMany(mappedBy="medicamentosReceita")//cascade = CascadeType.ALL) 
//private List<Receita> receitas; 

//public List<Receita> getReceitas()
//{ 
//  return receitas; 
//} 
//
//public void setReceitas(List<Receita> receitas) 
//{ 
//  this.receitas = receitas; 
//} 

public String getDescricao() 
{ 
  return descricao; 
} 
public void setDescricao(String descricao) 
{ 
  this.descricao = descricao; 
}
}
