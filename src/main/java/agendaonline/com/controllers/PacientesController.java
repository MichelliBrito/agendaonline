package agendaonline.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import agendaonline.com.models.Convenio;
import agendaonline.com.models.Paciente;
import agendaonline.com.models.Prontuario;
import agendaonline.com.repositories.ConvenioRepository;
import agendaonline.com.repositories.PacienteRepository;
import agendaonline.com.repositories.ProntuariosRepository;

@Controller
public class PacientesController {//terminar, colocar remove e edite

	@Autowired
	private PacienteRepository pr;
	
	@Autowired
	private ConvenioRepository cr;
	
	@Autowired
	private ProntuariosRepository prr;
	
	@RequestMapping(value="/pacientes", method=RequestMethod.GET)
	public ModelAndView listaPacientes(Model model){
		ModelAndView mv = new ModelAndView("pacientes/listaPacientes");
		Iterable<Paciente> listaPacientes = pr.findAll();
		mv.addObject("pacientes", listaPacientes);
		
		Iterable<Convenio> listaConvenio = cr.findAll();
		model.addAttribute("convenios", listaConvenio);
		
		return mv;
	}
	
	@RequestMapping(value="/pacientes", method=RequestMethod.POST)
	public String listaPacientes(Paciente paciente, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//			attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
//			return cadastrarPaciente();
//		}
		pr.save(paciente);
		System.out.println(paciente.getConvenio());
		return "redirect:/pacientes";
	}
	
	@RequestMapping(value="/paciente/{nome}", method = RequestMethod.GET)
	public ModelAndView detalhes(@PathVariable("nome") String nome){

		ModelAndView mv = new ModelAndView("pacientes/pacienteDetalhes");
		Paciente paciente = pr.findByNome(nome);
		mv.addObject("paciente", paciente);
		
		Iterable<Prontuario> prontuarios = prr.findByPaciente(paciente);
		mv.addObject("prontuarios", prontuarios);
		
		return mv;
	}
}
