package br.pucminas.tcc.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.MedicamentosReceita;
import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;

@Repository
public class MedicamentosReceitaDaoImpl extends AbstractDao<MedicamentosReceita, Long> 
implements MedicamentosReceitaDao{
//	@Override
	ArrayList<MedicamentosReceita> teste = new ArrayList<>();
	

	public List<MedicamentosReceita> findByMedicamentosReceitaId(Long id) {
		List <MedicamentosReceita> Retorno = createQuery("select c from MedicamentosReceita c where c.receitas_Id = ?1", id);
		return Retorno;

	}
		
	
}
