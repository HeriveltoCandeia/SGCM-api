package br.pucminas.tcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.MedicamentosReceita;
import br.pucminas.tcc.model.service.MedicamentoService;
import br.pucminas.tcc.model.service.MedicamentosReceitaService;

@Controller
@RequestMapping("/medicamentosReceita")
public class MedicamentoReceitaController {
	
	@Autowired
	private MedicamentosReceitaService service;
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("medicamentosReceita",service.buscarTodos());
		return "medicamentoReceita/lista";
	}

	@GetMapping("/listar-Rest")
	public List<MedicamentosReceita> listarRest() {
		List<MedicamentosReceita> lista = service.buscarTodos();
		return lista;
	}	
	
	@GetMapping("/cadastrar")
	public String cadastrar(MedicamentosReceita medicamento) {
		return "medicamentoReceita/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid MedicamentosReceita medicamento, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "medicamentoReceita/cadastro";
		}
		
		service.salvar(medicamento);
		attr.addFlashAttribute("success","Medicamento inserido com sucessso!");
		return "redirect:/medicamentosReceita/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("medicamentoReceita", service.buscarPorId(id));
		return "medicamentoReceita/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid MedicamentosReceita medicamento, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "medicamentoReceita/cadastro";
		}
		
		service.editar(medicamento);
		attr.addFlashAttribute("success","Medicamento alterada com sucessso!");
		return "redirect:/medicamentosReceita/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {	
		service.excluir(id);
		attr.addFlashAttribute("success","Medicamento excluida com sucessso!");
		return "redirect:/medicamentosReceita/listar";
	}
	
//	@ModelAttribute("medicamentos")
//	public List<Medicamento> getMedicamentos(){
//		return medicamentoService.buscarTodos();
//	}
//	
//	public String getMedicamentosReceita(Long id){	
//		String retorno = medicamentoService.buscarPorId(id).getDescricao();
//		return retorno;
//	}

}
