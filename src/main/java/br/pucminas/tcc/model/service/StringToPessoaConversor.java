package br.pucminas.tcc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.model.entity.Pessoa;

@Component
public class StringToPessoaConversor implements Converter<String, Pessoa>{

	@Autowired
	private PessoaService service;	
	
	@Override
	public Pessoa convert(String source) {
		if(source.isEmpty())
			return null;
		Long id = Long.valueOf(source);
		return service.buscarPorId(id);
	}

}
