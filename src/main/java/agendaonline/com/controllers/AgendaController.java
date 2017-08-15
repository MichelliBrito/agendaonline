package agendaonline.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import agendaonline.com.models.Consulta;
import agendaonline.com.models.Paciente;
import agendaonline.com.models.Procedimento;
import agendaonline.com.repositories.ConsultaRepository;
import agendaonline.com.repositories.PacienteRepository;
import agendaonline.com.repositories.ProcedimentoRepository;

@Controller
public class AgendaController {
	
	@Autowired
	private ProcedimentoRepository pr;
	
	@Autowired
	private ConsultaRepository cr;
	
	@Autowired
	private PacienteRepository par;
	
	@RequestMapping("/agenda")
	public ModelAndView agenda(){
		ModelAndView mv = new ModelAndView("agenda/agenda");
		Iterable<Consulta> listaConsultas = cr.findAll();
		mv.addObject("consultas", listaConsultas);
		return mv;
	}
	
	@RequestMapping(value="/agendarconsulta", method=RequestMethod.GET)
	public String agendarConsulta(Model model){
		Iterable<Procedimento> listaProcedimentos = pr.findAll();
		model.addAttribute("procedimentos", listaProcedimentos);
		Iterable<Paciente> listaPacientes = par.findAll();
		model.addAttribute("pacientes", listaPacientes);
		return "agenda/agendarConsulta";
	}
	
	@RequestMapping(value="/agendarconsulta", method=RequestMethod.POST)
	public String agendarConsulta(Consulta consulta, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//		attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
//		return cadastrarPaciente();
//	}		
		cr.save(consulta);
		return "redirect:/agenda";
	}

}
