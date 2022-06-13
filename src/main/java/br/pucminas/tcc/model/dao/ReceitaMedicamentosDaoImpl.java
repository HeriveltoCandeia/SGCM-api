//package br.pucminas.tcc.model.dao;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;
//
//@Repository
//public class ReceitaMedicamentosDaoImpl extends AbstractDao<ReceitasMedicamentosReceita, Long> 
//implements ReceitaMedicamentosDao{
////	@Override
//	public List<ReceitasMedicamentosReceita> findByMedicamentoReceitaId(Long id) {
//		return createQuery("select c.medicamentos_receita_id, d.descricao from ReceitasMedicamentosReceita  c, Medicamentos d where c.medicamentos_receita_id = d.id and c.receitas_Id = ?1", id);
//	}
//	
//	@Override
//	public List<ReceitasMedicamentosReceita> findByPessoaId(Long id) {
//		return createQuery("select d from ReceitasMedicamentosReceita  d where d.pessoa.id = ?1", id);
//	}
//
//	@Override
//	public void deleteMedicamento(Long id_receita, Long id_medicamento) {
//		createQuery("delete from receitas_medicamentos_receita  d where d.pessoa.id = ?1", id_receita, id_medicamento);
//	}
//	
//}
