package br.pucminas.tcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.pucminas.tcc.model.entity.Pessoa;
import br.pucminas.tcc.model.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas",service.buscarTodos());
		return "pessoa/lista";
	}

	@GetMapping("/papel/{id}")
	public String papel(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoas",service.buscarPorPapelId(id));
		return "pessoa/lista";
	}	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "pessoa/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "pessoa/cadastro";
		}
		
		service.salvar(pessoa);
		attr.addFlashAttribute("success","Pessoa inserida com sucessso!");
		return "redirect:/pessoas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", service.buscarPorId(id));
		return "pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "pessoa/cadastro";
		}
		
		service.editar(pessoa);
		attr.addFlashAttribute("success","Pessoa alterada com sucessso!");
		return "redirect:/pessoas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {	
		service.excluir(id);
		attr.addFlashAttribute("success","Pessoa excluida com sucessso!");
		return "redirect:/pessoas/listar";
	}

}
