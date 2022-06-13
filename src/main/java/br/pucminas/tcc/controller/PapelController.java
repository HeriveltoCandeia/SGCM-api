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

import br.pucminas.tcc.model.entity.Papel;
import br.pucminas.tcc.model.service.PapelService;

@Controller
@RequestMapping("/papeis")
public class PapelController {
	
	@Autowired
	private PapelService service;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("papeis",service.buscarTodos());
		return "papel/lista";
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Papel papel) {
		return "papel/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Papel papel, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "papel/cadastro";
		}
		
		service.salvar(papel);
		attr.addFlashAttribute("success","Papel inserida com sucessso!");
		return "redirect:/papeis/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("papel", service.buscarPorId(id));
		return "papel/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Papel papel, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "papel/cadastro";
		}
		
		service.editar(papel);
		attr.addFlashAttribute("success","Papel alterada com sucessso!");
		return "redirect:/papeis/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {	
		service.excluir(id);
		attr.addFlashAttribute("success","Papel excluida com sucessso!");
		return "redirect:/papeis/listar";
	}

}
