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
import br.pucminas.tcc.model.entity.PessoaGenerica;
import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;
import br.pucminas.tcc.model.service.MedicamentoService;
import br.pucminas.tcc.model.service.MedicamentosReceitaService;
import br.pucminas.tcc.model.service.PessoaService;
//import br.pucminas.tcc.model.service.ReceitaMedicamentosService;
import br.pucminas.tcc.model.service.ReceitaService;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaService service;
	@Autowired
	private MedicamentosReceitaService serviceM;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("receitas",service.buscarTodos());
		return "receita/lista";
	}

	@GetMapping("/medicamento/{id}")
	public String medicamento(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("receitas",service.buscarPorMedicamentoId(id));
		return "receita/lista";
	}	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Receita receita) {
		return "receita/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Receita receita, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "receita/cadastro";
		}
		
		service.salvar(receita);
		attr.addFlashAttribute("success","Receita inserida com sucessso!");
		return "redirect:/receitas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("receita", service.buscarPorId(id));
		model.addAttribute("medicamentosReceita",serviceM.buscarPorId(id));
		return "receita/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Receita receita, BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "receita/cadastro";
		}
		
		service.editar(receita);
		attr.addFlashAttribute("success","Receita alterada com sucessso!");
		return "redirect:/receitas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {	
		service.excluir(id);
		attr.addFlashAttribute("success","Receita excluida com sucessso!");
		return "redirect:/receitas/listar";
	}

	@GetMapping("/excluir_medicamento/{id_receita, id_medicamento}")
	public String excluir_medicamento(@PathVariable("id_receita") Long id_receita, @PathVariable("id_medicamento") Long id_medicamento, RedirectAttributes attr) {	
		service.excluirMedicamento(id_receita, id_medicamento);
		attr.addFlashAttribute("success","Receita excluida com sucessso!");
		return "redirect:/receitas/listar";
	}

	
//	@ModelAttribute("pessoas")
//	public List<Pessoa> getPessoas(){
//		return pessoaService.buscarTodos();
//	}
//	
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
