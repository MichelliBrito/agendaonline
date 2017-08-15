package agendaonline.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import agendaonline.com.models.Procedimento;
import agendaonline.com.repositories.ProcedimentoRepository;

@Controller
public class ProcedimentosController {

	@Autowired
	private ProcedimentoRepository pr;
	
	@RequestMapping("/procedimentos")
	public ModelAndView listaProcedimentos(){
		ModelAndView mv = new ModelAndView("procedimentos/listaProcedimentos");
		Iterable<Procedimento> listaProcedimentos = pr.findAll();
		mv.addObject("procedimentos", listaProcedimentos);
		return mv;
	}
	
	@RequestMapping(value="/cadastroprocedimento", method=RequestMethod.GET)
	public String cadastroProcedimento(){
		return "procedimentos/cadastroProcedimento";
	}
	
	@RequestMapping(value="/cadastroprocedimento", method=RequestMethod.POST)
	public String cadastroProcedimento(Procedimento procedimento, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
			return cadastroProcedimento();
		}
		pr.save(procedimento);
		return "redirect:/procedimentos";
	}
}
