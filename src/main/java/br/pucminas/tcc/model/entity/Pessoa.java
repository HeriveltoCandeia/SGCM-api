package br.pucminas.tcc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PESSOAS")
public class Pessoa extends AbstractEntity<Long>{

@NotBlank
@Size(min=11, max=14)
@Column(name="cpf", unique=true, nullable=false, length=14)
private String cpf;

@NotBlank
@Size(min=3, max=60)
@Column(name="nome", nullable=false, length=60)
private String nome;

@NotBlank
@Size(min=1, max=3)
@Column(name="sexo", nullable=false, length=3)
private String sexo;

@NotBlank
@Size(min=8, max=10)
@Column(name="dataNascimento", nullable=false, length=10)
private String dataNascimento;

@NotBlank
@Size(max=60)
@Column(name="email", nullable=false, length=60)
private String email;

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

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getDataNascimento() {
	return dataNascimento;
}

public void setDataNascimento(String dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

}
