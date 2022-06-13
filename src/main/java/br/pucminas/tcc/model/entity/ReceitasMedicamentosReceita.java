//package br.pucminas.tcc.model.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//@Entity
//public class ReceitasMedicamentosReceita implements Serializable{
//
////	@EmbeddedId
////	ReceitasMedicamentosReceitaKey id;
////	
////    @ManyToOne
////    @MapsId("receitasid")
////    @JoinColumn(name = "receitas_Id")
////    Receita receita;
////	
////    @ManyToOne
////    @MapsId("medicamentosReceitaId")
////    @JoinColumn(name = "medicamentos_receita_id")
////    Medicamento medicamento;
//
//	@Size(max=1000)
//	@Column(name="forma_uso", nullable=false, length=1000)
//	private String forma_uso;
//
////	public ReceitasMedicamentosReceitaKey getId() {
////		return id;
////	}
////
////	public void setId(ReceitasMedicamentosReceitaKey id) {
////		this.id = id;
////	}
////
////	public Receita getReceita() {
////		return receita;
////	}
////
////	public void setReceita(Receita receita) {
////		this.receita = receita;
////	}
//
////	public Medicamento getMedicamento() {
////		return medicamento;
////	}
////
////	public void setMedicamento(Medicamento medicamento) {
////		this.medicamento = medicamento;
////	}
//
//	public String getForma_uso() {
//		return forma_uso;
//	}
//
//	public void setForma_uso(String forma_uso) {
//		this.forma_uso = forma_uso;
//	}
//}
