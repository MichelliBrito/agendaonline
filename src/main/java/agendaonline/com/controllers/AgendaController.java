package agendaonline.com.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import agendaonline.com.models.Prontuario;
import agendaonline.com.repositories.ConsultaRepository;
import agendaonline.com.repositories.EventoRepository;
import agendaonline.com.repositories.PacienteRepository;
import agendaonline.com.repositories.ProcedimentoRepository;
import agendaonline.com.repositories.ProntuariosRepository;

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
	
	@Autowired
	private ProntuariosRepository prr;
	
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public ModelAndView MontaAgenda(Model model) {
		 
		ModelAndView mv = new ModelAndView("agenda/agenda");

		Iterable<Procedimento> listaProcedimentos = pr.findAll();
		model.addAttribute("procedimentos", listaProcedimentos);
		Iterable<Paciente> listaPacientes = par.findAll();
		model.addAttribute("pacientes", listaPacientes);
		
		return mv;
	}
	
	@RequestMapping(value="/agenda", method=RequestMethod.POST)
	public String MontaAgenda(Consulta consulta){
		cr.save(consulta);
		Evento evento = new Evento(consulta);
		er.save(evento);
		return "redirect:/agenda";
	}
	
	@RequestMapping(value="/getEventos.json", method = RequestMethod.GET)
	public @ResponseBody Iterable<Evento> agenda(){
		
		Iterable<Evento> listaEventos = er.findAll();
		
		return listaEventos;
	}
	
	@RequestMapping(value="/consulta/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesConsulta(@PathVariable("codigo") long codigo){
		ModelAndView mv = new ModelAndView("agenda/consultaDetalhes");
		Consulta consulta = cr.findByCodigo(codigo);
		mv.addObject("consulta", consulta);
		return mv;
	}
	
//	@RequestMapping(value="/prontuario/{codigo}", method = RequestMethod.GET)
//	public ModelAndView formProntuario(@PathVariable("codigo") long codigo){
//		ModelAndView mv = new ModelAndView("prontuario/form");
//		Consulta consulta = cr.findByCodigo(codigo);
//		mv.addObject("consulta", consulta);
//		return mv;
//	}
	
	@RequestMapping(value="/consulta/{codigo}", method = RequestMethod.POST)
	public String formProntuarioPost(@PathVariable("codigo") long codigo,  Prontuario prontuario, BindingResult result, RedirectAttributes attributes){
	
		Consulta consulta = cr.findByCodigo(codigo);
		
		
		Paciente paciente = consulta.getPaciente();
		prontuario.setPaciente(paciente);
		
		Procedimento procedimento = consulta.getProcedimento();
		prontuario.setProcedimento(procedimento);
		
		LocalDateTime now = LocalDateTime.now();
		String data = now.toString();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String newData = formatter.format(now);
		
		prontuario.setData(newData);
		
		prr.save(prontuario);
		
		return "redirect:/consulta/{codigo}";
	}
	
}
