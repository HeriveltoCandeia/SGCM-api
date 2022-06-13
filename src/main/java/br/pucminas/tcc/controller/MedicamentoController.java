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

import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.service.MedicamentoService;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("medicamentos",service.buscarTodos());
		return "medicamento/lista";
	}

	@GetMapping("/listar-Rest")
	public List<Medicamento> listarRest() {
		List<Medicamento> lista = service.buscarTodos();
		return lista;
	}	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Medicamento medicamento) {
		return "medicamento/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Medicamento medicamento, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "medicamento/cadastro";
		}
		
		service.salvar(medicamento);
		attr.addFlashAttribute("success","Medicamento inserido com sucessso!");
		return "redirect:/medicamentos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("medicamento", service.buscarPorId(id));
		return "medicamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Medicamento medicamento, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "medicamento/cadastro";
		}
		
		service.editar(medicamento);
		attr.addFlashAttribute("success","Medicamento alterada com sucessso!");
		return "redirect:/medicamentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {	
		service.excluir(id);
		attr.addFlashAttribute("success","Medicamento excluida com sucessso!");
		return "redirect:/medicamentos/listar";
	}

}
