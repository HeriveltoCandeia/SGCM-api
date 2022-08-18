package br.pucminas.tcc.model.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.AgendaMedica;

@Repository
public class AgendaMedicaRepositoryRest2 extends AbstractDao<AgendaMedica, Long> 
{
		
	public List<AgendaMedica> buscarVencidos(){
		Date dataAtu = new Date();
		LocalDate dtAtu = LocalDate.of(dataAtu.getYear()+1900, dataAtu.getMonth()+1, dataAtu.getDate());
		LocalTime hrAtu = LocalTime.of(dataAtu.getHours(), dataAtu.getMinutes()-1);
		LocalDateTime dataHora = LocalDateTime.of(dtAtu, hrAtu);	
		List<AgendaMedica> listaAtualizar;
		listaAtualizar = createQuery("select d from AgendaMedica d where d.codigoSituacao=1 and d.dataAgenda <= ?1", dataHora);
		return listaAtualizar;
	}
	
}
