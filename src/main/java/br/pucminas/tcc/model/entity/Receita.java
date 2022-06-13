package br.pucminas.tcc.model.entity;

import java.time.LocalDate;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.pucminas.tcc.model.service.MedicamentoService;

@SuppressWarnings("serial")
@Entity
@Table(name = "RECEITAS")
public class Receita extends AbstractEntity<Long>{

@NotNull
@DateTimeFormat(iso=ISO.DATE, pattern = "")
@Column(name="data", nullable=false, columnDefinition = "DATE")
private LocalDate data;
	
@NotBlank
@Size(max=240)
@Column(name="orientacoesGerais", nullable=true, length=240)
private String orientacoesGerais;

//@JoinColumn(name = "id_paciente", unique=true, nullable = false, updatable = false)


@ManyToOne
private Pessoa pessoa; 

//@OneToMany(mappedBy = "receita")
//Set<ReceitasMedicamentosReceita> ratings;

////@ManyToMany //(mappedBy="receitas", cascade = CascadeType.ALL)
////@JoinTable(name="receitas_medicamentos_receita", 
////joinColumns= {@JoinColumn(name="receitas_id")},
////inverseJoinColumns= {@JoinColumn(name="medicamentos_receita_id")})
////private List<Medicamento> medicamentosReceita; 

//public Set<ReceitasMedicamentosReceita> getRatings() {
//	return ratings;
//}
//
//public void setRatings(Set<ReceitasMedicamentosReceita> ratings) {
//	this.ratings = ratings;
//}

public Pessoa getPessoa() {
	return pessoa;
}

public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
}

//public List<Medicamento> getMedicamentosReceita()
//{ 
//  return medicamentosReceita; 
//} 
//
//public void setMedicamentosReceita(List<Medicamento> medicamentosReceita) 
//{ 
//  this.medicamentosReceita = medicamentosReceita; 
//} 

public String getOrientacoesGerais() 
{ 
  return orientacoesGerais; 
}

public void setOrientacoesGerais(String orientacoesGerais) 
{ 
  this.orientacoesGerais = orientacoesGerais; 
}

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
}

}
