package agendaonline.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import agendaonline.com.models.Convenio;
import agendaonline.com.models.Paciente;
import agendaonline.com.repositories.ConvenioRepository;
import agendaonline.com.repositories.PacienteRepository;

@Controller
public class PacientesController {

	@Autowired
	private PacienteRepository pr;
	
	@Autowired
	private ConvenioRepository cr;
	
	@RequestMapping("/pacientes")
	public ModelAndView listaPacientes(){
		ModelAndView mv = new ModelAndView("pacientes/listaPacientes");
		Iterable<Paciente> listaPacientes = pr.findAll();
		mv.addObject("pacientes", listaPacientes);
		return mv;
	}
	
	@RequestMapping(value="/cadastrarpaciente", method=RequestMethod.GET)
	public String cadastrarPaciente(Model model){
		Iterable<Convenio> listaConvenio = cr.findAll();
		model.addAttribute("convenios", listaConvenio);
		return "pacientes/cadastrarPaciente";
	}
	
	@RequestMapping(value="/cadastrarpaciente", method=RequestMethod.POST)
	public String cadastrarPaciente(Paciente paciente, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//			attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
//			return cadastrarPaciente();
//		}
		pr.save(paciente);
		System.out.println(paciente.getConvenio());
		return "redirect:/pacientes";
	}
}
