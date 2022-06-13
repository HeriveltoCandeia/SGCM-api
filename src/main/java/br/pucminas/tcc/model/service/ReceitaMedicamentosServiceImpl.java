//package br.pucminas.tcc.model.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.pucminas.tcc.model.dao.ReceitaDao;
//import br.pucminas.tcc.model.dao.ReceitaMedicamentosDao;
//import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;
//
//@Service @Transactional(readOnly = false)
//public class ReceitaMedicamentosServiceImpl implements ReceitaMedicamentosService {
//	
//	@Autowired
//	private ReceitaMedicamentosDao dao;
//
//	@Override
//	public void salvar(ReceitasMedicamentosReceita receita) {
//		dao.save(receita);
//	}
//
//	@Override
//	public void editar(ReceitasMedicamentosReceita receita) {
//		dao.update(receita);		
//	}
//
//	@Override
//	public void excluir(Long id, Long id_medicamento) {
//		dao.delete(id);		
//	}
//
//	@Override
//	public ReceitasMedicamentosReceita buscarPorId(Long id) {
//		return dao.findById(id);
//	}
//
////	@Override
////	public List<ReceitasMedicamentosReceita> buscarTodos() {
////		return dao.findAll();
////	}
////
////	@Override
////	public List<Receita> buscarPorMedicamentoId(Long id) {
////		return dao.findByMedicamentoId(id);
////	}
////	
////	@Override
////	public List<Receita> buscarPorPessoa(Long id) {
////		return dao.findByPessoaId(id);
////	}
////
////	@Override
////	public void excluirMedicamento(Long id_receita, Long id_medicamento) {
////		dao.deleteMedicamento(id_receita, id_medicamento);
////	}
//	
//}
