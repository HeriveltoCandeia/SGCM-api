package br.pucminas.tcc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.model.entity.PessoaGenerica;

@Component
public class StringToPessoaConversor implements Converter<String, PessoaGenerica>{

	@Autowired
	private PessoaService service;	
	
	@Override
	public PessoaGenerica convert(String source) {
		if(source.isEmpty())
			return null;
		Long id = Long.valueOf(source);
		return service.buscarPorId(id);
	}

}
