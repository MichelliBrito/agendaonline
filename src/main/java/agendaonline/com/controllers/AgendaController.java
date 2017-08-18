package agendaonline.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import agendaonline.com.models.Consulta;
import agendaonline.com.models.Evento;
import agendaonline.com.models.Paciente;
import agendaonline.com.models.Procedimento;
import agendaonline.com.repositories.ConsultaRepository;
import agendaonline.com.repositories.EventoRepository;
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
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String Teste() {

		return "dashboard";
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public ModelAndView MontaAgenda() {
		 
		ModelAndView mv = new ModelAndView("agenda/agenda");

		return mv;
	}
	
	@RequestMapping(value="/getEventos.json", method = RequestMethod.GET)
	public @ResponseBody Iterable<Evento> agenda(){
		
		Iterable<Evento> listaEventos = er.findAll();
		
		return listaEventos;
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
		Evento evento = new Evento(consulta);
		er.save(evento);
		return "redirect:/agenda";
	}
	
	@RequestMapping(value="/consulta/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesConsulta(@PathVariable("codigo") long codigo){
		ModelAndView mv = new ModelAndView("agenda/consultaDetalhes");
		
		return mv;
	}

}
